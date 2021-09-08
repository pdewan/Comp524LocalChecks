package gradingTools.comp524f21.assignment2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment1.socialDistance.factories.FactoriesSuite;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.RequiredClassesSuite;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	RequiredClassesSuite.class,
	F21A2UtilityClassSuite.class,
	F21A2MainClassSuite.class,
	FactoriesSuite.class,
	
	
})
	

//@MaxValue(50)
public class F21Assignment2Suite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F21Assignment2Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
		setCheckStyleConfiguration("unc_checks_524_A2.xml");
	}
	
}
