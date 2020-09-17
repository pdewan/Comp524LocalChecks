package gradingTools.comp524f20.assignment1.testcases.socialDistance.mains;

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
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceBasicMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceDerivingMainProvided;
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
@MaxValue(10)
public class DerivingMainTest extends AnAbstractRegexLineChecker {
	public static final int TIME_OUT_SECS = 1; // secs
	protected SubstringSequenceChecker checker = new ADerivingMainChecker();	
	
	private static final String SMALL_DISTANCE="6",MEDIUM_DISTANCE="13",LARGE_DISTANCE="27";
	private static final String SMALL_DURATION="15",MEDIUM_DURATION="30",LARGE_DURATION="120";
	private static final String SMALL_EXHALATION="10",MEDIUM_EXHALATION="30",LARGE_EXHALATION="50";

	public DerivingMainTest() {
	}

	static String[] inputs = {
			
			"404","404","404",
			
			MEDIUM_DISTANCE,MEDIUM_DURATION,MEDIUM_EXHALATION, //1
			SMALL_DISTANCE,SMALL_DURATION,SMALL_EXHALATION, 
			MEDIUM_DISTANCE,"29","29", //all after here false for given
			LARGE_DISTANCE,LARGE_DURATION,SMALL_EXHALATION,
			
			SMALL_DISTANCE,"121",SMALL_EXHALATION,
			"5",SMALL_DURATION,SMALL_EXHALATION,//false values
			LARGE_DISTANCE,LARGE_DURATION,LARGE_EXHALATION,
			
			"-1"
	};

	static String [] regexChecks= {
			"^[Pp]lease enter.*",
			"^[Dd]istance.*",
			"^[Dd]uration.*",
			"^[Ee]xhalation [Ll]evel.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=404.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=404.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=404.*",
			
			"^[Nn]ot [Ss]afe.*",
			
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=13.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=30.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=30.*",
			
			"^[Ss]afe.*", //1
			"^[Ss]afe.*",
			"^[Ss]afe.*",
			"^[Ss]afe.*",
			
			"^[Nn]ot [Ss]afe.*", //2
			"^[Nn]ot [Ss]afe.*",
			"^[Nn]ot [Ss]afe.*",

			"^[Qq]uitting.*"
	};
	
	protected RunningProject createRunningProject (Project aProject) {
		SocialDistanceDerivingMainProvided aMainProvided = (SocialDistanceDerivingMainProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceDerivingMainProvided.class);
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
//			boolean aRetval = checker.check(aLinesMatcher, LinesMatchKind.ONE_TIME_LINE, Pattern.DOTALL);
			boolean aRetval = regexOutputChecks(anOutput.split("\n"),regexChecks,inputs,"DerivingMainTest");

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
