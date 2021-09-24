package gradingTools.comp524f21.assignment3;

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
	
//@MaxValue(50)
public class F21Assignment3Suite extends InterpreterSuite {
	public static void main (String[] args) {
		try {
			BasicJUnitUtils.interactiveTest(F21Assignment3Suite.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.PROLOG_LANGUAGE);
	}	
}
