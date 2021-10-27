package gradingTools.comp524f21.assignment5.style;

import gradingTools.basics.sharedTestCase.checkstyle.PackageDeclarationTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(2)
@IsExtra(true)
public class A5PackageDeclarations extends PackageDeclarationTestCase {
	static final Class[] PRECEDING_TESTS = {
			SocialDistanceClassRegistryProvided.class,
	};
@Override
protected Class[] precedingTests() {
	return PRECEDING_TESTS;
}
}
