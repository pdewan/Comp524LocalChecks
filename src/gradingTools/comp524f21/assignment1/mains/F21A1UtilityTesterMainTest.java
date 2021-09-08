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
import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.UtilityTesterMainTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityTesterMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.CompareSafetyComputationsTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintGeneratedCombinationDerivedSafetyTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintGivenAndGeneratedCombinationsInferredSafety;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintSafeDistancesAndDurationsTest;
import util.annotations.MaxValue;
@MaxValue(5)
public class F21A1UtilityTesterMainTest extends UtilityTesterMainTest {
	public static final int TIME_OUT_MSECS = 300; // secs
	
	protected Class [] PRECEDING_TESTS = {
		PrintGeneratedCombinationDerivedSafetyTest.class,
		PrintSafeDistancesAndDurationsTest.class
	};
	
	@Override
	protected Class [] precedingTests() {
		return PRECEDING_TESTS;
	}
	
	public F21A1UtilityTesterMainTest() {
	}
	
	
	protected String [] regexList= {
	    	"[Dd]istance,[Dd]uration,[Ee]xhalation,[Ii]sSafe.*",
	    	"30,\\[\\{\\d+,\\d+\\}[,]*\\{\\d+,\\d+\\}[,]*\\{\\d+,\\d+\\}\\].*",
	    	"29,\\[\\{\\d+,\\d+\\}[,]*\\{\\d+,\\d+\\}[,]*\\{\\d+,\\d+\\}\\].*",
	    	"32,\\[\\{\\d+,\\d+\\}[,]*\\{\\d+,\\d+\\}\\].*"
	    };
	@Override
	protected String [] getRegexList() {
	    return regexList;
	}
	
    protected String [] methodTestName= {
    		"PrintGeneratedCombinationDerivedSafety",
    		"PrintSafeDistancesAndDurations with args Medium exhalation",
    		"PrintSafeDistancesAndDurations with args Medium exhalation -1",
    		"PrintSafeDistancesAndDurations with args Medium exhalation +2"
    };
    @Override
	protected String[] getMethodNameList() {
		return methodTestName;
	}
}
