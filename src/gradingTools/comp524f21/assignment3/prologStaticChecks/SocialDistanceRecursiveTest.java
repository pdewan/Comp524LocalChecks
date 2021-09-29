package gradingTools.comp524f21.assignment3.prologStaticChecks;

import edu.unc.cs.comp524.parsers.prolog.Program;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f20.assignment2.ruleTests.listGenerateSafeDistancesAndDurations.ListGenerateSafeDistancesAndDurations_FalseValueTest;
import gradingTools.comp524f20.assignment2.ruleTests.listGenerateSafeDistancesAndDurations.ListGenerateSafeDistancesAndDurations_OutputGeneration;
import gradingTools.comp524f20.assignment2.ruleTests.listGenerateSafeDistancesAndDurations.ListGenerateSafeDistancesAndDurations_TrueValueTest;
import gradingTools.comp524f20.assignment2.ruleTests.listGivenSafeTests.ListGivenSafe_OutputGeneration;
import gradingTools.comp524f20.assignment2.ruleTests.listGivenSafeTests.ListGivenSafe_SafeTupleTest;
import gradingTools.comp524f20.assignment2.ruleTests.listGivenSafeTests.ListGivenSafe_ValuesTest;
import gradingTools.comp524f20.assignment2.ruleTests.printGivenCombinations.PrintGivenCombinatations_NonTableSizedInputs;
import gradingTools.comp524f20.assignment2.ruleTests.printGivenCombinations.PrintGivenCombinations_OutputGeneration;
import gradingTools.comp524f20.assignment2.ruleTests.printGivenCombinations.PrintGivenCombinations_TableSizedInputs;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(10)
@IsExtra(true)
public class SocialDistanceRecursiveTest extends PassFailJUnitTestCase{

	private Class [] PRECEDING_TESTS = {
			ListGivenSafe_OutputGeneration.class,
			ListGivenSafe_SafeTupleTest.class,
			ListGivenSafe_ValuesTest.class,
			PrintGivenCombinations_OutputGeneration.class,
			PrintGivenCombinations_TableSizedInputs.class,
			PrintGivenCombinatations_NonTableSizedInputs.class,
			ListGenerateSafeDistancesAndDurations_OutputGeneration.class,
			ListGenerateSafeDistancesAndDurations_FalseValueTest.class,
			ListGenerateSafeDistancesAndDurations_TrueValueTest.class,
	};
	
	@Override
	protected boolean failedTestVetoes() {
		return false;
	}
	
	@Override
	protected Class [] precedingTests() {
		return PRECEDING_TESTS;
	}
	
	private final String [] recursiveFunctionNames = {
		"listGenerateSafeDistancesAndDurations",
		"printGivenCombinations",
		"listGivenSafe",
	};
	
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException, NotGradableException {
		try {
			APrologProgramGenerator generator = (APrologProgramGenerator) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(APrologProgramGenerator.class);	
			Program program = generator.getProgram();
			if(program == null) 
				return fail("APrologProgramGenerator did not pass successfully");
			
			int count = 0;
			for(String function:recursiveFunctionNames) { 
				if(program.containsRecursive(function))
					count++;
				else
					System.out.println("The function: \""+function+"\" is expected to contain recursion");
			}
			TestCaseResult aResult;
			if(count == recursiveFunctionNames.length)
				aResult= pass();
			else
				aResult=partialPass(count/((double)recursiveFunctionNames.length),"See console for info");
			return scaleResult(aResult);
		} catch (Exception e) {
			return fail(e.getMessage());
		}
	}
}
