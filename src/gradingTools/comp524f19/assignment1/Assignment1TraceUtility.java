package gradingTools.comp524f19.assignment1;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment1.testcases.AbstractLispExpressionInputter;
import gradingTools.comp524f19.assignment1.testcases.load.AbstractFunctionTestedChecker;
import gradingTools.comp524f19.assignment1.testcases.load.AbstractFunctionTestedCondChecker;
import gradingTools.comp524f19.assignment1.testcases.load.AbstractFunctionTestedTwoResultsChecker;
import gradingTools.comp524f19.assignment1.testcases.loadLogical.AbstractFunctionTestedLogicalChecker;
import gradingTools.comp524f19.assignment1.testcases.loadLogical.AbstractFunctionTestedTwoResultsLogicalChecker;
import gradingTools.comp524f19.assignment1.testcases.loadRelation.AbstractFunctionTestedRelationChecker;
import gradingTools.comp524f19.assignment1.testcases.loadRelation.AbstractFunctionTestedTwoResultsRelationChecker;
import util.trace.Tracer;



	

//@MaxValue(50)
public class Assignment1TraceUtility {

	public static void setTracing () {
		try {
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//			BasicStaticConfigurationUtils.setModule("Comp524");
//			BasicStaticConfigurationUtils.setProblem("Assignment1");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(Assignment1Suite.class);
			Tracer.setKeywordPrintStatus(AbstractLispExpressionInputter.class, true);
			Tracer.setKeywordPrintStatus(AbstractFunctionTestedChecker.class, true);
			Tracer.setKeywordPrintStatus(AbstractFunctionTestedTwoResultsChecker.class, true);
			Tracer.setKeywordPrintStatus(AbstractFunctionTestedRelationChecker.class, true);
			Tracer.setKeywordPrintStatus(AbstractFunctionTestedTwoResultsRelationChecker.class, true);
			Tracer.setKeywordPrintStatus(AbstractFunctionTestedCondChecker.class, true);
			Tracer.setKeywordPrintStatus(AbstractFunctionTestedLogicalChecker.class, true);
			Tracer.setKeywordPrintStatus(AbstractFunctionTestedTwoResultsLogicalChecker.class, true);



		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicProjectIntrospection.setCheckAllSpecifiedTags(true);
		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);



	}
}
