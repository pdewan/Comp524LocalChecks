package gradingTools.comp524f19.assignment4.eager.pool;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment4.eager.basic.EarlyJoinBasicJoinerNonReusing;
import gradingTools.comp524f19.assignment4.requiredClasses.MutableJoinerClassProvided;
import main.util.parallel.MutableJoiner;
import util.annotations.MaxValue;

@MaxValue(5)
public class EarlyJoinMutableJoinerNonReusing extends EarlyJoinBasicJoinerNonReusing {
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
			assertTrue("No argumentless constructor in joiner class:" + aJoinerClass, false);
		}
	}
}
