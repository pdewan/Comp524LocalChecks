package gradingTools.comp524f20.assignment3.functionParamaters;

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
public class MatchingGivenSafe extends AnAbstractThreeParameterSMLRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public MatchingGivenSafe() {
	}
	
	private String functionName="matchingGivenSafe";
	
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
			
			false, //2
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //3
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //4
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //5
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //6
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //7
			false,
			false,
			false,
			false,
			false,
			
			false, //8
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //9
			false,
			false,
			false,
			false,
			false,
			false,
			
			false,	//10
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
			
			boolean preReqPassed = ((MatchingSafe) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(MatchingSafe.class)).hasPassed();
			if(!preReqPassed) 
				return fail("MatchingSafe Must Pass first");
			
			
			boolean aRetval = regexOutputChecks(parseToReadable(output.split("\n")),boolToRegex(regexChecks),inputs);

			if (!aRetval) 
				return fail("View console for more detail");
			return pass();
			

		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}
	
	@Override
	protected String [] generateFunctionCalls(String functionName) {
		setInputNewLine(8);
		int [][] inputList=this.getInputList();
		String [] retVal = new String[inputList.length+1];
		retVal[0]=getReadabilityCommand();
		for(int i=0;i<inputList.length;i++) 
			retVal[i+1]=functionName+"(("+inputList[i][0]+","+inputList[i][1]+","+inputList[i][2]+"));";
		return retVal;
	}
	
}
