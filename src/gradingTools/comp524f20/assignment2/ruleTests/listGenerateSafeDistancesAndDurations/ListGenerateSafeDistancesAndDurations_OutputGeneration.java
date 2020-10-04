package gradingTools.comp524f20.assignment2.ruleTests.listGenerateSafeDistancesAndDurations;

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
@MaxValue(2)
public class ListGenerateSafeDistancesAndDurations_OutputGeneration extends AnAbstractPrologRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public ListGenerateSafeDistancesAndDurations_OutputGeneration() {
	}
	
	private String [] recursionTestInput= {
			"write('recursion validation below\n---\n').",
			"trace(listGenerateSafeDistancesAndDurations,call).",
			"write('tracing was turned on\n').",
			"listGenerateSafeDistancesAndDurations(12,GeneratedTable). ; .",
			
			"halt."	
	};
	
	private String [] recursionTestRegex={
		"^---.*",
		"^---.*",
		".*Call.*listGenerateSafeDistancesAndDurations.*",
		".*Call.*listGenerateSafeDistancesAndDurations.*",
		".*Call.*listGenerateSafeDistancesAndDurations.*"
	};
	
	private String [] trueValueInputs= {
			
			"listGenerateSafeDistancesAndDurations(9,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(0,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(10,GeneratedTable). ; .",
			
			"listGenerateSafeDistancesAndDurations(11,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(11,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(11,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(29,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(29,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(29,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(30,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(30,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(30,GeneratedTable). ; .",
			
			"listGenerateSafeDistancesAndDurations(31,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(49,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(50,GeneratedTable). ; .",
	};
	private String [] falseValueInputs= {
			"write('ListGenerateSafeDistancesAndDurations false outputs below\n---\n').",
			
			"listGenerateSafeDistancesAndDurations(51,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(70,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(101,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(2147483647,GeneratedTable). ; .",
			
			
	};
	
	protected String [] getTrueValueInputs() {
		return trueValueInputs;
	}
	protected String [] getFalseValueInputs() {
		return falseValueInputs;
	}
	
	private String output=null;
	
	public String getOutput() {
		return output;
	}
	
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {

			SocialDistancePlProvided aSocialDistanceFileProvided = (SocialDistancePlProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistancePlProvided.class);			
			
			String [] inputs=combineArrays(getTrueValueInputs(),getFalseValueInputs(),recursionTestInput);
			
			RunningProject aRunningProject = createRunningProject(project,aSocialDistanceFileProvided.getFileName(),inputs);
			if (aRunningProject == null) {
				return fail ("Could not create project. See console messages.");
			}

			String anOutput = aRunningProject.await().replaceAll("\n\n", "\n").replaceAll("\n\n", "\n");
//			LinesMatcher aLinesMatcher = aRunningProject.getLinesMatcher();
			
			String errOutput=aRunningProject.getOutputAndErrors().replaceAll("\n\n", "\n").replaceAll("\n\n", "\n");
			boolean retVal=this.regexOutputChecks(errOutput.split("\n"), recursionTestRegex);
			if(!retVal) {
				anOutput=null;
				return fail("recursion not detected in prolog traces");
			}
						
			if(anOutput==null||anOutput.length()==0) {
				return fail("output from running commands is null or empty");
			}
			
			output=anOutput;
			return pass();
			

		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}
//	public static void processExternalMethodSNodes (RootOfProgramSNode aRootOfProgramSNode, RootOfFileSNode aRootOfFileSNode) {
//		for (SNode anSNode:aRootOfFileSNode.getChildren()) {
//			if (anSNode instanceof ExternalMethodSNode) {
//				processExternalMethodSNode(aRootOfProgramSNode, aRootOfFileSNode, (ExternalMethodSNode) anSNode);
//			}
//		}
//	}
//	public static void processExternalMethodSNode (RootOfProgramSNode aRootOfProgramSNode, RootOfFileSNode aRootOfFileSNode, ExternalMethodSNode anExternalMethodSNode) {
//		MethodSNode aMethodSNode = aRootOfProgramSNode.getExternalToInternalMethod().get(anExternalMethodSNode.toString());
//		if (aMethodSNode == null) {
//			aMethodSNode = findMethodSNode(aRootOfProgramSNode, aRootOfFileSNode, anExternalMethodSNode);
//			if (aMethodSNode != null) {
//				aRootOfProgramSNode.getExternalToInternalMethod().put(anExternalMethodSNode.toString(),aMethodSNode );
//			}
//		}
//		if (aMethodSNode != null) {
//			anExternalMethodSNode.setActualMethodSNode(aMethodSNode);
//		}
//	}
//	public static MethodSNode findMethodSNode (RootOfProgramSNode aRootOfProgramSNode, RootOfFileSNode aRootOfFileSNode, ExternalMethodSNode anExternalMethodSNode) {
////		MethodSNode foundMethodSNode = null;
//		for (String aFileName:aRootOfProgramSNode.getFileNameToSNode().keySet()) {
//			if (aFileName.equals(aRootOfFileSNode.getFileName()))
//				continue;
//			
//			RootOfFileSNode aSearchedRootOfFileSNode = aRootOfProgramSNode.getFileNameToSNode().get(aFileName);
//			 for (SNode anSNode:aSearchedRootOfFileSNode.getChildren()) {
//				if (anSNode instanceof MethodSNode && !(anSNode instanceof ExternalMethodSNode)) {
//					if (anSNode.toString().equals(anExternalMethodSNode)) {
//						return (MethodSNode) anSNode;
//						
//					}
////					processExternalMethodSNode(aRootOfProgramSNode, aRootOfFileSNode, (ExternalMethodSNode) anSNode);
//				}
//			}
//		}
//		return null;
//	}
//	public static void processExternalMethodSNodes (RootOfProgramSNode aRootOfProgramSNode) {
//		for (String aFileName:aRootOfProgramSNode.getFileNameToSNode().keySet()) {
//			RootOfFileSNode aRootOfFileSNode = aRootOfProgramSNode.getFileNameToSNode().get(aFileName);
//			processExternalMethodSNodes(aRootOfProgramSNode, aRootOfFileSNode);
//			
//		}
//
//	}
}
