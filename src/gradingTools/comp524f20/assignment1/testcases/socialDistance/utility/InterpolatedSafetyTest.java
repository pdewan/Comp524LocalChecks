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
public class InterpolatedSafetyTest extends AbstractThreeParameterSafetyTest {
	static Object[] results = {
			true, //1
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //2
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //3
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //4
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //5
			true,
			true,
			true,
			true,
			true,
			true,
			
			false, //6
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //7
			false,
			false,
			false,
			false,
			false,
			
			false, //8
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //9
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //10
			false,
			false,
			false,
			false,
			false,
			false
	};
	
	protected  Object[] getResults() {
		return results;
	};
	@Override
	protected String methodName() {
		return "isInterpolatedSafe";
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		return super.test(project, autoGrade);
	}
	
}