package gradingTools.comp524f19.assignment4.requiredClasses;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.BasicProjectIntrospection;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f19.assignment1.testcases.AbstractRegisteredClassProcessor;
import gradingTools.comp524f19.assignment1.testcases.ClassRegistryProvided;
import main.ClassRegistry;
import main.ClassRegistryA4;
//@MaxValue(10)
public class MutableJoinerClassProvided extends AbstractRegisteredClassProcessor {
	public Class  mutableJoinerClass;

	public Class getMutableJoinerClass() {
		return mutableJoinerClass;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {	
		 
		 try {
			 ClassRegistryA4Provided aClassRegistryProvided = (ClassRegistryA4Provided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(ClassRegistryA4Provided.class);
				
				ClassRegistryA4 aClassRegistry = aClassRegistryProvided.getTimingOutClassRegistryProxy();  
			    if (aClassRegistry == null) {
			    	return fail ("No class registry");
			    }
		    String aMethodName = "getMutableJoiner";
//			sExpressionClass = (Class<? extends SExpression>) callGetterOnClassRegistry(aMethodName);
			mutableJoinerClass = aClassRegistry.getMutableJoiner();
		    if (mutableJoinerClass == null) {	
		    	return fail ( aMethodName + " returns null in class registry");
		    }	
			return pass();		
		 } 		 catch (Exception e) {
			 return fail (e.getMessage());
		 } catch (Throwable e) {
			 	return fail(e.getMessage());
		}
	}

}
