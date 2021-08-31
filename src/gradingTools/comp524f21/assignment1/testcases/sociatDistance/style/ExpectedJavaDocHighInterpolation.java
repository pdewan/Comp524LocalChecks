package gradingTools.comp524f21.assignment1.testcases.sociatDistance.style;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodHasJavaDocTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import gradingTools.comp524f21.assignment1.F21A1SocialDistanceClassRegistry;
import util.annotations.MaxValue;
@MaxValue(5)
public class ExpectedJavaDocHighInterpolation extends CheckstyleMethodHasJavaDocTestCase {
	final Class[] PRECEDING_TESTS = {
			SocialDistanceClassRegistryProvided.class

	};
	@Override
	protected Class[] precedingTests() {
			return PRECEDING_TESTS;
	}
	public ExpectedJavaDocHighInterpolation() {
		super("@BasicSocialDistanceUtility", "high interpolation to a sequence of values is either an element of the sequence or max integer");

		// TODO Auto-generated constructor stub
	}
	
	
}
