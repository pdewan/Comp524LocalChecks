package gradingTools.comp524f20.assignment2.ruleTests.generateSafeDistancesAndDurations;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	GenerateSafeDistancesAndDurations_OutputGeneration.class,
	GenerateSafeDistancesAndDurations_FalseValueTest.class,
	GenerateSafeDistancesAndDurations_TrueValueTest.class,
})
	

//@MaxValue(10)
public class GenerateSafeDistancesAndDurationsTestSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(GenerateSafeDistancesAndDurationsTestSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
