package gradingTools.comp524f21.assignment2;

	import org.junit.runner.RunWith;
	import org.junit.runners.Suite;

	import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SafeSocializationTxtProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceBasicMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceDerivingMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceInferringMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceInterpolatingMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityProvided;
import util.annotations.MaxValue;


	@RunWith(Suite.class)
	@Suite.SuiteClasses({
		SocialDistanceClassRegistryProvided.class,
//		SocialDistanceUtilityTesterMainProvided.class,
		SocialDistanceUtilityProvided.class,
		SocialDistanceBasicMainProvided.class,
		SocialDistanceInterpolatingMainProvided.class,
		SocialDistanceDerivingMainProvided.class,
		SocialDistanceInferringMainProvided.class,
		SafeSocializationTxtProvided.class
	})
		

	@MaxValue(7)
	public class A2RequiredClassesSuite {

		
}
