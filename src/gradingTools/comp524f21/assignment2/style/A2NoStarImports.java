package gradingTools.comp524f21.assignment2.style;

import gradingTools.basics.sharedTestCase.checkstyle.StarImportTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import util.annotations.MaxValue;

@MaxValue(2)
public class A2NoStarImports extends StarImportTestCase {

	public A2NoStarImports() {
		super("", "");
		// TODO Auto-generated constructor stub
	}
	static final Class[] PRECEDING_TESTS = {
			SocialDistanceClassRegistryProvided.class,
	};
	@Override
	protected Class[] precedingTests() {
		return PRECEDING_TESTS;
	}

}
