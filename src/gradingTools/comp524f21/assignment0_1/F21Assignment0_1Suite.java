package gradingTools.comp524f21.assignment0_1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.shared.testcases.greeting.GreetingCheckstyle;
//import gradingTools.comp524f20.assignment0_1.testcases.GreetingMainProvided;
import gradingTools.shared.testcases.greeting.GreetingClassRegistryProvided;
import gradingTools.shared.testcases.greeting.GreetingMainProvided;
//import gradingTools.shared.testcases.greeting.GreetingRun;
import gradingTools.shared.testcases.greeting.GreetingRun;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	GreetingClassRegistryProvided.class,
	GreetingMainProvided.class,
	GreetingRun.class,
	A01Style.class
//	GreetingCheckstyle.class
//	SocialDistanceMainProvided.class,
//	SocialDistanceMainRuns.class,
//	LispGreetingLoad.class
	
})
	

//@MaxValue(50)
public class F21Assignment0_1Suite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F21Assignment0_1Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
		setCheckStyleConfiguration("unc_checks_524_A0_1.xml");
	}
	
}
