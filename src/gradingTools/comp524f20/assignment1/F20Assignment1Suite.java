package gradingTools.comp524f20.assignment1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment1.socialDistance.factories.FactoriesSuite;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.MainClassSuite;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.RequiredClassesSuite;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.A1GeneralStyleSuite;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.A1ModularitySuite;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.UtilityClassSuite;
import util.trace.TraceableWarning;
import util.trace.uigen.UnknownPropertyNotification;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	RequiredClassesSuite.class,
	UtilityClassSuite.class,
	MainClassSuite.class,
	A1GeneralStyleSuite.class,
	A1ModularitySuite.class,
	FactoriesSuite.class
	
})
	

//@MaxValue(50)
public class F20Assignment1Suite {

	public static void main (String[] args) {
		try {
			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
			setCheckStyleConfiguration("unc_checks_524_A1.xml");
			TraceableWarning.doNotWarn(UnknownPropertyNotification.class);
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F20Assignment1Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
