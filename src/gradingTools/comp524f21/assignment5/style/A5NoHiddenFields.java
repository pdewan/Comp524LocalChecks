package gradingTools.comp524f21.assignment5.style;

import gradingTools.basics.sharedTestCase.checkstyle.HiddenFieldTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(2)
@IsExtra(true)
public class A5NoHiddenFields extends HiddenFieldTestCase {

@Override
protected Class[] precedingTests() {
	return A5CommonPropertiesInherited.PRECEDING_TESTS;
}
}
