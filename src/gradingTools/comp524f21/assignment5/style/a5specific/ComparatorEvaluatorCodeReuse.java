package gradingTools.comp524f21.assignment5.style.a5specific;

import java.lang.reflect.Method;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f19.assignment1.testcases.ClassRegistryProvided;
import gradingTools.comp524f21.assignment5.style.A5CommonPropertiesInherited;
import main.ClassRegistry;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@IsExtra(true)
@MaxValue(10)
@Explanation("Checks comparators (<,>,<=,>=) for code usage")
public class ComparatorEvaluatorCodeReuse extends PassFailJUnitTestCase {
	static final Class[] PRECEDING_TESTS = A5CommonPropertiesInherited.PRECEDING_TESTS;
	@Override
	protected Class[] precedingTests() {
			return PRECEDING_TESTS;
	}
	
	private static final double COMMON_SUPERCLASS = 0.5;
	
	
	public  TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
   	NotGradableException {

		ClassRegistryProvided aConfigurationProvided = (ClassRegistryProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(ClassRegistryProvided.class);
		ClassRegistry aTestMapReduceConfiguration = aConfigurationProvided.getClassRegistry();
		if (aTestMapReduceConfiguration == null) {
			assertTrue("No class registry", false);
		}
//		Class retVal = aTestMapReduceConfiguration.getSocialDistanceControllerFactory();
//		if (retVal == null) {
//			assertTrue("Null controller factory in class registry", false);
//		}
		Class LTEEvaluator = aTestMapReduceConfiguration.getLTEEvaluator();
		Class LTEvaluator = aTestMapReduceConfiguration.getLTEvaluator();
		Class GTEvaluator = aTestMapReduceConfiguration.getGTEvaluator();
		Class GTEEvaluator = aTestMapReduceConfiguration.getGTEEvaluator();
		if (LTEEvaluator == null || LTEvaluator == null || GTEvaluator == null || GTEEvaluator == null) {
			return fail ("One or more of comparator classes null in configuration");
		}
		Class LTEEvaluatorSuperClass = LTEEvaluator.getSuperclass();
		Class LTEvaluatorSuperClass = LTEvaluator.getSuperclass();
		Class GTEvaluatorSuperClass = GTEvaluator.getSuperclass();
		Class GTEEvaluatorSuperClass = GTEEvaluator.getSuperclass();
		if (LTEEvaluatorSuperClass == null || LTEvaluatorSuperClass == null || GTEvaluatorSuperClass == null || GTEEvaluatorSuperClass == null) {
			return fail ("Comparator class code not reused using inheritance, as expected, let us know if you are using delegation for reuse");
		}
		if(!(LTEEvaluatorSuperClass.equals(LTEvaluatorSuperClass)&&LTEEvaluatorSuperClass.equals(GTEvaluatorSuperClass)&&LTEEvaluatorSuperClass.equals(GTEEvaluatorSuperClass)))
			return fail ("Comparator class code not reused using inheritance, as expected, let us know if you are using delegation for reuse");
		
		
		if (declaredMethodIsAmountOrMatchesName(LTEEvaluator,2,"eval") ||
			declaredMethodIsAmountOrMatchesName(LTEvaluator,2,"eval") || 
			declaredMethodIsAmountOrMatchesName(GTEvaluator,2,"eval") ||
			declaredMethodIsAmountOrMatchesName(GTEEvaluator,2,"eval")) {
			return partialPass(COMMON_SUPERCLASS, "Partial model class code reuse ");
		} else {
			return pass();
		}
    }

	private boolean declaredMethodIsAmountOrMatchesName(Class clazz, int numDeclaredMethods, String methodName) {
		Method [] declaredMethods=clazz.getDeclaredMethods();
		boolean hasMethodName=false;
		for(Method method:declaredMethods) 
			if(method.getName().equals(methodName)) {
				hasMethodName=true;
				break;
			}
		return !(declaredMethods.length<=numDeclaredMethods)||hasMethodName;
	}
	
}
