package gradingTools.comp524f21.assignment2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.CompareSafetyComputationsTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintGivenAndGeneratedCombinationsInferredSafety;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.WekaFileSizeTest;
import gradingTools.comp524f21.assignment2.testcases.F21A2DerivedSafetyVerifier;
import gradingTools.comp524f21.assignment2.testcases.F21A2IsInferredSafeTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	F21A2DerivedSafetyVerifier.class,
	F21A2IsInferredSafeTest.class,
	PrintGivenAndGeneratedCombinationsInferredSafety.class,
	CompareSafetyComputationsTest.class,
	WekaFileSizeTest.class
	
})
public class A2UtilityClassSuite {

}
