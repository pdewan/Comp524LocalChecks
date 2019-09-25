package gradingTools.comp524f19.assignment2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionInputter;
//import gradingTools.comp524f19.assignment1.requiredClasses.A1RequiredClassesSuite;
//import gradingTools.comp524f19.assignment1.testcases.AbstractLispExpressionInputter;
//import gradingTools.comp524f19.assignment1.testcases.ClassRegistryProvided;
//import gradingTools.comp524f19.assignment1.testcases.SExpressionClassProvided;
//import gradingTools.comp524f19.assignment1.testcases.load.A1LoadSuite;
//import gradingTools.comp524f19.assignment1.testcases.load.AbstractFunctionTestedChecker;
//import gradingTools.comp524f19.assignment1.testcases.load.AbstractFunctionTestedCondChecker;
//import gradingTools.comp524f19.assignment1.testcases.load.AbstractFunctionTestedTwoResultsChecker;
//import gradingTools.comp524f19.assignment1.testcases.load.TestLispFileProvided;
//import gradingTools.comp524f19.assignment1.testcases.loadLogical.A1LoadLogicalSuite;
//import gradingTools.comp524f19.assignment1.testcases.loadLogical.AbstractFunctionTestedLogicalChecker;
//import gradingTools.comp524f19.assignment1.testcases.loadLogical.AbstractFunctionTestedTwoResultsLogicalChecker;
//import gradingTools.comp524f19.assignment1.testcases.loadRelation.A1LoadRelationSuite;
//import gradingTools.comp524f19.assignment1.testcases.loadRelation.AbstractFunctionTestedRelationChecker;
//import gradingTools.comp524f19.assignment1.testcases.loadRelation.AbstractFunctionTestedTwoResultsRelationChecker;
//import gradingTools.comp524f19.assignment1.testcases.toString.A1ToStringSuite;
//import gradingTools.comp524f19.assignment1.testcases.toString.BaseCaseSExpressionToStringChecker;
import util.annotations.MaxValue;
import util.trace.Tracer;



	

//@MaxValue(50)
public class Assignment2TraceUtility {

	public static void setTracing () {
		try {
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//			BasicStaticConfigurationUtils.setModule("Comp524");
//			BasicStaticConfigurationUtils.setProblem("Assignment1");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(Assignment1Suite.class);
			Tracer.setKeywordPrintStatus(AbstractLispExpressionInputter.class, true);




		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicProjectIntrospection.setCheckAllSpecifiedTags(true);
		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);



	}
}
