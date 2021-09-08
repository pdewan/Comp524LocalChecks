package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import java.lang.reflect.Method;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import util.trace.Tracer;

public abstract class AbstractPrintDerivedSafetyValidator extends PassFailJUnitTestCase {
	public static final int TIME_OUT_MSECS = 300; // secs
	

	protected static  String verifyingMethodName = "isDerivedSafe";
	protected static Class[] NO_ARG_TYPES = {};
	protected static Class[] VERIFYING_ARG_TYPES = {Integer.TYPE, Integer.TYPE, Integer.TYPE};

	protected static Object[] NO_ARGS = {};

	protected  abstract String methodName();
	
	protected  String verifyingMethodName() {
		return verifyingMethodName;
	}
	
	protected  Class[] argumentTypes() {
		return NO_ARG_TYPES;
	}
	
	protected  Class[] verifyingArgumentTypes() {
		return VERIFYING_ARG_TYPES;
	}
	
	
	protected  Object[] getArguments() {
		return NO_ARGS;
	}

	protected boolean verify (String anOutput, Class aStaticClass, Method aVerifyingMethod) throws Throwable {
		String[] anOutputComponents = anOutput.split(",");
		if (anOutputComponents.length != 4) 
			throw new NotGradableException("Output does not have 4 command separated components");
		
		Integer aDistance = Integer.parseInt(anOutputComponents[0]);
		Integer aDuration = Integer.parseInt(anOutputComponents[1]);
		Integer anExhalationLevel =  Integer.parseInt(anOutputComponents[2]);
		Object[] anArgs = {aDistance, aDuration, anExhalationLevel};
		Boolean aResult = (Boolean) BasicProjectExecution.timedInvoke(aStaticClass, aVerifyingMethod, anArgs, TIME_OUT_MSECS);		


//		new line character is captured in the output. This had caused it to default to false.	
		Boolean anActualResult = anOutputComponents[3].toLowerCase().matches("true\n*?");
		boolean aReturnValue = aResult.equals(anActualResult);
		if (!aReturnValue) 
			Tracer.info("Expected result:" + aResult + " not equal to actual result:" + anActualResult +" for values: "+anOutput);
		return aReturnValue;
	}

	@Override
	public abstract TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException;
}
