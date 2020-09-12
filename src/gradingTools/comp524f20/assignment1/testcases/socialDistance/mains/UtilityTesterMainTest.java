package gradingTools.comp524f20.assignment1.testcases.socialDistance.mains;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

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
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceBasicMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceInferringMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityTesterMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.CompareSafetyComputationsTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintGeneratedCombinationDerivedSafetyTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintGeneratedCombinationInferredSafetyTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintSafeDistancesAndDurationsTest;
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
@MaxValue(5)
public class UtilityTesterMainTest extends PassFailJUnitTestCase {
	public static final int TIME_OUT_MSECS = 300; // secs
	
	public UtilityTesterMainTest() {
	}
	
	protected Class[] argumentTypes= {String[].class};
	protected Class[] argumentTypes() {
		return argumentTypes;
	}
	
	protected String[] strArgs= {};
	protected Object[] arguments= {strArgs};
	protected Object[] getArguments() {
		return arguments;
	}
	
	protected String methodName= "main";
	protected String methodName() {
		return methodName;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
			SocialDistanceUtilityTesterMainProvided aSocialDistanceUilityTesterMainProvided = (SocialDistanceUtilityTesterMainProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceUtilityTesterMainProvided.class);
			Class aUtilityTesterMainClass = aSocialDistanceUilityTesterMainProvided.getSocialDistanceMain();
			
		    if (aUtilityTesterMainClass == null) {
		    	return fail ("No utility class");
		    }
		    
			PrintGeneratedCombinationDerivedSafetyTest printedDerviedWorking = (PrintGeneratedCombinationDerivedSafetyTest) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(PrintGeneratedCombinationDerivedSafetyTest.class);
			
			PrintGeneratedCombinationInferredSafetyTest printedInferredWorking = (PrintGeneratedCombinationInferredSafetyTest) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(PrintGeneratedCombinationInferredSafetyTest.class);
			
			CompareSafetyComputationsTest compareWorking = (CompareSafetyComputationsTest) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(CompareSafetyComputationsTest.class);
			
			PrintSafeDistancesAndDurationsTest printedSafeDistancesWorking = (PrintSafeDistancesAndDurationsTest) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(PrintSafeDistancesAndDurationsTest.class);
			
		    if (!printedDerviedWorking.isPassing()) {
		    	return fail ("PrintGeneratedCombinationDerivedSafetyTest must first pass before this test can be ran");
			}
		    if (!printedInferredWorking.isPassing()) {
		    	return fail ("PrintGeneratedCombinationInferredSafetyTest must first pass before this test can be ran");
		    }
		    if (!compareWorking.isPassing()) {
		    	return fail ("CompareSafetyComputationsTest must first pass in order for this test to be ran");
		    }
		    if (!printedSafeDistancesWorking.isPassing()) {
		    	return fail ("PrintSafeDistancesAndDurationsTest must first pass in order for this test to be ran");
		    }
		    
		    System.out.println("---------------------");
		    Class[] aParameterTypes = argumentTypes();
		    Method aMethod = aUtilityTesterMainClass.getMethod(methodName(), aParameterTypes);
		    Object[] anArguments = getArguments();
		    ResultWithOutput aResultWithOutput = BasicProjectExecution.timedInteractiveInvoke(aUtilityTesterMainClass, aMethod, anArguments, TIME_OUT_MSECS);
		    
		    String anOutput = aResultWithOutput.getOutput();
		    if (anOutput == null || anOutput.isEmpty() ) {
		    	return fail("No Output");
		    }
		    
		    boolean passing=true;
		    String [] parsedOutput=anOutput.split("\n");
		    
		    if(!parsedOutput[0].matches("[Dd]istance,[Dd]uration,[Ee]xhalation,[Ii]sSafe.*")) {
		    	System.out.println("Missing call to PrintGeneratedCombinationDerivedSafety");
		    	passing=false;
		    }
		    if(!parsedOutput[19].matches("[Dd]istance,[Dd]uration,[Ee]xhalation,[Ii]sSafe.*")) {
		    	System.out.println("Missing call to PrintGeneratedCombinationInferredSafety");
		    	passing=false;
		    }
		    if(!parsedOutput[38].matches(".*[Dd]istance,[Dd]uration,[Ee]xhalation,[Dd]erived,[Ii]nferred.*")) {
		    	System.out.println("Missing call to CompareSafetyComputations");
		    	passing=false;
		    }
		    if(!parsedOutput[parsedOutput.length-3].matches(".*30,\\[\\{13,30\\},\\{27,120\\},\\{6,15\\}\\].*")) {
		    	System.out.println("Missing call to PrintSafeDistancesAndDurations with args Medium exhalation");
		    	passing=false;
		    }
		    if(!parsedOutput[parsedOutput.length-2].matches(".*29,\\[\\{13,30\\},\\{27,120\\},\\{6,15\\}\\].*")) {
		    	System.out.println("Missing call to PrintSafeDistancesAndDurations with args Medium exhalation -1");
		    	passing=false;
		    }
		    if(!parsedOutput[parsedOutput.length-1].matches(".*32,\\[\\{27,30\\},\\{13,15\\}\\].*")) {
		    	System.out.println("Missing call to PrintSafeDistancesAndDurations with args Medium exhalation +2");
		    	passing=false;
		    }

		    if(!passing) {
		    	System.out.println("Note make sure calls are in the order listed on the assingment document");
		    }

		    return passing?pass():fail("View console output for more information");
		
		} catch (Throwable e) {
			throw new NotGradableException(e.getMessage());
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
