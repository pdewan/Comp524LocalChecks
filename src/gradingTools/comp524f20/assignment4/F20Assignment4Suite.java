package gradingTools.comp524f20.assignment4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment4.listsAndRecursion.ListsAndRecursionTestSuite;
import gradingTools.comp524f20.assignment4.requiredFiles.SocialDistanceFileTestSuite;
import gradingTools.shared.testcases.suites.InterpreterSuite;
import util.trace.Tracer;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	SocialDistanceFileTestSuite.class,
	ListsAndRecursionTestSuite.class
})
	

//@MaxValue(50)
public class F20Assignment4Suite extends InterpreterSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.PROLOG_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F20Assignment4Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.SML_LANGUAGE);
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.LISP_LANGUAGE);


	}
	
}
