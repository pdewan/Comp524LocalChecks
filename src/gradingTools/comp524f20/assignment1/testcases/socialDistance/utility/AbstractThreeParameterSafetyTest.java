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
public abstract class AbstractThreeParameterSafetyTest extends AbstractSocialDistanceUitilityStaticFunctionCallTest {
	public static final int TIME_OUT_SECS = 1; // secs
	
	private static final int SMALL_DISTANCE=6,MEDIUM_DISTANCE=13,LARGE_DISTANCE=27;
	private static final int SMALL_DURATION=15,MEDIUM_DURATION=30,LARGE_DURATION=120;
	private static final int SMALL_EXHALATION=10,MEDIUM_EXHALATION=30,LARGE_EXHALATION=50;
	
	
	static Object[][] inputCombinations = {
			{MEDIUM_DISTANCE,MEDIUM_DURATION,MEDIUM_EXHALATION}, //1
			{SMALL_DISTANCE,MEDIUM_DURATION,SMALL_EXHALATION},
			{LARGE_DISTANCE,MEDIUM_DURATION,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,SMALL_DURATION,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,LARGE_DURATION,SMALL_EXHALATION},
			{LARGE_DISTANCE,LARGE_DURATION,MEDIUM_EXHALATION},
			{SMALL_DISTANCE,SMALL_DURATION,MEDIUM_EXHALATION}, //all after here false for given
			
			{MEDIUM_DISTANCE+1,MEDIUM_DURATION,MEDIUM_EXHALATION}, //2
			{SMALL_DISTANCE+1,MEDIUM_DURATION,SMALL_EXHALATION},
			{LARGE_DISTANCE,MEDIUM_DURATION-1,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,SMALL_DURATION-1,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,LARGE_DURATION,SMALL_EXHALATION-1},
			{LARGE_DISTANCE,LARGE_DURATION,MEDIUM_EXHALATION-1},
			{SMALL_DISTANCE+1,SMALL_DURATION,MEDIUM_EXHALATION}, //single change right above
			
			{MEDIUM_DISTANCE+1,MEDIUM_DURATION-1,MEDIUM_EXHALATION-1}, //3
			{SMALL_DISTANCE+1,MEDIUM_DURATION-1,SMALL_EXHALATION-1},
			{LARGE_DISTANCE+1,MEDIUM_DURATION-1,LARGE_EXHALATION-1},
			{MEDIUM_DISTANCE+1,SMALL_DURATION-1,LARGE_EXHALATION-1},
			{MEDIUM_DISTANCE+1,LARGE_DURATION-1,SMALL_EXHALATION-1},
			{LARGE_DISTANCE+1,LARGE_DURATION-1,MEDIUM_EXHALATION-1},
			{SMALL_DISTANCE+1,SMALL_DURATION-1,MEDIUM_EXHALATION-1}, //multi change right above
			
			{LARGE_DISTANCE-1,MEDIUM_DURATION,MEDIUM_EXHALATION}, //4
			{MEDIUM_DISTANCE-1,MEDIUM_DURATION,SMALL_EXHALATION},
			{LARGE_DISTANCE,SMALL_DURATION+1,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,0,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,LARGE_DURATION,0},
			{LARGE_DISTANCE,LARGE_DURATION,SMALL_EXHALATION+1},
			{MEDIUM_DISTANCE-1,SMALL_DURATION,MEDIUM_EXHALATION}, //single extreme change
			
			{LARGE_DISTANCE-1,SMALL_DURATION+1,SMALL_EXHALATION+1}, //5
			{MEDIUM_DISTANCE-1,SMALL_DURATION+1,0},
			{Integer.MAX_VALUE,SMALL_DURATION+1,MEDIUM_EXHALATION+1},
			{LARGE_DISTANCE-1,0,MEDIUM_EXHALATION+1},
			{LARGE_DISTANCE-1,MEDIUM_DURATION+1,0},
			{Integer.MAX_VALUE,MEDIUM_DURATION+1,SMALL_EXHALATION+1},
			{MEDIUM_DISTANCE-1,0,SMALL_EXHALATION+1}, //multi extreme change
			
			//6-8 are all possible combinations not on the chart
			{SMALL_DISTANCE,SMALL_DURATION,SMALL_EXHALATION}, //6
			{SMALL_DISTANCE,SMALL_DURATION,LARGE_EXHALATION},
			{SMALL_DISTANCE,MEDIUM_DURATION,MEDIUM_EXHALATION},
			{SMALL_DISTANCE,MEDIUM_DURATION,LARGE_EXHALATION},
			{SMALL_DISTANCE,LARGE_DURATION,SMALL_EXHALATION},
			{SMALL_DISTANCE,LARGE_DURATION,MEDIUM_EXHALATION},
			{SMALL_DISTANCE,LARGE_DURATION,LARGE_EXHALATION}, //false values
			
			{MEDIUM_DISTANCE,SMALL_DURATION,SMALL_EXHALATION}, //7
			{MEDIUM_DISTANCE,SMALL_DURATION,MEDIUM_EXHALATION},
			{MEDIUM_DISTANCE,MEDIUM_DURATION,SMALL_EXHALATION},
			{MEDIUM_DISTANCE,MEDIUM_DURATION,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,LARGE_DURATION,MEDIUM_EXHALATION},
			{MEDIUM_DISTANCE,LARGE_DURATION,LARGE_EXHALATION}, //more false
			
			{LARGE_DISTANCE,SMALL_DURATION,SMALL_EXHALATION}, //8
			{LARGE_DISTANCE,SMALL_DURATION,MEDIUM_EXHALATION},
			{LARGE_DISTANCE,SMALL_DURATION,LARGE_EXHALATION},
			{LARGE_DISTANCE,MEDIUM_DURATION,SMALL_EXHALATION},
			{LARGE_DISTANCE,MEDIUM_DURATION,MEDIUM_EXHALATION},
			{LARGE_DISTANCE,LARGE_DURATION,SMALL_EXHALATION},
			{LARGE_DISTANCE,LARGE_DURATION,LARGE_EXHALATION}, //more false
			
			{LARGE_DISTANCE,Integer.MAX_VALUE,LARGE_EXHALATION}, //9
			{LARGE_DISTANCE,LARGE_DURATION,Integer.MAX_VALUE},
			{SMALL_DISTANCE-1,SMALL_DURATION,MEDIUM_EXHALATION},
			{MEDIUM_DISTANCE,LARGE_DURATION+1,SMALL_EXHALATION},
			{LARGE_DISTANCE,LARGE_DURATION,MEDIUM_EXHALATION+1},
			{0,SMALL_DURATION,SMALL_EXHALATION},
			{SMALL_DISTANCE,SMALL_DURATION,Integer.MAX_VALUE}, //all false single change
			
			{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}, //10
			{500,500,500},
			{0,0,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,0,LARGE_EXHALATION+1},
			{0,0,0},
			{(LARGE_DISTANCE+MEDIUM_DISTANCE)/2,(MEDIUM_DURATION+SMALL_DURATION)/2,LARGE_EXHALATION},
			{LARGE_DISTANCE-1,LARGE_DURATION+1,LARGE_EXHALATION+1} //all false multiple change
			
	};
	
	@Override
	protected  Object[][] getArguments() {
		return inputCombinations;
	}

	private static Class[] aParameterTypes={Integer.TYPE, Integer.TYPE, Integer.TYPE};
	
	@Override
	protected Class [] getParameterTypes() {
		return  aParameterTypes;
	}

	
}