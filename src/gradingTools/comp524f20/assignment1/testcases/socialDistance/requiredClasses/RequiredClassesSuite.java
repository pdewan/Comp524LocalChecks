package gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import util.annotations.MaxValue;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	SocialDistanceClassRegistryProvided.class,
	SocialDistanceUtilityTesterMainProvided.class,
	SocialDistanceUtilityProvided.class,
	SocialDistanceBasicMainProvided.class,
	SocialDistanceInterpolatingMainProvided.class,
	SocialDistanceDerivingMainProvided.class,
	SocialDistanceInferringMainProvided.class,
	SafeSocializationtxtProvided.class
})
	

@MaxValue(10)
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
