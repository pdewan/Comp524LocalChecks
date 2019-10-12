package gradingTools.comp524f19.assignment2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment2.requiredClasses.A2RequiredClassesSuite;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.A2BasicOperationSuite;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.A2LispFunctionSuite;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.A2LispLambdaSuite;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.A2LispSetqSuite;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.A2LogicalSuite;
import gradingTools.comp524f19.assignment2.testcases.RelationalCheckers.A2RelationalSuite;
import main.lisp.interpreter.InterpreterModelFactory;
import main.lisp.interpreter.ObservableLispInterpreterWithEnvironment;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	A2RequiredClassesSuite.class,
	A2BasicOperationSuite.class,
	A2LogicalSuite.class,
	A2RelationalSuite.class,
	A2LispFunctionSuite.class,
	A2LispSetqSuite.class,
	A2LispLambdaSuite.class
})
	

//@MaxValue(50)
public class Assignment2Suite {

	public static void main (String[] args) {
		try {

			InterpreterModelFactory.setClass(ObservableLispInterpreterWithEnvironment.class);
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//			BasicStaticConfigurationUtils.setModule("Comp524");
//			BasicStaticConfigurationUtils.setProblem("assignment2");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(assignment2Suite.class);
			Assignment2TraceUtility.setTracing();
			BasicJUnitUtils.interactiveTest(Assignment2Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicProjectIntrospection.setCheckAllSpecifiedTags(true);
		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);



	}
}
