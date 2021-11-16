package gradingTools.comp524f21.assignment6.style;

import gradingTools.basics.sharedTestCase.checkstyle.MethodAccessModifierRatioCheck;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(2)
@IsExtra(true)
public class A6NonPublicAccessModifiersMatched extends MethodAccessModifierRatioCheck {

@Override
protected Class[] precedingTests() {
	return A6CommonPropertiesInherited.PRECEDING_TESTS;
}
}
