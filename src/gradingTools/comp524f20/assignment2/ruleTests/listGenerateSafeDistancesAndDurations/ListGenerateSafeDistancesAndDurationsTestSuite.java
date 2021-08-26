package gradingTools.comp524f20.assignment2.ruleTests.listGenerateSafeDistancesAndDurations;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	ListGenerateSafeDistancesAndDurations_OutputGeneration.class,
	ListGenerateSafeDistancesAndDurations_FalseValueTest.class,
	ListGenerateSafeDistancesAndDurations_TrueValueTest.class,
})
	

//@MaxValue(10)
public class ListGenerateSafeDistancesAndDurationsTestSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(ListGenerateSafeDistancesAndDurationsTestSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
