package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import java.lang.reflect.Method;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.ResultWithOutput;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityProvided;
import util.annotations.MaxValue;
@MaxValue(7)
public class PrintGeneratedCombinationDerivedSafetyTest extends AbstractPrintDerivedSafetyValidator {
	public static final int TIME_OUT_MSECS = 300; // secs
	
	protected final String methodName = "printGeneratedCombinationDerivedSafety";
	protected static  String verifyingMethodName = "isDerivedSafe";

	public PrintGeneratedCombinationDerivedSafetyTest() {
	}
	@Override
	protected  String methodName() {
		return methodName;
	}
	
	@Override
	protected  String verifyingMethodName() {
		return verifyingMethodName;
	}
	
	protected boolean passing=false;
	public boolean isPassing() {
		return passing;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
			SocialDistanceUtilityProvided aSocialDistanceUilityProvided = (SocialDistanceUtilityProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceUtilityProvided.class);
			Class aUtilityClass = aSocialDistanceUilityProvided.getRequiredClass();
			
//			SocialDistanceClassRegistry aClassRegistry = aClassRegistryProvided.getTimingOutClassRegistryProxy();  
		    if (aUtilityClass == null) {
		    	return fail ("No utility class");
		    }
		    Class[] aParameterTypes = argumentTypes();
		    Method aMethod = aUtilityClass.getMethod(methodName(), aParameterTypes);
		    Object[] anArguments = getArguments();
		    ResultWithOutput aResultWithOutput1 = BasicProjectExecution.timedInteractiveInvoke(aUtilityClass, aMethod, anArguments, TIME_OUT_MSECS);
		    
		    String anOutput1 = aResultWithOutput1.getOutput().replaceAll("I\\*\\*\\*.*\n", "");
		    if (anOutput1 == null || anOutput1.isEmpty() ) {
		    	return fail("No Output");
		    }
		    
//		    String[] anOutputLines = anOutput.split("\n");
		    ResultWithOutput aResultWithOutput2 = BasicProjectExecution.timedInteractiveInvoke(aUtilityClass, aMethod, anArguments, TIME_OUT_MSECS);

		    String anOutput2 = aResultWithOutput2.getOutput().replaceAll("I\\*\\*\\*.*\n", "");
		    if (anOutput2 == null || anOutput2.isEmpty()) {
		    	return fail("No Output");
		    }
		    
		    if (anOutput1.equals(anOutput2)) {
		    	return fail("Two successive calls return same output");
		    }
		    Method aVerifyingMethod =  aUtilityClass.getMethod(verifyingMethodName(), verifyingArgumentTypes()); 
//		    Boolean aFirstValPassed = verify(anOutput1,aUtilityClass, aVerifyingMethod);
		    
		    passing=verify(anOutput1,aUtilityClass, aVerifyingMethod) && verify(anOutput2, aUtilityClass, aVerifyingMethod);
		    if (passing) {
		    	return pass();
		    }
		    return fail("One or more outputs of " + methodName() + " not consistent with result of method:" + verifyingMethodName);
//		    String[] anOutputLines = anOutput.split("\n");
		    

		} catch ( Throwable e) {
			System.err.println(e);
			throw new NotGradableException(e.toString());
		}
	}

}
