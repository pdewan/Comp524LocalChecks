package gradingTools.comp524f21.assignment2.modularity;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleUnexpectedMethodCalledTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@IsExtra(true)
@MaxValue(2)
public class DerivedPrintIsNotDirect extends CheckstyleUnexpectedMethodCalledTestCase {
//	[INFO] D:\dewan_backup\Java\grail13\.\src\greeting\Cls.java:6: Expected signature main:String[]->void in type greeting.Cls:[@Comp301Tags.GREETING_MAIN]. Good! [ExpectedSignatures]
//	[WARN] D:\dewan_backup\Java\grail13\.\src\greeting\Cls.java:6: Missing signature main:String[]->void in type greeting.Cls:[@Comp301Tags.GREETING_MAIN]. [ExpectedSignatures]
	final Class[] PRECEDING_TESTS = {
			SocialDistanceClassRegistryProvided.class

	};
	@Override
	protected Class[] precedingTests() {
			return PRECEDING_TESTS;
	}
	public DerivedPrintIsNotDirect() {
//		super("@Comp301Tags.BRIDGE_SCENE_CONTROLLER", "(.*)!getArthur:-> @Comp301Tags.AVATAR");
		super("@BasicSocialDistanceUtility", "printGivenAndGeneratedCombinationsDerivedSafety:->void" , "java.io.PrintStream!println:\\*->\\.\\*");
		// TODO Auto-generated constructor stub
	}
	
	
}
