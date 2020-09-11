package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.configuration.PatternSubtreeConfigurationWrapper;

import grader.basics.config.BasicExecutionSpecification;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.NotRunnableException;
import grader.basics.execution.ResultWithOutput;
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
import util.trace.Tracer;
@MaxValue(5)
public class PrintSafeDistancesAndDurationsTest extends PassFailJUnitTestCase {
	public static final int TIME_OUT_MSECS = 300; // secs
	
	protected final String methodName = "printSafeDistancesAndDurations";

	protected static Class[] parameterTypes= {Integer.TYPE};
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
	
	protected static String[][] results= {
			{"{6,30}","{13,120}"},
			{"{6,30}","{13,120}"},
			{"{6,30}","{13,120}"},
			{"{6,30}","{13,120}"},
			
			{"{13,30}","{27,120}","{6,15}"},
			{"{13,30}","{27,120}","{6,15}"},
			{"{13,30}","{27,120}","{6,15}"},
			{"{13,30}","{27,120}","{6,15}"},
			
			
			{"{27,30}","{13,15}"},
			{"{27,30}","{13,15}"},
			{"{27,30}","{13,15}"},
			{"{27,30}","{13,15}"},
			
			{},
			{},
			{},
			{}
	};
	protected String [][] getCorrectSubstrings(){
		return results;
	}
	
	
	protected Object[][] getArguments(){
		return arguments;
	}

	public PrintSafeDistancesAndDurationsTest() {
	}
	
	protected Class[] getParameterTypes() {
		return parameterTypes;
	}
	
	protected  String methodName() {
		return methodName;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
			SocialDistanceUtilityProvided aSocialDistanceUilityProvided = (SocialDistanceUtilityProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceUtilityProvided.class);
			Class aUtilityClass = aSocialDistanceUilityProvided.getRequiredClass();
			
//			SocialDistanceClassRegistry aClassRegistry = aClassRegistryProvided.getTimingOutClassRegistryProxy();  
		    if (aUtilityClass == null) {
		    	return fail ("No utility class");
		    }
		    Class[] aParameterTypes = getParameterTypes();
		    Method aMethod = aUtilityClass.getMethod(methodName(), aParameterTypes);
		    Object[][] anArguments = getArguments();
		    
		    int aNumSuccesses=0;
		    String [][] correctDistancesAndDurrations=getCorrectSubstrings();
		    OUTER:
		    for(int i =0; i<anArguments.length;i++) {
		    	ResultWithOutput aResultWithOutput = BasicProjectExecution.timedInteractiveInvoke(aUtilityClass, aMethod, anArguments[i], TIME_OUT_MSECS);
		    	String anOutput = aResultWithOutput.getOutput();
		    	if (anOutput == null || anOutput.isEmpty() ) {
			    	System.out.println("No output for arguments "+Arrays.toString(anArguments[i]));
			    	continue;
		    	}
		    
		    	
		    	if(!anOutput.replaceAll("\\{\\d+,\\d+\\}", "p").matches("\\d+,\\[[p,]*\\]\n*")){
		    	//if(!anOutput.matches("\\d+,\\[(?:\\{\\d+,\\d+\\}*\\]\n*")){
	
		    		System.out.println("Output for arguments "+Arrays.toString(anArguments[i])+" did not match regex: \"\\d+,[(?:\\{\\d+,\\d+\\})*]\"");
		    		continue;
		    	}
		    	
		    	int outputPairs=0;
		    	for(char search:anOutput.toCharArray())
		    		outputPairs=search=='{'?outputPairs+1:outputPairs;
		    	
		    	if(outputPairs!=correctDistancesAndDurrations[i].length) {
		    		System.out.println("Number of distance durration pairs in output for arguments "+Arrays.toString(anArguments[i])+" did not match expected number: "+correctDistancesAndDurrations[i].length);
		    		continue;
		    	}
		    	
		    	if(correctDistancesAndDurrations[i].length!=0) {
		    		for(int j=0;j<correctDistancesAndDurrations[i].length;j++) {
		    			if(!anOutput.contains(correctDistancesAndDurrations[i][j])) {
		    				System.out.println("Pattern "+correctDistancesAndDurrations[i][j]+" missing from output generated by "+Arrays.toString(anArguments[i]));
		    				continue OUTER;
		    			}
		    		}
		    	}
		    	aNumSuccesses++;
		    }
		    
		   
		    double aPercentage = ((double) aNumSuccesses)/anArguments.length;
		    return aPercentage == 1?pass():partialPass(aPercentage, aNumSuccesses + " tests passed out of " + anArguments.length);  

		} catch ( Throwable e) {
			System.err.println(e);
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
