package gradingTools.comp524f21.assignment1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceBasicMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceDerivingMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceInferringMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceInterpolatingMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityTesterMainProvided;
import util.annotations.MaxValue;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	SocialDistanceClassRegistryProvided.class,
	SocialDistanceUtilityTesterMainProvided.class,
	SocialDistanceUtilityProvided.class,
//	SocialDistanceBasicMainProvided.class,
//	SocialDistanceInterpolatingMainProvided.class,
//	SocialDistanceDerivingMainProvided.class,
//	SocialDistanceInferringMainProvided.class,
})
	

@MaxValue(5)
public class RequiredClassesSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(RequiredClassesSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
