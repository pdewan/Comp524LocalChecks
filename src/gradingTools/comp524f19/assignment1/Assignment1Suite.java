package gradingTools.comp524f19.assignment1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment1.requiredClasses.LispInterpreterRequiredClassesSuite;
import gradingTools.comp524f19.assignment1.testcases.load.LispInterpreterLoadSuite;
import gradingTools.comp524f19.assignment1.testcases.loadLogical.LispInterpreterLoadLogicalSuite;
import gradingTools.comp524f19.assignment1.testcases.loadRelation.LispInterpreterLoadRelationSuite;
import gradingTools.comp524f19.assignment1.testcases.toString.A1ToStringSuite;
import gradingTools.comp524f19.assignment4.requiredClasses.TestLispFileProvided;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	LispInterpreterRequiredClassesSuite.class,
	A1ToStringSuite.class,
	TestLispFileProvided.class,
	LispInterpreterLoadSuite.class,
	LispInterpreterLoadLogicalSuite.class,
	LispInterpreterLoadRelationSuite.class
	
})
	

//@MaxValue(50)
public class Assignment1Suite {

	public static void main (String[] args) {
		try {
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//			BasicStaticConfigurationUtils.setModule("Comp524");
//			BasicStaticConfigurationUtils.setProblem("Assignment1");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(Assignment1Suite.class);
			Assignment1TraceUtility.setTracing();
			BasicJUnitUtils.interactiveTest(Assignment1Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicProjectIntrospection.setCheckAllSpecifiedTags(true);
		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);



	}
}
