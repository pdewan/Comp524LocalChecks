package gradingTools.comp524f20.assignment0_3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment0_3.testcases.SMLGreetingLoadAndRun;
import gradingTools.shared.testcases.suites.SMLInterpreterSuite;


@RunWith(Suite.class)
@Suite.SuiteClasses({

	SMLGreetingLoadAndRun.class
	
})
	

//@MaxValue(50)
public class F20Assignment0_3Suite extends SMLInterpreterSuite {
	


	public static void main (String[] args) {
		try {
			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.SML_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F20Assignment0_3Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
