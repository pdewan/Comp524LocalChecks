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
//@MaxValue(10)
public class SExpressionClassProvided extends AbstractRegisteredClassProcessor {
	public Class<? extends SExpression> sExpressionClass;

	public Class<? extends SExpression> getSExpressionClass() {
		return sExpressionClass;
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
		    String aMethodName = "getStringFormattingSExpression";
//			sExpressionClass = (Class<? extends SExpression>) callGetterOnClassRegistry(aMethodName);
			sExpressionClass = aClassRegistry.getStringFormattingSExpression();   
		    if (sExpressionClass == null) {	
		    	sExpressionClass = BasicExpression.class;
		    	return fail ( aMethodName + " returns null in class registry");
		    }	
		    if (sExpressionClass  == BasicExpression.class) {
		    	return fail ("Registered s-expression class should not be " + BasicExpression.class);
		    }
			return pass();		
		 } 		 catch (Exception e) {
			 return fail (e.getMessage());
		 } catch (Throwable e) {
			 	return fail(e.getMessage());
		}
	}

}
