package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.BasicProjectExecution;
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
//@MaxValue(6)
public class IsInterpolatedTwoParameterSafetyTest extends AbstractSocialDistanceUitilityStaticFunctionCallTest {
	public static final int TIME_OUT_SECS = 1; // secs
	
	private static final int SMALL_DISTANCE=6,MEDIUM_DISTANCE=13,LARGE_DISTANCE=27;
	private static final int SMALL_DURATION=15,MEDIUM_DURATION=30,LARGE_DURATION=120;
	private static final int SMALL_EXHALATION=10,MEDIUM_EXHALATION=30,LARGE_EXHALATION=50;
	
	
	static Object[][] inputCombinations = {
			{MEDIUM_DISTANCE,MEDIUM_DURATION}, //1
			{LARGE_DISTANCE,LARGE_DURATION},
			{SMALL_DISTANCE,SMALL_DURATION},
			
			{MEDIUM_DISTANCE+1,MEDIUM_DURATION}, //2
			{LARGE_DISTANCE+1,LARGE_DURATION},
			{SMALL_DISTANCE+1,SMALL_DURATION},
			{MEDIUM_DISTANCE,MEDIUM_DURATION-1},
			{LARGE_DISTANCE,LARGE_DURATION-1},
			{SMALL_DISTANCE,SMALL_DURATION-1},
			
			{LARGE_DISTANCE-1,MEDIUM_DURATION}, //3
			{Integer.MAX_VALUE,LARGE_DURATION},
			{MEDIUM_DISTANCE-1,SMALL_DURATION},
			{MEDIUM_DISTANCE,SMALL_DURATION+1},
			{LARGE_DISTANCE,MEDIUM_DURATION+1},
			{SMALL_DISTANCE,0},
			
			{SMALL_DISTANCE,LARGE_DURATION}, //4
			{LARGE_DISTANCE,SMALL_DURATION},
			{MEDIUM_DISTANCE,SMALL_DURATION},
			{MEDIUM_DISTANCE,LARGE_DURATION},
			{LARGE_DISTANCE,MEDIUM_DURATION},
			{SMALL_DISTANCE,MEDIUM_DURATION},
			
			{MEDIUM_DISTANCE,MEDIUM_DURATION+1}, //5
			{LARGE_DISTANCE,LARGE_DURATION+1},
			{SMALL_DISTANCE,SMALL_DURATION+1},
			{MEDIUM_DISTANCE-1,MEDIUM_DURATION},
			{LARGE_DISTANCE-1,LARGE_DURATION},
			{SMALL_DISTANCE-1,SMALL_DURATION}
			
	};
	
	static Object[] results = {
			true,
			true,
			true,
			
			true,
			true,
			true,
			true,
			true,
			true,

			true,
			true,
			true,
			true,
			true,
			true,
			
			false,
			false,
			false,
			false,
			false,
			false,

			false,
			false,
			false,
			false,
			false,
			false
	};
	
	private static Class[] aParameterTypes={Integer.TYPE, Integer.TYPE};
	
	@Override
	protected  Object[][] getArguments() {
		return inputCombinations;
	}
	
	@Override
	protected Class [] getParameterTypes() {
		return  aParameterTypes;
	}

	@Override
	protected Object[] getResults() {
		return results;
	}

	@Override
	protected String methodName() {
		return "isInterpolatedSafe";
	}

	
}