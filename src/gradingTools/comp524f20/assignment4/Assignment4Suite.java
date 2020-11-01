package gradingTools.comp524f20.assignment4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f20.assignment4.lisp.testcases.LispTestCase;
import gradingTools.comp524f20.assignment4.listsAndRecursion.ListsAndRecursionTestSuite;
import gradingTools.comp524f20.assignment4.requiredFiles.SocialDistanceFileTestSuite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
//	LispTestCase.class
	SocialDistanceFileTestSuite.class,
	ListsAndRecursionTestSuite.class
})
	

//@MaxValue(50)
public class Assignment4Suite {

	public static void main (String[] args) {
		try {
			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.LISP_LANGUAGE);

			BasicJUnitUtils.interactiveTest(Assignment4Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
