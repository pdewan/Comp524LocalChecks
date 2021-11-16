package gradingTools.comp524f21.assignment6.style;

import gradingTools.basics.sharedTestCase.checkstyle.CommonSignaturesAreInheritedRatioTestCase;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(3)
@IsExtra(true)
public class A6CommonSignaturesAreInherited extends CommonSignaturesAreInheritedRatioTestCase {

@Override
protected Class[] precedingTests() {
	return A6CommonPropertiesInherited.PRECEDING_TESTS;
}
}
