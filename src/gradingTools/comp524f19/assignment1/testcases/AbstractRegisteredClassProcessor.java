package gradingTools.comp524f19.assignment1.testcases;

import java.lang.reflect.Method;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.testcase.PassFailJUnitTestCase;
import main.ClassRegistry;
import util.annotations.MaxValue;
@MaxValue(10)
public abstract class AbstractRegisteredClassProcessor extends PassFailJUnitTestCase {
		
	protected Object callGetterOnClassRegistry (String aMethodName) throws Throwable {
		ClassRegistryProvided aClassRegistryProvided = (ClassRegistryProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(ClassRegistryProvided.class);
		
		ClassRegistry aClassRegistry = aClassRegistryProvided.getClassRegistry();  
	    if (aClassRegistry == null) {
	    	return null;
	    }
	    Method aMethod = ClassRegistry.class.getMethod(aMethodName);
	    return  BasicProjectExecution.timedInvoke(aClassRegistry, aMethod);
	}

	

}
