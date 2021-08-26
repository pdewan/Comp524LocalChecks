package gradingTools.comp524f20.assignment0_4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment0_4.testcases.LispGreetingLoadAndRun;
import gradingTools.shared.testcases.suites.InterpreterSuite;


@RunWith(Suite.class)
@Suite.SuiteClasses({

	LispGreetingLoadAndRun.class
	
})
	

//@MaxValue(50)
public class F20Assignment0_4Suite extends InterpreterSuite {

	public static void main (String[] args) {
		try {
			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.LISP_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F20Assignment0_4Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
