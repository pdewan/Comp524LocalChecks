package gradingTools.comp524f20.assignment2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment2.requiredFiles.SocialDistanceFileTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeOneTwoParam.InterpolatedSafeOneTwoParamTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeThreeParam.InterpolatedSafeTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.derivedSafe.DerivedSafeTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.generateSafeDistancesAndDurations.GenerateSafeDistancesAndDurationsTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.givenSafe.GivenSafeTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.givenSize.GivenSizesTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.listGenerateSafeDistancesAndDurations.ListGenerateSafeDistancesAndDurationsTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.listGivenSafeTests.ListGivenSafeTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.printGivenCombinations.PrintGivenCombinationsTestSuite;
import gradingTools.shared.testcases.suites.InterpreterSuite;


@RunWith(Suite.class)
@Suite.SuiteClasses({

	//SocialDistancePlProvided.class,
	SocialDistanceFileTestSuite.class,
	GivenSizesTestSuite.class,
	GivenSafeTestSuite.class,
	DerivedSafeTestSuite.class,
	InterpolatedSafeTestSuite.class,
	InterpolatedSafeOneTwoParamTestSuite.class,
	GenerateSafeDistancesAndDurationsTestSuite.class,
	ListGivenSafeTestSuite.class,
	PrintGivenCombinationsTestSuite.class,
	ListGenerateSafeDistancesAndDurationsTestSuite.class,

	
})
	

//@MaxValue(50)
public class F20Assignment2Suite extends InterpreterSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.PROLOG_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F20Assignment2Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.PROLOG_LANGUAGE);

	}
	
}
