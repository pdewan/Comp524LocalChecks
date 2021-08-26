package gradingTools.comp524f20.assignment1.testcases.socialDistance.mains;

import java.util.Arrays;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.NotRunnableException;
import grader.basics.execution.RunningProject;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceInferringMainProvided;
import gradingTools.shared.testcases.SubstringSequenceChecker;
import gradingTools.shared.testcases.utils.LinesMatcher;
import gradingTools.utils.RunningProjectUtils;
import util.annotations.MaxValue;
@MaxValue(10)
public class InferringMainTest extends AnAbstractRegexLineChecker {
	public static final int TIME_OUT_SECS = 1; // secs
	protected SubstringSequenceChecker checker = new AInferringMainChecker();	
	
	private static final String SMALL_DISTANCE="6",MEDIUM_DISTANCE="13",LARGE_DISTANCE="27";
	private static final String SMALL_DURATION="15",MEDIUM_DURATION="30",LARGE_DURATION="120";
	private static final String SMALL_EXHALATION="10",MEDIUM_EXHALATION="30",LARGE_EXHALATION="50";

	public InferringMainTest() {
	}

	static String[] inputs = {
			
			"404","404","404",
			
			LARGE_DISTANCE,SMALL_DURATION,SMALL_EXHALATION, //1
			
			"-1"
	};
	
	static String[] regexChecks= {
			"^[Pp]lease enter.*",
			"^[Dd]istance.*",
			"^[Dd]uration.*",
			"^[Ee]xhalation [Ll]evel.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=404.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=404.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=404.*",
			
			"^[Nn]ot [Ss]afe.*",
			
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=27.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=15.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=10.*",
			
			"^[Ss]afe.*", //1
			
			"^[Qq]uitting.*"	
	};

	protected RunningProject createRunningProject (Project aProject) {
		SocialDistanceInferringMainProvided aMainProvided = (SocialDistanceInferringMainProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceInferringMainProvided.class);
		Class aMainClass = aMainProvided.getRequiredClass();
		if (aMainClass == null) {
			System.err.println("Cannot run test, no inferring main class:");
			return null;
		}
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setEntryPoint(aMainClass.getName());
		RunningProject aRunningProject = RunningProjectUtils.runProject(aProject, TIME_OUT_SECS, inputs);
		return aRunningProject;
	}
	

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
//			setEntryPoint(project);
//    		GreetingMainProvided aHelloWorkdClassProvided = (GreetingMainProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(GreetingMainProvided.class);
//    		Class aHelloClass = aHelloWorkdClassProvided.getGreetingMain();
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setEntryPoint(aHelloClass.getName());
//			RunningProject aRunningProject = RunningProjectUtils.runProject(project, TIME_OUT_SECS);
			RunningProject aRunningProject = createRunningProject(project);
			if (aRunningProject == null) {
				return fail ("Could not create project. See console messages.");
			}
			//test
			String anOutput = aRunningProject.await();
			LinesMatcher aLinesMatcher = aRunningProject.getLinesMatcher();
//			boolean aRetval = checker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_LINE, Pattern.DOTALL);
			boolean aRetval = regexOutputChecks(anOutput.split("\n"),regexChecks,inputs,"InferringMainTest");

			String anExpectedLines = Arrays.toString(checker.getSubstrings());

			if (!aRetval) {
//				return fail("Output  did not match:" + anExpectedLines);
				return fail("View console for more detail");
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
