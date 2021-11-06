package gradingTools.comp524f21.assignment5.style;

import gradingTools.basics.sharedTestCase.checkstyle.CommonSignaturesAreInheritedRatioTestCase;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(3)
@IsExtra(true)
public class A5CommonSignaturesAreInherited extends CommonSignaturesAreInheritedRatioTestCase {

@Override
protected Class[] precedingTests() {
	return A5CommonPropertiesInherited.PRECEDING_TESTS;
}
}
