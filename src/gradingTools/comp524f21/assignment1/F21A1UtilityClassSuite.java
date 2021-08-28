package gradingTools.comp524f21.assignment1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.UtilityTesterMainTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.CompareSafetyComputationsTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.DerivedSafetyTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.GenerateSafeDistancesAndDurationsTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.GivenSafetyTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.InterpolatedSafetyTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.IsInterpolatedOneParameterSafetyTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.IsInterpolatedTwoParameterSafetyTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintGeneratedCombinationDerivedSafetyTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintGivenAndGeneratedCombinationDerivedTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintGivenAndGeneratedCombinationsInferredSafety;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintSafeDistancesAndDurationsTest;

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
	PrintGivenAndGeneratedCombinationsInferredSafety.class,
//	CompareSafetyComputationsTest.class,
	UtilityTesterMainTest.class,
})
public class F21A1UtilityClassSuite {

}
