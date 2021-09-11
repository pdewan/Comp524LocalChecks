package gradingTools.comp524f21.assignment2.style;

import gradingTools.basics.sharedTestCase.checkstyle.CommonSignaturesAreInheritedRatioTestCase;
import util.annotations.MaxValue;

@MaxValue(5)
public class A2CommonSignaturesAreInherited extends CommonSignaturesAreInheritedRatioTestCase {
//	static final Class[] PRECEDING_TESTS = {
//			AssertingBridgeSceneDynamics.class,
//			AsyncArthurAnimation.class, 
//			SyncArthurAnimation.class,
//			WaitingAvatars.class,
//			LockstepAvatars.class,
//			SceneControllerButtonDynamics.class,
//			ArthurIsNotAContortionist.class
//	};
@Override
protected Class[] precedingTests() {
	return A2CommonPropertiesInherited.PRECEDING_TESTS;
}
}
