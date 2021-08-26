package gradingTools.comp524f20.assignment1.testcases.socialDistance.style;

import java.lang.reflect.Method;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f20.assignment1.SocialDistanceClassRegistry;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@IsExtra(true)
@MaxValue(10)
@Explanation("Checks model code usage")
public class ModelReuse extends PassFailJUnitTestCase {

	
	private static final double COMMON_SUPERCLASS = 0.5;
	
	
	public  TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
   	NotGradableException {
		SocialDistanceClassRegistryProvided aConfigurationProvided = (SocialDistanceClassRegistryProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceClassRegistryProvided.class);
		SocialDistanceClassRegistry aTestMapReduceConfiguration = aConfigurationProvided.getClassRegistry();
		if (aTestMapReduceConfiguration == null) {
			assertTrue("No class registry", false);
		}
		Class retVal = aTestMapReduceConfiguration.getSocialDistanceControllerFactory();
		if (retVal == null) {
			assertTrue("Null controller factory in class registry", false);
		}
		Class aDerivedModelClass = aTestMapReduceConfiguration.getSocialDistancDerivingModel();
		Class aBasicModelClass = aTestMapReduceConfiguration.getSocialDistanceBasicModel();
		Class anInferringModelClass = aTestMapReduceConfiguration.getSocialDistancInferringModel();
		Class anInterpolatingModelClass = aTestMapReduceConfiguration.getSocialDistanceInterpolatingModel();
		if (aDerivedModelClass == null || aBasicModelClass == null || anInferringModelClass == null || anInterpolatingModelClass == null) {
			return fail ("One or more of model classes null in configuration");
		}
		Class aDerivedSuperClass = aDerivedModelClass.getSuperclass();
		Class aBasicSuperClass = aBasicModelClass.getSuperclass();
		Class anInferringSuperClass = anInferringModelClass.getSuperclass();
		Class anInterpolatingSuperClass = anInterpolatingModelClass.getSuperclass();
		if (aDerivedSuperClass == null || aBasicSuperClass == null || anInferringSuperClass == null || anInterpolatingModelClass == null) {
			return fail ("Model class code reuse not as expected, let us know if you are using delegation");
		}
		Method[] aDeclaredMethods = aDerivedModelClass.getDeclaredMethods();
		if (aDerivedModelClass.getDeclaredMethods().length != 1 ||
				
			 aBasicModelClass.getDeclaredMethods().length != 1 || 
			 
			 anInferringModelClass.getDeclaredMethods().length != 1 ||
			 anInterpolatingModelClass.getDeclaredMethods().length != 1) {
			return partialPass(COMMON_SUPERCLASS, "Partial model class code reuse ");
		} else {
			return pass();
		}
    }

}
