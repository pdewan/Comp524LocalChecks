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
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceBasicMainProvided;
import gradingTools.shared.testcases.SubstringSequenceChecker;
import gradingTools.shared.testcases.utils.LinesMatcher;
import gradingTools.utils.RunningProjectUtils;
import util.annotations.MaxValue;
@MaxValue(25)
public class BasicMainTest extends AnAbstractRegexLineChecker {
	public static final int TIME_OUT_SECS = 1; // secs
	protected SubstringSequenceChecker checker = new ABasicMainChecker();	
	
	private static final String SMALL_DISTANCE="6",MEDIUM_DISTANCE="13",LARGE_DISTANCE="27";
	private static final String SMALL_DURATION="15",MEDIUM_DURATION="30",LARGE_DURATION="120";
	private static final String SMALL_EXHALATION="10",MEDIUM_EXHALATION="30",LARGE_EXHALATION="50";

	public BasicMainTest() {
	}

	static String[] inputs = {
			
			"10","10","10",
			
			MEDIUM_DISTANCE,MEDIUM_DURATION,MEDIUM_EXHALATION, //1
			SMALL_DISTANCE,MEDIUM_DURATION,SMALL_EXHALATION,
			LARGE_DISTANCE,MEDIUM_DURATION,LARGE_EXHALATION, //all after here false for given
			
			SMALL_DISTANCE,SMALL_DURATION,SMALL_EXHALATION, //3
			SMALL_DISTANCE,"16",SMALL_EXHALATION,
			"5","14","9",
			LARGE_DISTANCE,LARGE_DURATION,LARGE_EXHALATION,//false values
			
			"-1"
	};

	private final String [] regexChecks= {
			"^[Pp]lease enter.*",
			"^[Dd]istance.*",
			"^[Dd]uration.*",
			"^[Ee]xhalation [Ll]evel.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=10.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=10.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=10.*",
			
			"^[Nn]ot [Ss]afe.*",
			
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=13.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=30.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=30.*",
			
			"^[Ss]afe.*", //1
			"^[Ss]afe.*",
			"^[Ss]afe.*",
			
			"^[Nn]ot [Ss]afe.*", //2
			"^[Nn]ot [Ss]afe.*",
			"^[Nn]ot [Ss]afe.*",
			"^[Nn]ot [Ss]afe.*",

			"^[Qq]uitting.*"
	};
	
	
	protected RunningProject createRunningProject (Project aProject) {
		SocialDistanceBasicMainProvided aMainProvided = (SocialDistanceBasicMainProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceBasicMainProvided.class);
		Class aMainClass = aMainProvided.getRequiredClass();
		if (aMainClass == null) {
			System.err.println("Cannot run test, no basic main class:");
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
			
//			String output=aRunningProject.getOutput();
			
//			boolean aRetval = checker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_LINE, Pattern.DOTALL);
			boolean aRetval = regexOutputChecks(anOutput.split("\n"),regexChecks,inputs,"BasicMainTest");

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
