package gradingTools.comp524f20.assignment3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment3.functionParamaters.FunctionParametersTestSuite;
import gradingTools.comp524f20.assignment3.functionReturnValues.FunctionReturnValuesTestSuite;
import gradingTools.comp524f20.assignment3.functionalPrograming.FunctionalProgrammingTestSuite;
import gradingTools.comp524f20.assignment3.listsAndRecursion.ListsAndRecursionTestSuite;
import gradingTools.comp524f20.assignment3.requiredFiles.SocialDistanceFileTestSuite;
import gradingTools.shared.testcases.suites.InterpreterSuite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	SocialDistanceFileTestSuite.class,
	FunctionalProgrammingTestSuite.class,
	ListsAndRecursionTestSuite.class,
	FunctionParametersTestSuite.class,
	FunctionReturnValuesTestSuite.class
})
	

//@MaxValue(50)
public class F20Assignment3Suite extends InterpreterSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.PROLOG_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F20Assignment3Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.SML_LANGUAGE);

	}
	
}
