package gradingTools.comp524f19.assignment4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f19.assignment1.Assignment1Suite;
import gradingTools.comp524f19.assignment4.distributed.basic.DistributedBasicClientInput;
import gradingTools.comp524f19.assignment4.eager.basic.EagerBasicSuite;
import gradingTools.comp524f19.assignment4.eager.pool.EagerPoolSuite;
import gradingTools.comp524f19.assignment4.requiredClasses.A4RequiredClassesSuite;
import gradingTools.comp524f19.assignment4.testcases.CurryCheckers.A4CurrySuite;
import gradingTools.comp524f19.assignment4.testcases.CurryFreeVariablesCheckers.A4CurryFreeVariableSuite;
import gradingTools.comp524f19.assignment4.testcases.CurryableFunction.A4CurryableFunctionSuite;
import gradingTools.comp524f19.assignment4.testcases.DefunCheckers.A4DefunSuite;
import gradingTools.comp524f19.assignment4.testcases.FunFreeVariablesCheckers.A4FunFreeVariableSuite;
import gradingTools.comp524f19.assignment4.testcases.QuotedCheckers.A4QuotedSuite;
import main.lisp.interpreter.InterpreterModelFactory;
import main.lisp.interpreter.ObservableLispInterpreterWithEnvironment;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	A4RequiredClassesSuite.class,
	A4CurrySuite.class,
	A4DefunSuite.class,
	A4QuotedSuite.class,
	A4FunFreeVariableSuite.class,
	A4CurryFreeVariableSuite.class,
	A4CurryableFunctionSuite.class,
	EagerBasicSuite.class,
	EagerPoolSuite.class,
	DistributedBasicClientInput.class
})
	

//@MaxValue(50)
public class Assignment4SuitePD extends Assignment1Suite{
	static int processTimeOut = 5;

	public static int getProcessTimeOut() {
		return processTimeOut;
	}
	public static void setProcessTimeOut(int newVal) {
		processTimeOut = newVal;
		BasicProjectExecution.setProcessTimeOut(processTimeOut);
	}

	public static void main (String[] args) {
		try {

			InterpreterModelFactory.setClass(ObservableLispInterpreterWithEnvironment.class);
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//			BasicStaticConfigurationUtils.setModule("Comp524");
//			BasicStaticConfigurationUtils.setProblem("assignment2");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(assignment2Suite.class);
			Assignment4TraceUtility.setTracing();
			BasicJUnitUtils.interactiveTest(Assignment4SuitePD.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	static {
//		BasicProjectIntrospection.setCheckAllSpecifiedTags(true);
//		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//
//
//
//	}
}
