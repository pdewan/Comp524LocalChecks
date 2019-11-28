package gradingTools.comp524f19.assignment4.eager.pool;

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
import gradingTools.comp524f19.assignment4.eager.basic.EarlyJoinBasicJoinerTester;
import gradingTools.comp524f19.assignment4.requiredClasses.ImmmutableJoinerClassProvided;
import gradingTools.comp524f19.assignment4.requiredClasses.MutableJoinerClassProvided;
import main.ClassRegistry;
import main.util.parallel.Joiner;
import main.util.parallel.MutableJoiner;
import util.annotations.MaxValue;
import util.misc.ThreadSupport;
import util.trace.Tracer;

@MaxValue(20)
public class EarlyJoinMutableJoinerTester extends EarlyJoinBasicJoinerTester {
	protected MutableJoiner mutableTimingOutJoiner;
	protected TestCaseResult doJoinTest() {

		TestCaseResult aFirstResult = parallelInc();
		if (!aFirstResult.isPass()) {
			return aFirstResult;
		}
		taskCount = 0;
		return parallelInc();
		
	}
	protected TestCaseResult parallelInc() {
		mutableTimingOutJoiner.setNumThreads(joinerCount);
		return super.parallelInc();
	}
	@Override
	protected void createJoiner() {
		MutableJoinerClassProvided aCheckClass = (MutableJoinerClassProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(MutableJoinerClassProvided.class);
		if (aCheckClass == null) {
			assertTrue("No check class found", false);
		}
		Class aJoinerClass = aCheckClass.getMutableJoinerClass();
		if (aJoinerClass == null) {
			assertTrue("No Joiner class found", false);
		}
		Class[] aConstructorArgTypes = {};
		try {
			Constructor aJoinerConstructor = aJoinerClass.getConstructor(aConstructorArgTypes);
		     Object[] anArgs = {};
			MutableJoiner mutableJoiner = (MutableJoiner) aJoinerConstructor.newInstance(anArgs);
			mutableTimingOutJoiner = 	(MutableJoiner) BasicProjectIntrospection.createTimingOutProxy(MutableJoiner.class, mutableJoiner);
			joiner = mutableJoiner;
			timingOutJoiner = mutableJoiner;

		
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			assertTrue("No constructor with single int argument in joiner class:" + aJoinerClass, false);
		}
	}
}
