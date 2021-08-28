package gradingTools.comp524f21.assignment1.testcases.sociatDistance.style;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import util.annotations.MaxValue;
@MaxValue(3)
public class PrintDerivedReuse extends CheckstyleMethodCalledTestCase {
//	[INFO] D:\dewan_backup\Java\grail13\.\src\greeting\Cls.java:6: Expected signature main:String[]->void in type greeting.Cls:[@Comp301Tags.GREETING_MAIN]. Good! [ExpectedSignatures]
//	[WARN] D:\dewan_backup\Java\grail13\.\src\greeting\Cls.java:6: Missing signature main:String[]->void in type greeting.Cls:[@Comp301Tags.GREETING_MAIN]. [ExpectedSignatures]
	public PrintDerivedReuse() {
//		super("@Comp301Tags.BRIDGE_SCENE_CONTROLLER", "(.*)!getArthur:-> @Comp301Tags.AVATAR");
		super("@BasicSocialDistanceUtility", "printGivenAndGeneratedCombinationsDerivedSafety:->void");
		// TODO Auto-generated constructor stub
	}
	
	
}
