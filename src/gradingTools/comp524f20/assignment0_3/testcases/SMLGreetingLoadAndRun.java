package gradingTools.comp524f20.assignment0_3.testcases;

import java.io.File;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.RunningProject;
import grader.basics.project.Project;
import gradingTools.shared.testcases.SubstringSequenceChecker;
import gradingTools.shared.testcases.greeting.AGreetingChecker;
import gradingTools.shared.testcases.greeting.GreetingRun;
import gradingTools.utils.RunningProjectUtils;
import util.annotations.MaxValue;
@MaxValue(10)
public class SMLGreetingLoadAndRun extends GreetingRun {
	public static final int TIME_OUT_SECS = 1; // secs
	protected SubstringSequenceChecker checker = new AGreetingChecker();	

	public SMLGreetingLoadAndRun() {
	}
	protected RunningProject createRunningProject (Project aProject) {
		File aFile = new File(".");
		String aFullName = aFile.getAbsolutePath();
		
//		String aSourceFolder = aProject.getSourceFolder().getAbsolutePath();
//		String aTestFile = aSourceFolder + "\\Greeting.sml";
//		File aFile = new File(aTestFile);
//		if (!aFile.exists()) {
//			System.err.println(aFile + " does not exist.");
//			return null;
//		}
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setEntryPoint(aTestFile);
		 BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
			setForkInProjectFolder(false);
		RunningProject aRunningProject = RunningProjectUtils.runProjectandWithMainFile (aProject, "Greeting.sml",  TIME_OUT_SECS, "greeting();","OS.Process.exit(OS.Process.success);");
		return aRunningProject;
	}
	

}
