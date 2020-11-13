package gradingTools.comp524f20.assignment6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment2.Assignment2TraceUtility;
import gradingTools.comp524f19.assignment2.requiredClasses.A2RequiredClassesSuite;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.A2BasicOperationSuite;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.A2LispFunctionSuite;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.A2LispLambdaSuite;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.A2LispSetqSuite;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.A2LogicalSuite;
import gradingTools.comp524f19.assignment2.testcases.RelationalCheckers.A2RelationalSuite;
import gradingTools.comp524f19.assignment3.requiredClasses.A3RequiredClassesSuite;
import gradingTools.comp524f19.assignment3.testcases.CurryCheckers.A3CurrySuite;
import gradingTools.comp524f19.assignment3.testcases.FunctionExpressionsCheckers.A3FunctionExpressionsSuite;
import gradingTools.comp524f19.assignment3.testcases.HighOderFunctionCheckers.A3HighOrderFunctionSuite;
import gradingTools.comp524f19.assignment3.testcases.LetCheckers.A3LetSuite;
import gradingTools.comp524f19.assignment4.requiredClasses.A4RequiredClassesSuite;
import gradingTools.comp524f20.assignment6.testcases.socialDistance.FuncallSocialDistanceSuite;
import main.lisp.interpreter.InterpreterModelFactory;
import main.lisp.interpreter.ObservableLispInterpreterWithEnvironment;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	A6RequiredClassesSuite.class,
	BasicOperationSuite.class,
	LogicalSuite.class,
	RelationalSuite.class,
	LispFunctionSuite.class,
	LispSetqSuite.class,
	LispLambdaSuite.class,
	HighOrderFunctionSuite.class,
	FunctionExpressionsSuite.class,
	CurrySuite.class,
	FuncallSocialDistanceSuite.class
})
	

//@MaxValue(50)
public class F20Assignment6Suite {

	public static void main (String[] args) {
		try {

			InterpreterModelFactory.setClass(ObservableLispInterpreterWithEnvironment.class);
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//			BasicStaticConfigurationUtils.setModule("Comp524");
//			BasicStaticConfigurationUtils.setProblem("assignment2");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(assignment2Suite.class);
			Assignment2TraceUtility.setTracing();
			BasicJUnitUtils.interactiveTest(F20Assignment6Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicProjectIntrospection.setCheckAllSpecifiedTags(true);
		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);



	}
}
