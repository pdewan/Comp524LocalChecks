package gradingTools.comp524f20.assignment3.listsAndRecursion;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

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
import gradingTools.comp524f19.assignment1.testcases.MainClassProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SafeSocializationtxtProvided;
import gradingTools.comp524f20.assignment2.AnAbstractPrologRunningProject;
import gradingTools.comp524f20.assignment2.requiredFiles.SocialDistancePlProvided;
import gradingTools.comp524f20.assignment3.AnAbstractThreeParameterSMLRunningProject;
import gradingTools.comp524f20.assignment3.requiredFiles.SocialDistanceSMLProvided;
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
public class ListDerivedSafeSML extends AnAbstractThreeParameterSMLRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public ListDerivedSafeSML() {
	}
	
	private String functionName="listDerivedSafe";
	
	public static boolean[] getRegexChecks() {
		return regexChecks;
	}
	
	private static boolean[] regexChecks= {
			true, //1
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //2
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //3
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //4
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //5
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //6
			false,
			false,
			false,
			false,
			false,
			false,
			
			true, //7
			true,
			true,
			false,
			false,
			false,
			
			true, //8
			true,
			true,
			true,
			true,
			true,
			false,
			
			false, //9
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //10
			false,
			false,
			false,
			false,
			false,
			false
	};
	

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {

			SocialDistanceSMLProvided aSocialDistanceFileProvided = (SocialDistanceSMLProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceSMLProvided.class);			
			if (aSocialDistanceFileProvided.getRequiredFile() == null) 
				return fail ("A Social Distance File not Found");
			
			String [] inputs = generateFunctionCalls(functionName);
			RunningProject aRunningProject = createRunningProject(project,aSocialDistanceFileProvided.getFileName(),inputs);
			if (aRunningProject == null) 
				return fail ("Could not create project. See console messages.");
			
			String output = aRunningProject.getOutput();
			if (output == null || output.length()==0) 
				return fail ("Could not generate output. See console messages.");
			
			
			boolean aRetval = regexOutputChecks(parseToReadable(output.split("\n")),boolToRegex(regexChecks),inputs);

			if (!aRetval) 
				return fail("View console for more detail");
			return pass();
			

		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}
}
