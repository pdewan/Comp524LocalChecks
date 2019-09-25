package gradingTools.comp524f19.assignment2.testcases;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.BasicProjectIntrospection;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import main.ClassRegistry;
import main.lisp.evaluator.BasicOperationManager;
import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.OperationRegisterer;
import main.lisp.parser.terms.BasicExpression;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.SExpression;
import util.annotations.MaxValue;
//@MaxValue()
public class OperationRegistryProvided extends AbstractRegisteredClassProcessor {
	public Class  operationRegistrerer;

	public Class getOperationRegisterer() {
		return operationRegistrerer;
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
		    String aMethodName = "getOperationRegisterer";
//			sExpressionClass = (Class<? extends SExpression>) callGetterOnClassRegistry(aMethodName);
			operationRegistrerer = aClassRegistry.getCustomOperationRegisterer();  
			OperationRegisterer oRegisterer = aClassRegistry.getCustomOperationRegisterer().newInstance();
			oRegisterer.registerOperations();
			BasicOperationManager aBasicOperationManager = (BasicOperationManager) BuiltinOperationManagerSingleton.get();
			String arr[] = {"cond","load","and","or","not","list","eval","quote",">","<","<=",">="};
			for(String line:arr)
			{
				Evaluator aEvaluator = aBasicOperationManager.getEvaluator(line);
				if(aEvaluator == null)
				{
					return fail ( line + " returns null in operation registry");
				}
			}
			return pass();		
		 } 		 catch (Exception e) {
			 return fail (e.getMessage());
		 } catch (Throwable e) {
			 	return fail(e.getMessage());
		}
	}

}
