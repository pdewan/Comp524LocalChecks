package gradingTools.comp524f20.assignment0_3.testcases;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.NotRunnableException;
import grader.basics.execution.RunningProject;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.project.source.ABasicTextManager;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f20.assignment0_1.testcases.AGreetingChecker;
import gradingTools.comp524f20.assignment0_1.testcases.GreetingMainProvided;
import gradingTools.comp524f20.assignment0_1.testcases.GreetingRun;
import gradingTools.comp524f20.assignment4.lisp.testcases.ASequentialSumChecker;
import gradingTools.shared.testcases.SubstringSequenceChecker;
import gradingTools.shared.testcases.openmp.OpenMPPragma;
import gradingTools.shared.testcases.openmp.OpenMPUtils;
import gradingTools.shared.testcases.openmp.scannedTree.AssignmentSNode;
import gradingTools.shared.testcases.openmp.scannedTree.ExternalMethodSNode;
import gradingTools.shared.testcases.openmp.scannedTree.ForSNode;
import gradingTools.shared.testcases.openmp.scannedTree.MethodSNode;
import gradingTools.shared.testcases.openmp.scannedTree.OMPForSNode;
import gradingTools.shared.testcases.openmp.scannedTree.OMPParallelSNode;
import gradingTools.shared.testcases.openmp.scannedTree.OMPSNodeUtils;
import gradingTools.shared.testcases.openmp.scannedTree.RootOfFileSNode;
import gradingTools.shared.testcases.openmp.scannedTree.RootOfProgramSNode;
import gradingTools.shared.testcases.openmp.scannedTree.SNode;
import gradingTools.shared.testcases.utils.LinesMatchKind;
import gradingTools.shared.testcases.utils.LinesMatcher;
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
