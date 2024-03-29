package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityProvided;
import util.annotations.MaxValue;
@MaxValue(15)
public class GenerateSafeDistancesAndDurationsTest extends PassFailJUnitTestCase {
	public static final int TIME_OUT_MSECS = 100; // secs
	
	protected static Object[][] arguments= {
			{9}, //<small 
			{0},
			{5},
			{10},
			
			{11}, //small to medium
			{29},
			{17},
			{30},
			
			{31}, //medium to large
			{49},
			{41},
			{50},
			
			{51}, //>large
			{70},
			{101},
			{Integer.MAX_VALUE}
			
	};
	protected Object[][] getArguments(){
		return arguments;
	}
	
	protected static int[][][] results= {
			{{6,30},{13,120}},
			{{6,30},{13,120}},
			{{6,30},{13,120}},
			{{6,30},{13,120}},
			
			{{13,30},{27,120},{6,15}},
			{{13,30},{27,120},{6,15}},
			{{13,30},{27,120},{6,15}},
			{{13,30},{27,120},{6,15}},
			
			{{27,30},{13,15}},
			{{27,30},{13,15}},
			{{27,30},{13,15}},
			{{27,30},{13,15}},
			
			{},
			{},
			{},
			{}
	};
	
	protected int[][][] getResults() {
		return results;
	}
	
	
	protected static Class[] parameterTypes= {Integer.TYPE};
	protected Class[] getParameterTypes() {
		return parameterTypes;
	}
	

	public GenerateSafeDistancesAndDurationsTest() {
	}

	protected static String methodName="generateSafeDistancesAndDurations";
	protected String methodName() {
		return methodName;
	}
	
	protected boolean verifyOutput(List<Integer[]> retVal, int [][] expected) {
		boolean [] anyOrderCheck = new boolean [expected.length];
		Arrays.fill(anyOrderCheck, false);
		for(Integer[] retValArray:retVal) {
			if(retValArray.length!=2) {
				System.out.println("An Integer Array was found not containing 2 values");
				return false;
			}
			boolean success=false;
			for(int i=0;i<expected.length;i++) {
				if(anyOrderCheck[i]) {
					continue;
				}
				if(retValArray[0]==expected[i][0]&&retValArray[1]==expected[i][1]) {
					anyOrderCheck[i]=true;
					success=true;
					break;
				}
			}
			if(!success) {
				System.out.println("Inncorrect Values Given");
				return false;
			}	
		}
		return true;
	}
	
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
		    int[][][] aResults = getResults();
		    int aNumSuccesses = 0;
		    
		    for (int anIndex = 0; anIndex < anArguments.length; anIndex++ ) {
		    	Object[] anInputCombination = anArguments[anIndex];
		    	int [][] anExpectedResult = aResults[anIndex];
		    	List<Integer[]> aRetVal =  (List<Integer[]>) BasicProjectExecution.timedInvoke(aUilityClass, aMethod, anInputCombination, TIME_OUT_MSECS);
			    if(aRetVal.size()!=anExpectedResult.length) {
			    	System.out.println("Expected size of returned list with args "+Arrays.toString(anInputCombination)+" is: "+anExpectedResult.length+" number given was "+aRetVal.size());
			    	continue;
			    }
		    	if (!verifyOutput(aRetVal,anExpectedResult)) {
		    		System.out.println("Expected retVal with args " + Arrays.toString(anInputCombination) + " did not return " + Arrays.toString(anExpectedResult));
			    } else {
			    	aNumSuccesses++;
			    }
		    }
		    
		    
		    
		    double aPercentage = ((double) aNumSuccesses)/aResults.length;
		    return aPercentage == 1?pass():partialPass(aPercentage, aNumSuccesses + " tests passed out of " +   aResults.length);  

		} catch ( Throwable e) {
			System.err.println("Not gradable cause:" + e);
			throw new NotGradableException("caused by:" +e.toString());
		}
	}
}
