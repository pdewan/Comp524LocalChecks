package gradingTools.comp524f20.assignment2.ruleTests.listGivenSafeTests;

import grader.basics.execution.NotRunnableException;
import grader.basics.execution.RunningProject;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment2.AnAbstractPrologRunningProject;
import gradingTools.comp524f20.assignment2.requiredFiles.SocialDistancePlProvided;
import gradingTools.comp524f20.assignment2.requiredFiles.SocialDiststancePlNoExternalFunctionsTest;
import util.annotations.MaxValue;
@MaxValue(2)
public class ListGivenSafe_OutputGeneration extends AnAbstractPrologRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public ListGivenSafe_OutputGeneration() {
	}
	
	private String [] recursionTestInput= {
			"write('checking for recursion below:\n---\n').",
			"trace(listGivenSafe, call).",
			"write('tracing was turned on\n').",
			"listGivenSafe([13,30,30]). ; .",
			"halt."
	};
	
	private String [] recursionTestRegex={
			"^---.*",
			"^---.*",
		".*Call.*listGivenSafe.*",
		".*Call.*listGivenSafe.*",
		".*Call.*listGivenSafe.*"
	};
	
	private String [] valuesTestInputs= {
			
			"listGivenSafe([13,30,30]). ; .",
			"listGivenSafe([6,30,10]). ; .",
			"listGivenSafe([27,30,50]). ; .",
			"listGivenSafe([13,15,50]). ; .",
			"listGivenSafe([13,120,10]). ; .",
			"listGivenSafe([27,120,30]). ; .",
			"listGivenSafe([6,15,30]). ; .",
			
			"listGivenSafe([14,30,30]).",
			"listGivenSafe([7,30,10]).",
			"listGivenSafe([27,29,50]).",
			"listGivenSafe([13,14,50]).",
			"listGivenSafe([13,120,9]).",
			"listGivenSafe([27,120,29]).",
			"listGivenSafe([7,15,30]).",
			"listGivenSafe([14,29,29]).",
			
			"listGivenSafe([13,Duration,Exhalation]). ;",";","; .",
			"listGivenSafe([13,Duration,Exhalation]). ;",";","; .",
			"listGivenSafe([13,Duration,Exhalation]). ;",";","; .",
			"listGivenSafe([13,Duration,Exhalation]). ;",";","; .",
			
			"listGivenSafe([Distance,30,Exhalation]). ;",";","; .",
			"listGivenSafe([Distance,30,Exhalation]). ;",";","; .",
			"listGivenSafe([Distance,30,Exhalation]). ;",";","; .",
			
			"listGivenSafe([Distance,Duration,50]). ;","; .",
			"listGivenSafe([Distance,Duration,50]). ;","; ."
	};
	private String [] safeTupleTestInputs= {
			"write('safeTupleTest output below\n---\n').",
			
			"listGivenSafe(SafeTuple). ;",";",";",";",";",";","; .",
			"listGivenSafe(SafeTuple). ;",";",";",";",";",";","; .",
			"listGivenSafe(SafeTuple). ;",";",";",";",";",";","; .",
			"listGivenSafe(SafeTuple). ;",";",";",";",";",";","; .",
			"listGivenSafe(SafeTuple). ;",";",";",";",";",";","; .",
			"listGivenSafe(SafeTuple). ;",";",";",";",";",";","; .",
			"listGivenSafe(SafeTuple). ;",";",";",";",";",";","; .",
			
	
	};
	
	protected String [] getValueTestInputs() {
		return valuesTestInputs;
	}
	protected String [] getSafeTupleTestInputs() {
		return safeTupleTestInputs;
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
			
			String [] inputs=combineArrays(getValueTestInputs(),getSafeTupleTestInputs(),recursionTestInput);
			
			SocialDiststancePlNoExternalFunctionsTest externalFunctions = (SocialDiststancePlNoExternalFunctionsTest) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDiststancePlNoExternalFunctionsTest.class);			
			if(!externalFunctions.hasPassed()) {
				System.err.println("WARNING EXTERNAL FUNCTIONS FOUND IN FILE SocialDistance.pl");
				//return fail("External functions present in code cannot proceed");
			}
			
			RunningProject aRunningProject = createRunningProject(project,aSocialDistanceFileProvided.getFileName(),inputs);
			if (aRunningProject == null) {
				return fail ("Could not create project. See console messages.");
			}

			String anOutput = aRunningProject.await().replaceAll("\n\n", "\n").replaceAll("\n\n", "\n");
//			LinesMatcher aLinesMatcher = aRunningProject.getLinesMatcher();
			
			String errOutput=aRunningProject.getOutputAndErrors().replaceAll("\n\n", "\n").replaceAll("\n\n", "\n");
			boolean retVal=regexOutputChecksFailurePrint(errOutput.split("\n"), recursionTestRegex);
			
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
