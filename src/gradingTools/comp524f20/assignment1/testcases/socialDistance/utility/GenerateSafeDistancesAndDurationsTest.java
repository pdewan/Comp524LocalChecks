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
@MaxValue(15)
public class GenerateSafeDistancesAndDurationsTest extends PassFailJUnitTestCase {
	public static final int TIME_OUT_MSECS = 100; // secs
	
	protected static Object[][] arguments= {
			{9}, //<small 
			{0},
			{5},
			{10},
			
			{11}, //small to medium
			{29},
			{17},
			{30},
			
			{31}, //medium to large
			{49},
			{41},
			{50},
			
			{51}, //>large
			{70},
			{101},
			{Integer.MAX_VALUE}
			
	};
	protected Object[][] getArguments(){
		return arguments;
	}
	
	protected static int[][][] results= {
			{{6,30},{13,120}},
			{{6,30},{13,120}},
			{{6,30},{13,120}},
			{{6,30},{13,120}},
			
			{{13,30},{27,120},{6,15}},
			{{13,30},{27,120},{6,15}},
			{{13,30},{27,120},{6,15}},
			{{13,30},{27,120},{6,15}},
			
			{{27,30},{13,15}},
			{{27,30},{13,15}},
			{{27,30},{13,15}},
			{{27,30},{13,15}},
			
			{},
			{},
			{},
			{}
	};
	
	protected int[][][] getResults() {
		return results;
	}
	
	
	protected static Class[] parameterTypes= {Integer.TYPE};
	protected Class[] getParameterTypes() {
		return parameterTypes;
	}
	

	public GenerateSafeDistancesAndDurationsTest() {
	}

	protected static String methodName="generateSafeDistancesAndDurations";
	protected String methodName() {
		return methodName;
	}
	
	protected boolean verifyOutput(List<Integer[]> retVal, int [][] expected) {
		boolean [] anyOrderCheck = new boolean [expected.length];
		Arrays.fill(anyOrderCheck, false);
		for(Integer[] retValArray:retVal) {
			if(retValArray.length!=2) {
				System.out.println("An Integer Array was found not containing 2 values");
				return false;
			}
			boolean success=false;
			for(int i=0;i<expected.length;i++) {
				if(anyOrderCheck[i]) {
					continue;
				}
				if(retValArray[0]==expected[i][0]&&retValArray[1]==expected[i][1]) {
					anyOrderCheck[i]=true;
					success=true;
					break;
				}
			}
			if(!success) {
				System.out.println("Inncorrect Values Given");
				return false;
			}	
		}
		return true;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
			SocialDistanceUtilityProvided aSocialDistanceUilityProvided = (SocialDistanceUtilityProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceUtilityProvided.class);
			Class aUilityClass = aSocialDistanceUilityProvided.getRequiredClass();
			
//			SocialDistanceClassRegistry aClassRegistry = aClassRegistryProvided.getTimingOutClassRegistryProxy();  
		    if (aUilityClass == null) {
		    	return fail ("No utility class");
		    }
		    Class[] aParameterTypes = getParameterTypes();
		    Method aMethod = aUilityClass.getMethod(methodName(), aParameterTypes);
		    Object[][] anArguments = getArguments();
		    int[][][] aResults = getResults();
		    int aNumSuccesses = 0;
		    
		    for (int anIndex = 0; anIndex < anArguments.length; anIndex++ ) {
		    	Object[] anInputCombination = anArguments[anIndex];
		    	int [][] anExpectedResult = aResults[anIndex];
		    	List<Integer[]> aRetVal =  (List<Integer[]>) BasicProjectExecution.timedInvoke(aUilityClass, aMethod, anInputCombination, TIME_OUT_MSECS);
			    if(aRetVal.size()!=anExpectedResult.length) {
			    	System.out.println("Expected size of returned list with args "+Arrays.toString(anInputCombination)+" is: "+anExpectedResult.length+" number given was "+aRetVal.size());
			    	continue;
			    }
		    	if (!verifyOutput(aRetVal,anExpectedResult)) {
		    		System.out.println("Expected retVal with args " + Arrays.toString(anInputCombination) + " did not return " + Arrays.toString(anExpectedResult));
			    } else {
			    	aNumSuccesses++;
			    }
		    }
		    
		    
		    
		    double aPercentage = ((double) aNumSuccesses)/aResults.length;
		    return aPercentage == 1?pass():partialPass(aPercentage, aNumSuccesses + " tests passed out of " +   aResults.length);  

		} catch ( Throwable e) {
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
