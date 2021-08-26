package gradingTools.comp524f19.assignment4.requiredClasses;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f19.assignment1.testcases.AbstractRegisteredClassProcessor;
import main.ClassRegistryA4;
//@MaxValue(10)
public class ThreadPoolClassProvided extends AbstractRegisteredClassProcessor {
	public Class  threadPool;

	public Class getThreadPoolClass() {
		return threadPool;
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
		    String aMethodName = "getThreadPool";
//			sExpressionClass = (Class<? extends SExpression>) callGetterOnClassRegistry(aMethodName);
			threadPool = aClassRegistry.getThreadPool();
		    if (threadPool == null) {	
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
