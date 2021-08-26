package gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeOneTwoParam;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	InterpolatedSafe_OutputGeneration_OneTwoParam.class,
	InterpolatedSafe_OneParamTrueValueTest.class,
	InterpolatedSafe_OneParamFalseValueTest.class,
	InterpolatedSafe_TwoParamTrueValueTest.class,
	InterpolatedSafe_TwoParamFalseValueTest.class,
})
	

//@MaxValue(10)
public class InterpolatedSafeOneTwoParamTestSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(InterpolatedSafeOneTwoParamTestSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
