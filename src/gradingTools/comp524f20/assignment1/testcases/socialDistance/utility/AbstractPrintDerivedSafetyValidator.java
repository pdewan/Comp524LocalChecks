package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import grader.basics.config.BasicExecutionSpecification;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.NotRunnableException;
import grader.basics.execution.ResultWithOutput;
import grader.basics.execution.RunningProject;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.project.source.ABasicTextManager;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f19.assignment1.testcases.MainClassProvided;
import gradingTools.comp524f20.assignment1.SocialDistanceClassRegistry;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityProvided;
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
import main.ClassRegistry;
import util.annotations.MaxValue;
import util.trace.Tracer;

public abstract class AbstractPrintDerivedSafetyValidator extends PassFailJUnitTestCase {
	public static final int TIME_OUT_MSECS = 300; // secs
	

	protected static  String verifyingMethodName = "isDerivedSafe";
	protected static Class[] NO_ARG_TYPES = {};
	protected static Class[] VERIFYING_ARG_TYPES = {Integer.TYPE, Integer.TYPE, Integer.TYPE};

	protected static Object[] NO_ARGS = {};

	protected  abstract String methodName();
	
	protected  String verifyingMethodName() {
		return verifyingMethodName;
	}
	
	protected  Class[] argumentTypes() {
		return NO_ARG_TYPES;
	}
	
	protected  Class[] verifyingArgumentTypes() {
		return VERIFYING_ARG_TYPES;
	}
	
	
	protected  Object[] getArguments() {
		return NO_ARGS;
	}

	protected boolean verify (String anOutput, Class aStaticClass, Method aVerifyingMethod) throws Throwable {
		String[] anOutputComponents = anOutput.split(",");
		if (anOutputComponents.length != 4) {
//			System.err.println("Output does not have 4 command separated components");
			throw new NotGradableException("Output does not have 4 command separated components");
		}
		
		//might be pointless, goal is to prevent multiple true/false statements in output
//		if (anOutputComponents[3].length()>7) {
//			throw new NotGradableException("Result output, \""+anOutputComponents[3]+"\" exceeds reasonably expected character length.");
//		}	
		
		Integer aDistance = Integer.parseInt(anOutputComponents[0]);
		Integer aDuration = Integer.parseInt(anOutputComponents[1]);
		Integer anExhalationLevel =  Integer.parseInt(anOutputComponents[2]);
		Object[] anArgs = {aDistance, aDuration, anExhalationLevel};
		Boolean aResult = (Boolean) BasicProjectExecution.timedInvoke(aStaticClass, aVerifyingMethod, anArgs, TIME_OUT_MSECS);		

//		Boolean anActualResult = Boolean.parseBoolean(anOutputComponents[3]);
//		new line character is captured in the output. This had caused it to default to false.
		
		Boolean anActualResult = anOutputComponents[3].toLowerCase().matches("true\n*?");
		boolean aReturnValue = aResult.equals(anActualResult);
		if (!aReturnValue) {
			Tracer.info("Expected result:" + aResult + " not equal to actual result:" + anActualResult +" for values: "+anOutput);

		}
		return aReturnValue;
	}
	
	

	@Override
	public abstract TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException;
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
