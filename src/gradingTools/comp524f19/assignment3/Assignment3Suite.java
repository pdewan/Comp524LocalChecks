package gradingTools.comp524f19.assignment3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment3.requiredClasses.A3RequiredClassesSuite;
import gradingTools.comp524f19.assignment3.testcases.CurryCheckers.A3CurrySuite;
import gradingTools.comp524f19.assignment3.testcases.FunctionExpressionsCheckers.A3FunctionExpressionsSuite;
import gradingTools.comp524f19.assignment3.testcases.HighOderFunctionCheckers.A3HighOrderFunctionSuite;
import gradingTools.comp524f19.assignment3.testcases.LetCheckers.A3LetSuite;
import main.lisp.interpreter.InterpreterModelFactory;
import main.lisp.interpreter.ObservableLispInterpreterWithEnvironment;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	A3RequiredClassesSuite.class,
	A3HighOrderFunctionSuite.class,
	A3FunctionExpressionsSuite.class,
	A3LetSuite.class,
	A3CurrySuite.class
	
})
	

//@MaxValue(50)
public class Assignment3Suite {

	public static void main (String[] args) {
		try {

			InterpreterModelFactory.setClass(ObservableLispInterpreterWithEnvironment.class);
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//			BasicStaticConfigurationUtils.setModule("Comp524");
//			BasicStaticConfigurationUtils.setProblem("assignment2");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(assignment2Suite.class);
			Assignment3TraceUtility.setTracing();
			BasicJUnitUtils.interactiveTest(Assignment3Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicProjectIntrospection.setCheckAllSpecifiedTags(true);
		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);



	}
}
