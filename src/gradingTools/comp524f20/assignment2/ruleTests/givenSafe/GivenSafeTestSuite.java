package gradingTools.comp524f20.assignment2.ruleTests.givenSafe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	GivenSafe_OutputGeneration.class,
	GivenSafe_TableTest.class,
//	GivenSafe_OffTableTest.class,
})
	

//@MaxValue(10)
public class GivenSafeTestSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(GivenSafeTestSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
