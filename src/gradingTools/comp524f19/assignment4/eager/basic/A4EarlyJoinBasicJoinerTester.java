package gradingTools.comp524f19.assignment4.eager.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.BasicProjectIntrospection;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f19.assignment1.testcases.MainClassProvided;
import gradingTools.comp524f19.assignment4.requiredClasses.ImmmutableJoinerClassProvided;
import main.ClassRegistry;
import main.util.parallel.Joiner;
import util.annotations.MaxValue;
import util.misc.ThreadSupport;
import util.trace.Tracer;

@MaxValue(20)
public class A4EarlyJoinBasicJoinerTester extends PassFailJUnitTestCase {
	
	Joiner joiner;
	int joinerCount = 4;
	int taskCount = 0;
	long slaveTimeout;
	long masterTimeout;
	protected Joiner timingOutJoiner;

	protected void setTimeouts() {
		slaveTimeout = 300;
		masterTimeout = 0;
	}
	
	protected TestCaseResult doJoinTest() {
		for (int i =0; i < joinerCount; i++) {
			new Thread (()-> {doSlaveTask();}).start();
		}
		return doMasterTask();
		
	}
	
	protected synchronized void doSlaveTask() {
		taskCount++;
		ThreadSupport.sleep(slaveTimeout);
		Tracer.info(this, Thread.currentThread() + "before finished");
		timingOutJoiner.finished();
		Tracer.info(this, Thread.currentThread() + "after finished, taskCount=" + taskCount);
		
	}
	
	protected TestCaseResult doMasterTask() {
		try {
			ThreadSupport.sleep(masterTimeout);
			Tracer.info(this, Thread.currentThread() + "before join");
			timingOutJoiner.join();
			Tracer.info(this, Thread.currentThread() + "after join, taskCount =" + taskCount);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (taskCount == joinerCount) {
			return pass();
		}
		if (taskCount < joinerCount) {
			return fail("joiner finished early? taskCount:" + taskCount + " joinerCount:" + joinerCount);
		}
		return fail("taskCount:" + taskCount + " joinerCount:" + joinerCount);

	}

	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		ImmmutableJoinerClassProvided aCheckClass = (ImmmutableJoinerClassProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(ImmmutableJoinerClassProvided.class);
		if (aCheckClass == null) {
			return fail("No check class found");
		}
		Class aJoinerClass = aCheckClass.getImmutableJoinerClass();
		if (aJoinerClass == null) {
			return fail("No Joiner class found");

		}
		Class[] aConstructorArgTypes = {Integer.TYPE};
		try {
			Constructor aJoinerConstructor = aJoinerClass.getConstructor(aConstructorArgTypes);
		     Object[] anArgs = {joinerCount};
			joiner = (Joiner) aJoinerConstructor.newInstance(anArgs);
			timingOutJoiner = 	(Joiner) BasicProjectIntrospection.createTimingOutProxy(Joiner.class, joiner);

		
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return fail("No constructor with single int argument in joiner class:" + aJoinerClass);
		}
		setTimeouts();
		return doJoinTest();
	}

}
