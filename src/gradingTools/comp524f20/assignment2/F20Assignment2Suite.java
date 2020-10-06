package gradingTools.comp524f20.assignment2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment1.requiredClasses.A1RequiredClassesSuite;
import gradingTools.comp524f19.assignment1.testcases.load.A1LoadSuite;
import gradingTools.comp524f19.assignment1.testcases.load.TestLispFileProvided;
import gradingTools.comp524f19.assignment1.testcases.loadLogical.A1LoadLogicalSuite;
import gradingTools.comp524f19.assignment1.testcases.loadRelation.A1LoadRelationSuite;
import gradingTools.comp524f19.assignment1.testcases.toString.A1ToStringSuite;
import gradingTools.comp524f20.assignment0_1.testcases.GreetingMainProvided;
import gradingTools.comp524f20.assignment0_1.testcases.GreetingRun;
import gradingTools.comp524f20.assignment0_1.testcases.socialDistance.SocialDistanceMainRuns;
import gradingTools.comp524f20.assignment0_2.testcases.PrologGreetingLoadAndRun;
import gradingTools.comp524f20.assignment0_4.testcases.LispGreetingLoadAndRun;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityTesterMainProvided;
import gradingTools.comp524f20.assignment2.requiredFiles.SocialDistanceFileTestSuite;
import gradingTools.comp524f20.assignment2.requiredFiles.SocialDistancePlProvided;
import gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeOneTwoParam.InterpolatedSafeOneTwoParamTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeThreeParam.InterpolatedSafeTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.derivedSafe.DerivedSafeTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.generateSafeDistancesAndDurations.GenerateSafeDistancesAndDurationsTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.givenSafe.GivenSafeTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.givenSize.GivenSizesTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.listGenerateSafeDistancesAndDurations.ListGenerateSafeDistancesAndDurationsTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.listGivenSafeTests.ListGivenSafeTestSuite;
import gradingTools.comp524f20.assignment2.ruleTests.printGivenCombinations.PrintGivenCombinationsTestSuite;
import gradingTools.comp524f20.assignment4.lisp.testcases.LispTestCase;
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
	ListGenerateSafeDistancesAndDurationsTestSuite.class
	
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
