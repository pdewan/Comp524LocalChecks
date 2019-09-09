package gradingTools.comp524f19.assignment1.testcases;

import java.lang.reflect.Method;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.BasicProjectIntrospection;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import main.ClassRegistry;
import main.lisp.parser.terms.BasicExpression;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.SExpression;
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
