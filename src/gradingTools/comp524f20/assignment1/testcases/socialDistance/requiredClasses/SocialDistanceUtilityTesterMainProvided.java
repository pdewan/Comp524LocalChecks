package gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f20.assignment1.SocialDistanceClassRegistry;
//@MaxValue(2)
public class SocialDistanceUtilityTesterMainProvided extends PassFailJUnitTestCase {
	public Class socialDistanceMain;

	public Class getSocialDistanceMain() {
		return socialDistanceMain;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {	
		 
		 try {
			 SocialDistanceClassRegistryProvided aClassRegistryProvided = (SocialDistanceClassRegistryProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceClassRegistryProvided.class);
				
				SocialDistanceClassRegistry aClassRegistry = aClassRegistryProvided.getTimingOutClassRegistryProxy();  
			    if (aClassRegistry == null) {
			    	return fail ("No class registry");
			    }
//			sExpressionClass = (Class<? extends SExpression>) callGetterOnClassRegistry(aMethodName);
			socialDistanceMain = aClassRegistry.getSocialDistanceUilityTesterMain();   
		    if (socialDistanceMain == null) {	
		    	return fail ("getSocialDistanceUilityTesterMain returns null in class registry");
		    }	
		    
			return pass();		
		 } 		 catch (Exception e) {
			 return fail (e.getMessage());
		 } catch (Throwable e) {
			 	return fail(e.getMessage());
		}
	}

}
