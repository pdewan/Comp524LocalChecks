package gradingTools.comp524f21.assignment2.style;

import gradingTools.basics.sharedTestCase.checkstyle.CommonPropertiesAreInheritedTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.BasicMainTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.DerivingMainTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.InferringMainTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.InterpolatingMainTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.CompareSafetyComputationsTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintGivenAndGeneratedCombinationsInferredSafety;
import gradingTools.comp524f21.assignment2.testcases.F21A2DerivedSafetyVerifier;
import gradingTools.comp524f21.assignment2.testcases.F21A2IsInferredSafeTest;
import util.annotations.MaxValue;

@MaxValue(5)
public class A2CommonPropertiesInherited extends CommonPropertiesAreInheritedTestCase {
static final Class[] PRECEDING_TESTS = {
		SocialDistanceClassRegistryProvided.class,		
		F21A2DerivedSafetyVerifier.class,
		F21A2IsInferredSafeTest.class,
		PrintGivenAndGeneratedCombinationsInferredSafety.class,
		CompareSafetyComputationsTest.class,
		BasicMainTest.class,
		InterpolatingMainTest.class,
		DerivingMainTest.class,
		InferringMainTest.class,
		
};
@Override
protected Class[] precedingTests() {
	return PRECEDING_TESTS;
}
}
