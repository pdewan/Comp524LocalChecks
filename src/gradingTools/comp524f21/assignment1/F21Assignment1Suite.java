package gradingTools.comp524f21.assignment1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.MainClassSuite;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.A1GeneralStyleSuite;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	RequiredClassesSuite.class,
	UtilityClassSuite.class,
	MainClassSuite.class,
	A1GeneralStyleSuite.class,
	A1ModularitySuite.class
})
	

//@MaxValue(50)
public class F21Assignment1Suite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F21Assignment1Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
//		setCheckStyleConfiguration("unc_checks_524_A0_1.xml");
	}
	
}
