package gradingTools.comp524f21.assignment6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment2.Assignment2TraceUtility;
import gradingTools.comp524f20.assignment6.A6RequiredClassesSuite;
import gradingTools.comp524f20.assignment6.LispLambdaSuite;
import gradingTools.comp524f20.assignment6.LispSetqSuite;
import gradingTools.comp524f20.assignment6.LispToStringSuite;
import gradingTools.comp524f20.assignment6.LogicalSuite;
import gradingTools.comp524f20.assignment6.RelationalSuite;
import gradingTools.comp524f20.assignment6.testcases.curry.BasicCurrySuite;
import gradingTools.comp524f20.assignment6.testcases.functionExpression.BasicFunctionExpressionSuite;
import gradingTools.comp524f20.assignment6.testcases.socialDistance.FuncallSocialDistanceSuite;
import gradingTools.comp524f21.assignment6.testCases.basicOperations.A6BasicOperationSuite;
import gradingTools.comp524f21.assignment6.testCases.let.A6LetSuite;
import main.lisp.interpreter.InterpreterModelFactory;
import main.lisp.interpreter.ObservableLispInterpreterWithEnvironment;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	A6RequiredClassesSuite.class,
	A6BasicOperationSuite.class,
	LogicalSuite.class,
	RelationalSuite.class,
	LispToStringSuite.class,
	LispSetqSuite.class,
	LispLambdaSuite.class,
//	HighOrderFunctionSuite.class,
//	TraverseFunctionExpressionsSuite.class,
//	ToStringAtomCurrySuite.class,
	FuncallSocialDistanceSuite.class,
	BasicFunctionExpressionSuite.class,
	BasicCurrySuite.class,
	A6LetSuite.class
	
})
	

//@MaxValue(50)
public class F21Assignment6Suite {

	public static void main (String[] args) {
		try {

			InterpreterModelFactory.setClass(ObservableLispInterpreterWithEnvironment.class);
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//			BasicStaticConfigurationUtils.setModule("Comp524");
//			BasicStaticConfigurationUtils.setProblem("assignment2");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(assignment2Suite.class);
			Assignment2TraceUtility.setTracing();
			BasicJUnitUtils.interactiveTest(F21Assignment6Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicProjectIntrospection.setCheckAllSpecifiedTags(true);
		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);



	}
}
