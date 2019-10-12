package gradingTools.comp524f19.assignment2.testcases;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import main.ClassRegistry;
//@MaxValue(10)
public class MainClassProvided extends AbstractRegisteredClassProcessor {
	public Class  mainClass;

	public Class getMainClass() {
		return mainClass;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {	
		 
		 try {
			 ClassRegistryProvided aClassRegistryProvided = (ClassRegistryProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(ClassRegistryProvided.class);
				
				ClassRegistry aClassRegistry = aClassRegistryProvided.getTimingOutClassRegistryProxy();  
			    if (aClassRegistry == null) {
			    	return fail ("No class registry");
			    }
		    String aMethodName = "getMain";
//			sExpressionClass = (Class<? extends SExpression>) callGetterOnClassRegistry(aMethodName);
			mainClass = aClassRegistry.getMain();   
		    if (mainClass == null) {	
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
