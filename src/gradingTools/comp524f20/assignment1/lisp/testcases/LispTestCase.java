package gradingTools.comp524f20.assignment1.lisp.testcases;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.NotRunnableException;
import grader.basics.execution.RunningProject;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.project.source.ABasicTextManager;
import grader.basics.testcase.PassFailJUnitTestCase;
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

public class LispTestCase extends PassFailJUnitTestCase {
	public static final int TIME_OUT_SECS = 1; // secs
	protected SubstringSequenceChecker checker = new ASequentialSumChecker();	

	public LispTestCase() {
	}

	

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
			String aSourceFolder = project.getSourceFolder().getAbsolutePath();
			String aTestFile = aSourceFolder + "\\test.lisp";
			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setEntryPoint(aTestFile);
			RunningProject aRunningProject = RunningProjectUtils.runProject(project, TIME_OUT_SECS);
			String anOutput = aRunningProject.await();
			LinesMatcher aLinesMatcher = aRunningProject.getLinesMatcher();
			boolean aRetval = checker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_LINE, Pattern.DOTALL);
			String aSource = project.getSource();
//			Map<String, StringBuffer> aFileNameToContents = ABasicTextManager.extractFileContents(aSource);
//			for (String aFileName:aFileNameToContents.keySet()) {
//				StringBuffer aFileContents = aFileNameToContents.get(aFileName);
////				List<OpenMPPragma> anOpenMPPragmas = OpenMPUtils.getOpemMPPragmas(aFileContents);
//				SNode anSNode = OMPSNodeUtils.getSNode(aFileName, aFileContents);
//				System.out.println("file name:" + aFileName);
//				System.out.println("pragmas:" + anSNode);
//			}
			RootOfProgramSNode aRootOfProgramSNode = OMPSNodeUtils.getRootOfProgramSNode(aSource);
			Set<AssignmentSNode> anAssignments = OMPSNodeUtils.assignmentsToSharedVariables(aRootOfProgramSNode);
			Set<AssignmentSNode> anAssignmentsToSharedArrays = OMPSNodeUtils.assignmentsToSharedArrays(aRootOfProgramSNode);
			Set<AssignmentSNode> anAssignmentsToParallelCriticalSharedVariables = OMPSNodeUtils.assignmentsToParallelCriticalSharedVariables(aRootOfProgramSNode);
			Set<AssignmentSNode> anAssignmentsToNonParallelCriticalSharedVariables  = OMPSNodeUtils.assignmentsToNonParallelCriticalSharedVariables(aRootOfProgramSNode);
			Set<AssignmentSNode> anAssignmentsToParallelNonCriticalSharedVariables = OMPSNodeUtils.assignmentsToParallelNonCriticalSharedVariables(aRootOfProgramSNode);
			Set<OMPParallelSNode> anOMPParallelSNodes = OMPSNodeUtils.ompParallelSNodes(aRootOfProgramSNode);
			Set<ForSNode> aForSNodes = OMPSNodeUtils.forSNodes(aRootOfProgramSNode);
			Set<OMPForSNode> anOMPForSNodes = OMPSNodeUtils.ompForSNodes(aRootOfProgramSNode);
			Set<OMPForSNode> anOMPReducingForSNodes = OMPSNodeUtils.ompReducingForNodes(aRootOfProgramSNode);
			for (OMPForSNode anOMPForSNode:anOMPReducingForSNodes) {
				Set<AssignmentSNode> anAssignmentsToReducingForNode = OMPSNodeUtils.assignmentsToOMPReducingForNode(anOMPForSNode);
				if (anAssignmentsToReducingForNode.isEmpty()) {
					System.err.println(anOMPForSNode + " does not have assignment to:" + anOMPForSNode.getReductionVariable());
				}
			}


			


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
