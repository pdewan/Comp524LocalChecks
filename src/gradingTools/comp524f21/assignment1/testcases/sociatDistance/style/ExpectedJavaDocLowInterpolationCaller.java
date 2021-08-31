package gradingTools.comp524f21.assignment1.testcases.sociatDistance.style;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodHasJavaDocTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import gradingTools.comp524f21.assignment1.F21A1SocialDistanceClassRegistry;
import util.annotations.MaxValue;
@MaxValue(5)
public class ExpectedJavaDocLowInterpolationCaller extends CheckstyleMethodHasJavaDocTestCase {
//	[INFO] D:\dewan_backup\Java\grail13\.\src\greeting\Cls.java:6: Expected signature main:String[]->void in type greeting.Cls:[@Comp301Tags.GREETING_MAIN]. Good! [ExpectedSignatures]
//	[WARN] D:\dewan_backup\Java\grail13\.\src\greeting\Cls.java:6: Missing signature main:String[]->void in type greeting.Cls:[@Comp301Tags.GREETING_MAIN]. [ExpectedSignatures]
	final Class[] PRECEDING_TESTS = {
			SocialDistanceClassRegistryProvided.class

	};
	@Override
	protected Class[] precedingTests() {
			return PRECEDING_TESTS;
	}
	public ExpectedJavaDocLowInterpolationCaller() {
		super("@BasicSocialDistanceUtility", "then it is interpolated low");
//		super("@BasicSocialDistanceUtility", "low interpolation to sequence of values is either an element of the sequence or zero");

		// TODO Auto-generated constructor stub
	}
	
	
}
