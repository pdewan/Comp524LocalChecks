package gradingTools.comp524f19.assignment2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment1.requiredClasses.A1RequiredClassesSuite;
import gradingTools.comp524f19.assignment2.requiredClasses.A2RequiredClassesSuite;
import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionInputter;
import gradingTools.comp524f19.assignment2.testcases.ClassRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.SExpressionClassProvided;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.A2BasicOperationSuite;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.A2LogicalSuite;
import gradingTools.comp524f19.assignment2.testcases.RelationalCheckers.A2RelationalSuite;
import util.annotations.MaxValue;
import util.trace.Tracer;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	A2RequiredClassesSuite.class,
	A2BasicOperationSuite.class,
	A2LogicalSuite.class,
	A2RelationalSuite.class
})
	

//@MaxValue(50)
public class Assignment2Suite {

	public static void main (String[] args) {
		try {
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
