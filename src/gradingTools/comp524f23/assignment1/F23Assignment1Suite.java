package gradingTools.comp524f23.assignment1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f21.assignment1.A1ModularitySuite;
import gradingTools.comp524f21.assignment1.A1UtilityClassSuite;
import gradingTools.comp524f21.assignment1.RequiredClassesSuite;
import gradingTools.comp524f21.assignment1.testcases.sociatDistance.style.A1GeneralStyleSuite;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	RequiredClassesSuite.class,
	A1UtilityClassSuite.class,	
	A1GeneralStyleSuite.class,
	A1ModularitySuite.class,
})
	

//@MaxValue(50)
public class F23Assignment1Suite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F23Assignment1Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
		setCheckStyleConfiguration("unc_checks_524_A1.xml");
	}
	
}
