package gradingTools.comp524f24.assignment3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment0_2.testcases.PrologGreetingLoadAndRun;
import gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeOneTwoParam.InterpolatedSafeOneTwoParamTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeThreeParam.InterpolatedSafeTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.derivedSafe.DerivedSafeTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.generateSafeDistancesAndDurations.GenerateSafeDistancesAndDurationsTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.givenSafe.GivenSafeTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.givenSize.GivenSizesTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.listGenerateSafeDistancesAndDurations.ListGenerateSafeDistancesAndDurationsTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.listGivenSafeTests.ListGivenSafeTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.printGivenCombinations.PrintGivenCombinationsTestSuite;
import gradingTools.comp524f21.assignment3.SocialDistanceFileTestSuite;
import gradingTools.comp524f21.assignment3.prologStaticChecks.PrologStyleChecksTestSuite;
import gradingTools.shared.testcases.suites.InterpreterSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	PrologGreetingLoadAndRun.class,
	PrologStyleChecksTestSuite.class,
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
//1.2, 2.4, 3.5, 4.3, 5.7, 6.4, 7.3, 8.2, 9.3, 10.1, 11.3, 12.2, 13.1
//40
//@MaxValue(50)
public class F24Assignment3Suite extends InterpreterSuite {
	public static void main (String[] args) {
		try {
			BasicJUnitUtils.interactiveTest(F24Assignment3Suite.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.PROLOG_LANGUAGE);
	}	
}
