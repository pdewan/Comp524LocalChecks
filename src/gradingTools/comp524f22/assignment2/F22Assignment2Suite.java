package gradingTools.comp524f22.assignment2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment1.socialDistance.factories.FactoriesSuite;
import gradingTools.comp524f21.assignment2.A2GeneralStyle;
import gradingTools.comp524f21.assignment2.A2MainClassSuite;
import gradingTools.comp524f21.assignment2.A2Modularity;
import gradingTools.comp524f21.assignment2.A2RequiredClassesSuite;
import gradingTools.comp524f21.assignment2.A2SourceCode;
import gradingTools.comp524f21.assignment2.A2UtilityClassSuite;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	A2RequiredClassesSuite.class,
	A2UtilityClassSuite.class,
	A2MainClassSuite.class,
	FactoriesSuite.class,
	A2SourceCode.class,
	A2Modularity.class,
	A2GeneralStyle.class
	
	
})
	

//@MaxValue(50)
public class F22Assignment2Suite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F22Assignment2Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
		setCheckStyleConfiguration("unc_checks_524_A2.xml");
	}
	
}
