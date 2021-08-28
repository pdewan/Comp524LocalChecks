package gradingTools.comp524f21.assignment1.testcases.sociatDistance.style;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodHasJavaDocTestCase;
import util.annotations.MaxValue;
@MaxValue(5)
public class ExpectedJavaDocLowInterpolation extends CheckstyleMethodHasJavaDocTestCase {
//	[INFO] D:\dewan_backup\Java\grail13\.\src\greeting\Cls.java:6: Expected signature main:String[]->void in type greeting.Cls:[@Comp301Tags.GREETING_MAIN]. Good! [ExpectedSignatures]
//	[WARN] D:\dewan_backup\Java\grail13\.\src\greeting\Cls.java:6: Missing signature main:String[]->void in type greeting.Cls:[@Comp301Tags.GREETING_MAIN]. [ExpectedSignatures]
	public ExpectedJavaDocLowInterpolation() {
		super("@BasicSocialDistanceUtility", "low interpolation to a sequence of values is either an element of the sequence or zero");
//		super("@BasicSocialDistanceUtility", "low interpolation to sequence of values is either an element of the sequence or zero");

		// TODO Auto-generated constructor stub
	}
	
	
}
