package gradingTools.comp524f20.assignment0_1.testcases.socialDistance;

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
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityTesterMainProvided;
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
@MaxValue(25)
public class SocialDistanceMainRuns extends PassFailJUnitTestCase {
	public static final int TIME_OUT_SECS = 1; // secs
	protected SubstringSequenceChecker checker = new ADistanceDurationChecker();	
	
	public static final String[] INPUT = {
			"15.0", "6.0", "1.0", "1.0", "0",
			"14.0", "6.0", "1.0", "1.0", "0",
			"16.0", "6.0", "1.0", "1.0", "0",
			
			"15.0", "5.0", "1.0", "1.0", "0",
			"15.0", "7.0", "1.0", "1.0", "0",
			
			"15.0", "12.0", "0.5", "1.0", "0",			
			"15.0", "13.0", "0.5", "1.0", "0",
			"15.0", "14.0", "0.5", "1.0", "0",

			
			"15.0", "12.0", "1.0", "0.5", "0",
			"15.0", "13.0", "1.0", "0.5",  "0",
			"15.0", "14.0", "1.0", "0.5",  "0",
			
			"15.0", "24.0",  "0.5", "0.5", "0",
			"15.0", "23.0",  "0.5", "0.5", "0",
			"15.0", "25.0",  "0.5", "0.5", "0",
			
			"15.0", "52.0",  "0.5", "0.5", "1",
			"15.0", "51.0",  "0.5", "0.5", "1",
			"15.0", "53.0",  "0.5", "0.5", "1",
			
			"15.0", "108.0",  "0.5", "0.5", "1",
			"15.0", "107.0",  "0.5", "0.5", "1",
			"15.0", "109.0",  "0.5", "0.5", "1",
			
			





			"-5.0"

			
	};
	
	protected  String output = null;

	public String getOutput() {
		return output;
	}




	




	public SocialDistanceMainRuns() {
	}


	

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
			SocialDistanceUtilityTesterMainProvided aSocialDistanceMainProvided = (SocialDistanceUtilityTesterMainProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceUtilityTesterMainProvided.class);
    		Class aSocialDistanceMain = aSocialDistanceMainProvided.getSocialDistanceMain();
			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setEntryPoint(aSocialDistanceMain.getName());
			RunningProject aRunningProject = RunningProjectUtils.runProject(project, TIME_OUT_SECS, INPUT);
			output = aRunningProject.await();
			LinesMatcher aLinesMatcher = aRunningProject.getLinesMatcher();
			boolean aRetval = checker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_LINE, Pattern.DOTALL);
			

			String anExpectedLines = Arrays.toString(checker.getSubstrings());

			if (!aRetval) {
				return fail("Output  did not match:" + anExpectedLines);

			}
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
