package gradingTools.comp524f21.assignment2.style;

import gradingTools.basics.sharedTestCase.checkstyle.VariableHasClassTypeRatioCheck;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import util.annotations.MaxValue;
@MaxValue(5)
public class A2InterfaceAsType extends VariableHasClassTypeRatioCheck{
	static final Class[] PRECEDING_TESTS = {
			SocialDistanceClassRegistryProvided.class,
	};
	@Override
	protected Class[] precedingTests() {
		return PRECEDING_TESTS;
	}
}
