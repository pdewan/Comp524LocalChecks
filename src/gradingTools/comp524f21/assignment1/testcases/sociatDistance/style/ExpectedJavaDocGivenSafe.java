package gradingTools.comp524f21.assignment1.testcases.sociatDistance.style;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodHasJavaDocTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import gradingTools.comp524f21.assignment1.F21A1SocialDistanceClassRegistry;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(0)
@IsExtra(false)
public class ExpectedJavaDocGivenSafe extends CheckstyleMethodHasJavaDocTestCase {
	final Class[] PRECEDING_TESTS = {
			SocialDistanceClassRegistryProvided.class
	};
	@Override
	protected Class[] precedingTests() {
			return PRECEDING_TESTS;
	}
	public ExpectedJavaDocGivenSafe() {
		super("@BasicSocialDistanceUtility", "if the combination of the method parameters is safe based on the given data the function returns true");

		// TODO Auto-generated constructor stub
	}
	
	
}
