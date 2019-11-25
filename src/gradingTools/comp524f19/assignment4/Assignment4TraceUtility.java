package gradingTools.comp524f19.assignment4;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionInputterAndEvaluatorRegisterer;
import gradingTools.comp524f19.assignment4.immutableJoiner.A4EarlyJoinImmutableJoinerTester;
import util.trace.Tracer;



	

//@MaxValue(50)
public class Assignment4TraceUtility {

	public static void setTracing () {
		try {
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//			BasicStaticConfigurationUtils.setModule("Comp524");
//			BasicStaticConfigurationUtils.setProblem("Assignment1");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(Assignment1Suite.class);
			Tracer.setKeywordPrintStatus(AbstractLispExpressionInputterAndEvaluatorRegisterer.class, true);
			Tracer.setKeywordPrintStatus(A4EarlyJoinImmutableJoinerTester.class, true);





		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicProjectIntrospection.setCheckAllSpecifiedTags(true);
		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);



	}
}
