package gradingTools.comp524f20.assignment2.ruleTests.generateSafeDistancesAndDurations;

import grader.basics.execution.NotRunnableException;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment2.AnAbstractPrologRunningProject;
import util.annotations.MaxValue;
@MaxValue(8)
public class GenerateSafeDistancesAndDurations_TrueValueTest extends AnAbstractPrologRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public GenerateSafeDistancesAndDurations_TrueValueTest() {
	}
	
	private static String[] regexChecks={
			".*Distance = 6.*",
			".*Duration = 30.*",
			".*Distance = 13.*",
			".*Duration = 120.*",
			
			".*Distance = 6.*",
			".*Duration = 30.*",
			".*Distance = 13.*",
			".*Duration = 120.*",
			
			
			
			".*Distance = 6.*",
			".*Duration = 30.*",
			".*Distance = 13.*",
			".*Duration = 120.*",
			
			".*Distance = 13.*",
			".*Duration = 30.*",
			".*Distance = 27.*", 
			".*Duration = 120.*",
			".*Distance = 6.*",
			".*Duration = 15.*",
			
			".*Distance = 13.*",
			".*Duration = 30.*",
			".*Distance = 27.*", 
			".*Duration = 120.*",
			".*Distance = 6.*",
			".*Duration = 15.*",
			
			".*Distance = 13.*",
			".*Duration = 30.*",
			".*Distance = 27.*", 
			".*Duration = 120.*",
			".*Distance = 6.*",
			".*Duration = 15.*",
			
			
			
			".*Distance = 27.*",
			".*Duration = 30.*",
			".*Distance = 13.*",
			".*Duration = 15.*",
			
			".*Distance = 27.*",
			".*Duration = 30.*",
			".*Distance = 13.*",
			".*Duration = 15.*",
			
			".*Distance = 27.*",
			".*Duration = 30.*",
			".*Distance = 13.*",
			".*Duration = 15.*",
			"^---.*",
	};

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {

			GenerateSafeDistancesAndDurations_OutputGeneration outputGeneration = (GenerateSafeDistancesAndDurations_OutputGeneration) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(GenerateSafeDistancesAndDurations_OutputGeneration.class);			
			String anOutput=outputGeneration.getOutput();

			if (anOutput == null) {
				return fail ("Could not generate output. See console messages.");
			}

//			LinesMatcher aLinesMatcher = aRunningProject.getLinesMatcher();
			
			boolean aRetval = regexOutputChecksFailurePrint(anOutput.split("\n"),regexChecks,outputGeneration.getTrueValueInputs());

			if (!aRetval) 
				return fail("View console for more detail");
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
