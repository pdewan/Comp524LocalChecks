package gradingTools.comp524f19.assignment4.eager.basic;

import static org.junit.Assert.assertTrue;

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
public class EarlyJoinBasicJoiner extends PassFailJUnitTestCase {
	
	protected Joiner joiner;
	protected int joinerCount = 4;
	protected int taskCount = 0;
	protected long slaveTimeout;
	protected long masterTimeout;
	protected Joiner timingOutJoiner;

	protected void setTimeouts() {
		slaveTimeout = 300;
		masterTimeout = 0;
	}
	
	protected TestCaseResult doJoinTest() {
//		for (int i =0; i < joinerCount; i++) {
//			new Thread (()-> {doSlaveTask();}).start();
//		}
//		return doMasterTask();
		return parallelInc();
		
	}
	protected TestCaseResult parallelInc() {
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
	
	protected void createJoiner() {
		ImmmutableJoinerClassProvided aCheckClass = (ImmmutableJoinerClassProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(ImmmutableJoinerClassProvided.class);
		if (aCheckClass == null) {
			assertTrue("No check class found", false);
		}
		Class aJoinerClass = aCheckClass.getImmutableJoinerClass();
		if (aJoinerClass == null) {
			assertTrue("No Joiner class found", false);
		}
		Class[] aConstructorArgTypes = {Integer.TYPE};
		try {
			Constructor aJoinerConstructor = aJoinerClass.getConstructor(aConstructorArgTypes);
		     Object[] anArgs = {joinerCount};
			joiner = (Joiner) aJoinerConstructor.newInstance(anArgs);
			timingOutJoiner = 	(Joiner) BasicProjectIntrospection.createTimingOutProxy(Joiner.class, joiner);

		
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			assertTrue("No constructor with single int argument in joiner class:" + aJoinerClass, false);
		}
	}

	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		createJoiner();
		setTimeouts();
		TestCaseResult retVal = doJoinTest();
		return retVal;
//		ImmmutableJoinerClassProvided aCheckClass = (ImmmutableJoinerClassProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(ImmmutableJoinerClassProvided.class);
//		if (aCheckClass == null) {
//			return fail("No check class found");
//		}
//		Class aJoinerClass = aCheckClass.getImmutableJoinerClass();
//		if (aJoinerClass == null) {
//			return fail("No Joiner class found");
//
//		}
//		Class[] aConstructorArgTypes = {Integer.TYPE};
//		try {
//			Constructor aJoinerConstructor = aJoinerClass.getConstructor(aConstructorArgTypes);
//		     Object[] anArgs = {joinerCount};
//			joiner = (Joiner) aJoinerConstructor.newInstance(anArgs);
//			timingOutJoiner = 	(Joiner) BasicProjectIntrospection.createTimingOutProxy(Joiner.class, joiner);
//
//		
//		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//			return fail("No constructor with single int argument in joiner class:" + aJoinerClass);
//		}
		
	}

}
