package gradingTools.comp524f20.assignment4;

import gradingTools.comp524f20.assignment3.F20Assignment3Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.Tracer;

public class A3LocalProjectGrader {

	private final static String projectLocation="C:\\Users\\ajwortas\\OneDrive\\Comp_524_Grading\\Assignment3";
	
	public static void main(String[] args) throws Exception {
		Tracer.showInfo(true);
		GraderBasicsTraceUtility.setBufferTracedMessages(true);
		F20Assignment3Suite.setProjectLocation(projectLocation);
		F20Assignment3Suite.main(args);

	}

}
