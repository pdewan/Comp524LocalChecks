package gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeThreeParam;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	InterpolatedSafe_OutputGeneration.class,
	InterpolatedSafe_TableTest.class,
	InterpolatedSafe_OffTableTrueTest.class,
	InterpolatedSafe_OffTableFalseTest.class,
})
	

//@MaxValue(10)
public class InterpolatedSafeTestSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(InterpolatedSafeTestSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
