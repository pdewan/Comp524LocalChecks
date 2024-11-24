package gradingTools.comp524f24.assignment5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment1.Assignment1TraceUtility;
import gradingTools.comp524f19.assignment1.requiredClasses.LispInterpreterRequiredClassesSuite;
import gradingTools.comp524f19.assignment1.testcases.load.LispInterpreterLoadSuite;
//import gradingTools.comp524f19.assignment1.testcases.load.TestLispFileProvided;
import gradingTools.comp524f19.assignment4.requiredClasses.TestLispFileProvided;
import gradingTools.comp524f19.assignment1.testcases.loadLogical.LispInterpreterLoadLogicalSuite;
import gradingTools.comp524f19.assignment1.testcases.loadRelation.LispInterpreterLoadRelationSuite;
import gradingTools.comp524f20.assignment6.LispToStringSuite;
import gradingTools.comp524f20.assignment6.LogicalSuite;
import gradingTools.comp524f20.assignment6.RelationalSuite;
import gradingTools.comp524f21.assignment5.A5AssignmentSpecificSourceChecks;
import gradingTools.comp524f21.assignment5.A5GeneralStyle;
import gradingTools.comp524f21.assignment5.toString.A5ToStringSuite;
import gradingTools.comp524f21.assignment6.testCases.basicOperations.A6BasicOperationSuite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	LispInterpreterRequiredClassesSuite.class,
	TestLispFileProvided.class,
	JavaToStringSuite.class,
//	LispToStringIsLispSuite.class,
	LispInterpreterLoadSuite.class,
	LispInterpreterLoadLogicalSuite.class,
	LispInterpreterLoadRelationSuite.class,	
	BasicOperationsSuite.class,
	LogicalSuite.class,
	RelationalSuite.class,
	A5GeneralStyle.class,
	A5AssignmentSpecificSourceChecks.class,
})
//1.1, 2.2, 3.16, 4.6, 5.11, 6.6, 7.7, 8.8, 9.1
// 58

//@MaxValue(50)
public class F24Assignment5Suite {

	public static void main (String[] args) {
		try {
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//			BasicStaticConfigurationUtils.setModule("Comp524");
//			BasicStaticConfigurationUtils.setProblem("Assignment1");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(Assignment1Suite.class);
			Assignment1TraceUtility.setTracing();
			BasicJUnitUtils.interactiveTest(F24Assignment5Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicProjectIntrospection.setCheckAllSpecifiedTags(true);
		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);



	}
	static {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
		setCheckStyleConfiguration("unc_checks_524_A5.xml");
	}
}
