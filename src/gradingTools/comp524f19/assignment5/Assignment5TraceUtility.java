package gradingTools.comp524f19.assignment5;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.logs.DifficultyCommandsExtractor;
import util.trace.Tracer;



	

//@MaxValue(50)
public class Assignment5TraceUtility {

	public static void setTracing () {
		try {
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//			BasicStaticConfigurationUtils.setModule("Comp524");
//			BasicStaticConfigurationUtils.setProblem("Assignment1");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(Assignment1Suite.class);
			Tracer.setKeywordPrintStatus(DifficultyCommandsExtractor.class, true);
			



		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicProjectIntrospection.setCheckAllSpecifiedTags(true);
		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);



	}
}
