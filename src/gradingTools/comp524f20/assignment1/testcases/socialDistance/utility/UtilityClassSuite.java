package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	GivenSafetyTest.class,
	InterpolatedSafetyTest.class,
	IsInterpolatedTwoParameterSafetyTest.class,
	IsInterpolatedOneParameterSafetyTest.class,
	DerivedSafetyTest.class,
	PrintGeneratedCombinationDerivedSafetyTest.class,
	PrintGivenAndGeneratedCombinationDerivedTest.class,
	GenerateSafeDistancesAndDurationsTest.class,
	PrintSafeDistancesAndDurationsTest.class,
	IsInferredSafeTest.class,
	PrintGivenAndGeneratedCombinationsInferredSafety.class,
	CompareSafetyComputationsTest.class,
	WekaFileSizeTest.class
	
})
	

//@MaxValue(50)
public class UtilityClassSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);
			BasicJUnitUtils.interactiveTest(UtilityClassSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
