package gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeOneTwoParam;

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
public class InterpolatedSafe_OutputGeneration_OneTwoParam extends AnAbstractPrologRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public InterpolatedSafe_OutputGeneration_OneTwoParam() {
	}
	
	private final String [] twoParamTrueInputs= {
			"interpolatedSafe(13,30). ; .",
			"interpolatedSafe(27,120). ; .",
			"interpolatedSafe(6,15). ; .",
			"interpolatedSafe(14,30). ; .",
			"interpolatedSafe(28,120). ; .",
			"interpolatedSafe(7,15). ; .",
			"interpolatedSafe(13,29). ; .",

			"interpolatedSafe(6,14). ; .",
			"interpolatedSafe(26,30). ; .",
			"interpolatedSafe(2147483647,120). ; .",
			"interpolatedSafe(12,15). ; .",
			"interpolatedSafe(13,16). ; .",
			"interpolatedSafe(27,31). ; .",
			"interpolatedSafe(6,0). ; .", //13
	};
	private final String [] twoParamFalseInputs= {
			"write('InterpolatedSafeTwoParam false test below\n---\n').",
			
			"interpolatedSafe(6,120).",
			"interpolatedSafe(27,15).",
			"interpolatedSafe(13,15).",
			"interpolatedSafe(13,120).",
			"interpolatedSafe(27,30).",
			"interpolatedSafe(6,30).",

			"interpolatedSafe(13,31).",
			"interpolatedSafe(27,121).",
			"interpolatedSafe(6,16).",
			"interpolatedSafe(12,30).",
			"interpolatedSafe(26,120).",
			"interpolatedSafe(5,15).", //26	
	};
	private final String [] oneParamTrueInputs= {
			"write('InterpolatedSafeOneParam true test below\n---\n').",
			
			"interpolatedSafe(13). ; .",
			"interpolatedSafe(14). ; .",
			"interpolatedSafe(26). ; .", //30	
	};
	private final String[] oneParamFalseInputs= {
			"write('InterpolatedSafeOneParam false test below\n---\n').",
			
			"interpolatedSafe(6).",
			"interpolatedSafe(27).",
			"interpolatedSafe(12).",

			"interpolatedSafe(0).",
			"interpolatedSafe(28).",
			"interpolatedSafe(2147483647).", //37
			
			"halt."
	};
	
	protected final String[] getTwoParamTrueInputs() {
		return twoParamTrueInputs;
	}
	protected final String[] getTwoParamFalseInputs() {
		return twoParamFalseInputs;
	}
	protected final String[] getOneParamTrueInputs() {
		return oneParamTrueInputs;
	}
	protected final String[] getOneParamFalseInputs() {
		return oneParamFalseInputs;
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
			
			String [] inputs=combineArrays(getTwoParamTrueInputs(),getTwoParamFalseInputs(),getOneParamTrueInputs(),getOneParamFalseInputs());
			
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
