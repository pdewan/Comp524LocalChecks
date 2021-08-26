package gradingTools.comp524f20.assignment0_2.testcases;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.RunningProject;
import grader.basics.project.Project;
import gradingTools.shared.testcases.SubstringSequenceChecker;
import gradingTools.shared.testcases.greeting.GreetingRun;
import gradingTools.utils.RunningProjectUtils;
import util.annotations.MaxValue;
@MaxValue(10)
public class PrologGreetingLoadAndRun extends GreetingRun {
	public static final int TIME_OUT_SECS = 1; // secs
	protected SubstringSequenceChecker checker = new gradingTools.shared.testcases.greeting.AGreetingChecker();	

	public PrologGreetingLoadAndRun() {
	}
	protected RunningProject createRunningProject (Project aProject) {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.PROLOG_LANGUAGE);

//		String aSourceFolder = aProject.getSourceFolder().getAbsolutePath();
//		String aTestFile = aSourceFolder + "\\Greeting.pl";
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setEntryPoint(aTestFile);
//		RunningProject aRunningProject = RunningProjectUtils.runProject(aProject, TIME_OUT_SECS, "greeting().", "halt.");
		RunningProject aRunningProject = RunningProjectUtils.runProjectandWithMainFile(aProject, "Greeting.pl", TIME_OUT_SECS, "greeting().", "halt.");

		return aRunningProject;
	}
	

}
