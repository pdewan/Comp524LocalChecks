package gradingTools.comp524f20.assignment0_4.testcases;

import grader.basics.execution.RunningProject;
import grader.basics.project.Project;
import gradingTools.shared.testcases.SubstringSequenceChecker;
import gradingTools.shared.testcases.greeting.AGreetingChecker;
import gradingTools.shared.testcases.greeting.GreetingRun;
import gradingTools.utils.RunningProjectUtils;
import util.annotations.MaxValue;
@MaxValue(10)
public class LispGreetingLoadAndRun extends GreetingRun {
	public static final int TIME_OUT_SECS = 1; // secs
	protected SubstringSequenceChecker checker = new AGreetingChecker();	

	public LispGreetingLoadAndRun() {
	}
	protected RunningProject createRunningProject (Project aProject) {
//		String aSourceFolder = aProject.getSourceFolder().getAbsolutePath();
//		String aTestFile = aSourceFolder + "\\Greeting.lisp";
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setEntryPoint(aTestFile);
//		RunningProject aRunningProject = RunningProjectUtils.runProject(aProject, TIME_OUT_SECS, "(greeting)", "(exit)");
		RunningProject aRunningProject = RunningProjectUtils.runProjectandWithMainFile(aProject, "Greeting.lisp", TIME_OUT_SECS, "(greeting)", "(exit)");
		return aRunningProject;
	}
	

}
