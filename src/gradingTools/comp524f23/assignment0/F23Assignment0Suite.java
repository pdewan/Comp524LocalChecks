package gradingTools.comp524f23.assignment0;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f21.assignment0_1.A01Style;
import gradingTools.shared.testcases.greeting.GreetingClassRegistryProvided;
import gradingTools.shared.testcases.greeting.GreetingMainProvided;
import gradingTools.shared.testcases.greeting.GreetingRun;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	GreetingClassRegistryProvided.class,
	GreetingMainProvided.class,
	GreetingRun.class,
	A01Style.class
	
})

public class F23Assignment0Suite {

	public static void main (String[] args) {
		try {
			BasicJUnitUtils.interactiveTest(F23Assignment0Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
		setCheckStyleConfiguration("unc_checks_524_A0.xml");
	}
	
}
