package gradingTools.comp524f21.assignment3.prologStaticChecks;

import edu.unc.cs.comp524.parsers.prolog.Program;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f20.assignment2.requiredFiles.SocialDistancePlProvided;
import gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeOneTwoParam.InterpolatedSafe_OneParamFalseValueTest;
import gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeOneTwoParam.InterpolatedSafe_OneParamTrueValueTest;
import gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeOneTwoParam.InterpolatedSafe_OutputGeneration_OneTwoParam;
import gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeOneTwoParam.InterpolatedSafe_TwoParamFalseValueTest;
import gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeOneTwoParam.InterpolatedSafe_TwoParamTrueValueTest;
import gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeThreeParam.InterpolatedSafe_OffTableFalseTest;
import gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeThreeParam.InterpolatedSafe_OffTableTrueTest;
import gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeThreeParam.InterpolatedSafe_OutputGeneration;
import gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeThreeParam.InterpolatedSafe_TableTest;
import gradingTools.comp524f20.assignment2.ruleTests.derivedSafe.DerivedSafe_OffTableFalseTest;
import gradingTools.comp524f20.assignment2.ruleTests.derivedSafe.DerivedSafe_OffTableTrueTest;
import gradingTools.comp524f20.assignment2.ruleTests.derivedSafe.DerivedSafe_OutputGeneration;
import gradingTools.comp524f20.assignment2.ruleTests.derivedSafe.DerivedSafe_TableTest;
import gradingTools.comp524f20.assignment2.ruleTests.generateSafeDistancesAndDurations.GenerateSafeDistancesAndDurations_FalseValueTest;
import gradingTools.comp524f20.assignment2.ruleTests.generateSafeDistancesAndDurations.GenerateSafeDistancesAndDurations_OutputGeneration;
import gradingTools.comp524f20.assignment2.ruleTests.generateSafeDistancesAndDurations.GenerateSafeDistancesAndDurations_TrueValueTest;
import gradingTools.comp524f20.assignment2.ruleTests.givenSafe.GivenSafe_OutputGeneration;
import gradingTools.comp524f20.assignment2.ruleTests.givenSafe.GivenSafe_TableTest;
import gradingTools.comp524f20.assignment2.ruleTests.givenSize.GivenSizes_OutputGeneration;
import gradingTools.comp524f20.assignment2.ruleTests.givenSize.GivenSizes_TableTest;
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

@MaxValue(20)
@IsExtra(true)
public class SocialDistanceMagicNumbersTest extends PassFailJUnitTestCase{

	private Class [] PRECEDING_TESTS = {
			GivenSizes_OutputGeneration.class,
			GivenSizes_TableTest.class,
			
			GivenSafe_OutputGeneration.class,
			GivenSafe_TableTest.class,
			
			DerivedSafe_OutputGeneration.class,
			DerivedSafe_TableTest.class,
			DerivedSafe_OffTableTrueTest.class,
			DerivedSafe_OffTableFalseTest.class,
			
			InterpolatedSafe_OutputGeneration.class,
			InterpolatedSafe_TableTest.class,
			InterpolatedSafe_OffTableTrueTest.class,
			InterpolatedSafe_OffTableFalseTest.class,
			
			InterpolatedSafe_OutputGeneration_OneTwoParam.class,
			InterpolatedSafe_OneParamTrueValueTest.class,
			InterpolatedSafe_OneParamFalseValueTest.class,
			InterpolatedSafe_TwoParamTrueValueTest.class,
			InterpolatedSafe_TwoParamFalseValueTest.class,
			
			GenerateSafeDistancesAndDurations_OutputGeneration.class,
			GenerateSafeDistancesAndDurations_FalseValueTest.class,
			GenerateSafeDistancesAndDurations_TrueValueTest.class,
			
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
	protected Class [] precedingTests() {
		return PRECEDING_TESTS;
	}
	
	@Override
	protected boolean failedTestVetoes(Class aClass) {
		return false;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException, NotGradableException {
		try {
			APrologProgramGenerator generator = (APrologProgramGenerator) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(APrologProgramGenerator.class);	
			Program program = generator.getProgram();
			if(program == null) 
				return fail("APrologProgramGenerator did not pass successfully");
			
			 boolean magicNumbers = program.noMagicNumbers();
			 
			 TestCaseResult aResult;
			 if(magicNumbers)
				 aResult= pass();
			 else
				 aResult= fail("magic numbers found");
			 return scaleResult(aResult);
		}catch(Exception e) {
			return fail(e.getMessage());
		}
	}
}
