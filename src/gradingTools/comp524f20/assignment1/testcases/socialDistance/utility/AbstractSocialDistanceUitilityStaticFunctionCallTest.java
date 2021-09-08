package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import java.lang.reflect.Method;
import java.util.Arrays;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityProvided;
public abstract class AbstractSocialDistanceUitilityStaticFunctionCallTest extends PassFailJUnitTestCase {
	public static final int TIME_OUT_MSECS = 100; // secs
	
	protected abstract Object[][] getArguments();
	protected abstract Object[] getResults();
	protected abstract Class[] getParameterTypes();


	protected boolean allTestsPassed;
	public boolean allTestsPassed() {
		return allTestsPassed;
	}
	
	public AbstractSocialDistanceUitilityStaticFunctionCallTest() {
	}

	protected abstract String methodName();
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
			SocialDistanceUtilityProvided aSocialDistanceUilityProvided = (SocialDistanceUtilityProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceUtilityProvided.class);
			Class aUilityClass = aSocialDistanceUilityProvided.getRequiredClass();
			
//			SocialDistanceClassRegistry aClassRegistry = aClassRegistryProvided.getTimingOutClassRegistryProxy();  
		    if (aUilityClass == null) {
		    	return fail ("No utility class");
		    }
		    Class[] aParameterTypes = getParameterTypes();
		    Method aMethod = aUilityClass.getMethod(methodName(), aParameterTypes);
		    Object[][] anArguments = getArguments();
		    Object[] aResults = getResults();
		    int aNumSuccesses = 0;
		    for (int anIndex = 0; anIndex < anArguments.length; anIndex++ ) {
		    	Object[] anInputCombination = anArguments[anIndex];
		    	Object anExpectedResult = aResults[anIndex];
			    Boolean aRetVal =  (Boolean) BasicProjectExecution.timedInvoke(aUilityClass, aMethod, anInputCombination, TIME_OUT_MSECS);
			    if (!anExpectedResult.equals(aRetVal )) {
		    		System.out.println("Expected retVal with args " + Arrays.toString(anInputCombination) + " did not return " + anExpectedResult);
			    } else {
			    	aNumSuccesses++;
			    }

		    }
		    double aPercentage = ((double) aNumSuccesses)/aResults.length;
		    allTestsPassed=aPercentage==1;
		    return aPercentage == 1?pass():partialPass(aPercentage, aNumSuccesses + " tests passed out of " +   aResults.length);  
		  

		} catch ( Throwable e) {
			throw new NotGradableException(e.toString());
		}
	}

}
