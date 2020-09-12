package gradingTools.comp524f20.assignment1.socialDistance.factories;

import java.beans.PropertyChangeListener;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment1.SocialDistanceClassRegistry;
import gradingTools.comp524f20.assignment1.socialDistance.testInterfaces.TestModelInterface;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import gradingTools.shared.testcases.FactoryMethodTest;
import util.annotations.Explanation;
import util.annotations.MaxValue;
import weka.classifiers.Classifier;
@MaxValue(3)
@Explanation("Checks that a controller factory is returned by the registry and gets a controller object")
public class ControllerFactory extends FactoryMethodTest {

	public Object getController() {
		return getRootProxy();
	}
	@Override
	protected Class proxyClass() {
		return Object.class;
	}
	@Override
	protected String factoryMethodName() {
		return "getSingleton";
	}
	@Override
	protected Class factoryClass() {
		SocialDistanceClassRegistryProvided aConfigurationProvided = (SocialDistanceClassRegistryProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceClassRegistryProvided.class);
		SocialDistanceClassRegistry aTestMapReduceConfiguration = aConfigurationProvided.getClassRegistry();
		if (aTestMapReduceConfiguration == null) {
			assertTrue("No class registry", false);
		}
		Class retVal = aTestMapReduceConfiguration.getSocialDistanceControllerFactory();
		if (retVal == null) {
			assertTrue("Null controller factory in class registry", false);
		}
		return retVal;
	}
	@Override
	protected Object createUsingFactory() {
		return createUsingFactoryClassAndMethodName();
	}
//	@Override
//	protected boolean doTest() throws Throwable {
//		 return doFactoryMethodTest();
//		
//	}
	public void defaultTest() {
    	passfailDefaultTest();
    }
	@Override
	protected boolean matchProxyActualClass() {
		return false;
	}
	public  TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
   	NotGradableException {
    	
		boolean aResult = doFactoryMethodTest();
		return (aResult == true? pass(): fail("Factory method test failed"));
    }

}
