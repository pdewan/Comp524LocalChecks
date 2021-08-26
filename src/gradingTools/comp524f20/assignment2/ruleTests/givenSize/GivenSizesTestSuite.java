package gradingTools.comp524f20.assignment2.ruleTests.givenSize;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	GivenSizes_OutputGeneration.class,
	GivenSizes_TableTest.class,
//	GivenSizes_OffTableTest.class,
})
	

//@MaxValue(10)
public class GivenSizesTestSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(GivenSizesTestSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
