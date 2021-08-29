package gradingTools.comp524f21.assignment1.mains;

import java.lang.reflect.Method;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.ResultWithOutput;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityTesterMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.CompareSafetyComputationsTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintGeneratedCombinationDerivedSafetyTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintGivenAndGeneratedCombinationsInferredSafety;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintSafeDistancesAndDurationsTest;
import util.annotations.MaxValue;
@MaxValue(5)
public class F21A1UtilityTesterMainTest extends PassFailJUnitTestCase {
	public static final int TIME_OUT_MSECS = 300; // secs
	
	Class [] PRECEDING_TESTS = {
		PrintGeneratedCombinationDerivedSafetyTest.class,
		PrintSafeDistancesAndDurationsTest.class
	};
	
	@Override
	protected Class [] precedingTests() {
		return PRECEDING_TESTS;
	}
	
	public F21A1UtilityTesterMainTest() {
	}
	
	protected Class[] argumentTypes= {String[].class};
	protected Class[] argumentTypes() {
		return argumentTypes;
	}
	
	protected String[] strArgs= {};
	protected Object[] arguments= {strArgs};
	protected Object[] getArguments() {
		return arguments;
	}
	
	protected String methodName= "main";
	protected String methodName() {
		return methodName;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
			SocialDistanceUtilityTesterMainProvided aSocialDistanceUilityTesterMainProvided = (SocialDistanceUtilityTesterMainProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceUtilityTesterMainProvided.class);
			Class aUtilityTesterMainClass = aSocialDistanceUilityTesterMainProvided.getSocialDistanceMain();
			
		    if (aUtilityTesterMainClass == null) {
		    	return fail ("No utility class");
		    }
		    
//		    System.out.println("---------------------");
		    Class[] aParameterTypes = argumentTypes();
		    Method aMethod = aUtilityTesterMainClass.getMethod(methodName(), aParameterTypes);
		    Object[] anArguments = getArguments();
		    ResultWithOutput aResultWithOutput = BasicProjectExecution.timedInteractiveInvoke(aUtilityTesterMainClass, aMethod, anArguments, TIME_OUT_MSECS);
		    
		    String anOutput = aResultWithOutput.getOutput();
		    if (anOutput == null || anOutput.isEmpty() ) {
		    	return fail("No Output");
		    }

		    String [] parsedOutput=anOutput.split("\n");
		    int callsFound=0;
		    String [] regexList= {
		    	"[Dd]istance,[Dd]uration,[Ee]xhalation,[Ii]sSafe.*",
		    	"30,\\[\\{\\d+,\\d+\\}[,]*\\{\\d+,\\d+\\}[,]*\\{\\d+,\\d+\\}\\].*",
		    	"29,\\[\\{\\d+,\\d+\\}[,]*\\{\\d+,\\d+\\}[,]*\\{\\d+,\\d+\\}\\].*",
		    	"32,\\[\\{\\d+,\\d+\\}[,]*\\{\\d+,\\d+\\}\\].*"
		    };
		    String [] methodTestName= {
		    		"PrintGeneratedCombinationDerivedSafety",
		    		"PrintSafeDistancesAndDurations with args Medium exhalation",
		    		"PrintSafeDistancesAndDurations with args Medium exhalation -1",
		    		"PrintSafeDistancesAndDurations with args Medium exhalation +2"
		    };
		    
		    for(String line:parsedOutput) {
		    	if(line.matches(regexList[callsFound])) {
		    		callsFound++;
		    		if(callsFound==regexList.length)
		    			break;
		    	}
		    }

		    if(callsFound<regexList.length) {
		    	System.out.println("Missing call to "+methodTestName[callsFound]);
		    	System.out.println("Note make sure calls are in the order listed on the assingment document");
		    	return fail("View console output for more information");
		    }

		    return pass();
		} catch (Throwable e) {
			throw new NotGradableException(e.getMessage());
		}
	}
}
