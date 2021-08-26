package gradingTools.comp524f20.assignment2.ruleTests.listGivenSafeTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	ListGivenSafe_OutputGeneration.class,
	ListGivenSafe_SafeTupleTest.class,
	ListGivenSafe_ValuesTest.class,
})
	

//@MaxValue(10)
public class ListGivenSafeTestSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(ListGivenSafeTestSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
