package gradingTools.comp524f22.assignment5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment1.Assignment1TraceUtility;
import gradingTools.comp524f19.assignment1.requiredClasses.LispInterpreterRequiredClassesSuite;
import gradingTools.comp524f19.assignment1.testcases.load.LispInterpreterLoadSuite;
import gradingTools.comp524f19.assignment1.testcases.load.TestLispFileProvided;
import gradingTools.comp524f19.assignment1.testcases.loadLogical.LispInterpreterLoadLogicalSuite;
import gradingTools.comp524f19.assignment1.testcases.loadRelation.LispInterpreterLoadRelationSuite;
import gradingTools.comp524f21.assignment5.A5AssignmentSpecificSourceChecks;
import gradingTools.comp524f21.assignment5.A5GeneralStyle;
import gradingTools.comp524f21.assignment5.toString.A5ToStringSuite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	LispInterpreterRequiredClassesSuite.class,
	A5ToStringSuite.class,
	TestLispFileProvided.class,
	LispInterpreterLoadSuite.class,
	LispInterpreterLoadLogicalSuite.class,
	LispInterpreterLoadRelationSuite.class,
	A5GeneralStyle.class,
	A5AssignmentSpecificSourceChecks.class,
})
	

//@MaxValue(50)
public class F22Assignment5Suite {

	public static void main (String[] args) {
		try {
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//			BasicStaticConfigurationUtils.setModule("Comp524");
//			BasicStaticConfigurationUtils.setProblem("Assignment1");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(Assignment1Suite.class);
			Assignment1TraceUtility.setTracing();
			BasicJUnitUtils.interactiveTest(F22Assignment5Suite.class);


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
