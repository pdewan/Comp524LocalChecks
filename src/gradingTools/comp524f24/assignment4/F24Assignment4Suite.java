package gradingTools.comp524f24.assignment4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment0_3.testcases.SMLGreetingLoadAndRun;
import gradingTools.comp524f20.assignment3.functionReturnValues.FunctionReturnValuesTestSuite;
import gradingTools.comp524f20.assignment3.functionalPrograming.FunctionalProgrammingTestSuite;
import gradingTools.comp524f20.assignment3.listsAndRecursion.ListsAndRecursionTestSuite;
import gradingTools.comp524f20.assignment3.requiredFiles.SocialDistanceFileTestSuite;
import gradingTools.comp524f20.assignment3.styleParsing.StyleTest;
import gradingTools.comp524f22.assignment4.concisePrintSafety.FunctionParametersTestSuite;
import gradingTools.shared.testcases.suites.SMLInterpreterSuite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	SocialDistanceFileTestSuite.class,
	FunctionalProgrammingTestSuite.class,
	ListsAndRecursionTestSuite.class,
	FunctionParametersTestSuite.class,
	FunctionReturnValuesTestSuite.class,
	StyleTest.class,
	SMLGreetingLoadAndRun.class
})
//1.6, 2.1, 3.6, 4.2, 5.1, 6.1, 7.1, 8.1
//19

//@MaxValue(50)
public class F24Assignment4Suite extends SMLInterpreterSuite {

	public static void main (String[] args) {
		try {
			BasicJUnitUtils.interactiveTest(F24Assignment4Suite.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.SML_LANGUAGE);

	}
	
}
