package gradingTools.comp524f21.assignment5.style;

import gradingTools.basics.sharedTestCase.checkstyle.EncapsulationTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(3)
@IsExtra(true)
public class A5Encapsulation extends EncapsulationTestCase {
;
protected Class[] precedingTests() {
	return A5CommonPropertiesInherited.PRECEDING_TESTS;
}
}
