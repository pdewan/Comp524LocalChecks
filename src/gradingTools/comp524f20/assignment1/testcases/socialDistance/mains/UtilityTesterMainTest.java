package gradingTools.comp524f20.assignment1.testcases.socialDistance.mains;

import java.lang.reflect.Method;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.ResultWithOutput;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityTesterMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.CompareSafetyComputationsTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintGeneratedCombinationDerivedSafetyTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintGivenAndGeneratedCombinationsInferredSafety;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.PrintSafeDistancesAndDurationsTest;
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
			PrintGivenAndGeneratedCombinationsInferredSafety printedInferredWorking = (PrintGivenAndGeneratedCombinationsInferredSafety) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(PrintGivenAndGeneratedCombinationsInferredSafety.class);
			CompareSafetyComputationsTest compareWorking = (CompareSafetyComputationsTest) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(CompareSafetyComputationsTest.class);
			PrintSafeDistancesAndDurationsTest printedSafeDistancesWorking = (PrintSafeDistancesAndDurationsTest) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(PrintSafeDistancesAndDurationsTest.class);
			if (!printedDerviedWorking.isPassing())
		    	return fail ("PrintGeneratedCombinationDerivedSafetyTest must first pass before this test can be ran");
		    if (!printedInferredWorking.isPassing()) 
		    	return fail ("PrintGeneratedCombinationInferredSafetyTest must first pass before this test can be ran");
		    if (!compareWorking.isPassing()) 
		    	return fail ("CompareSafetyComputationsTest must first pass in order for this test to be ran");
		    if (!printedSafeDistancesWorking.isPassing()) 
		    	return fail ("PrintSafeDistancesAndDurationsTest must first pass in order for this test to be ran");
		    
		    System.out.println("---------------------");
		    Class[] aParameterTypes = argumentTypes();
		    Method aMethod = aUtilityTesterMainClass.getMethod(methodName(), aParameterTypes);
		    Object[] anArguments = getArguments();
		    ResultWithOutput aResultWithOutput = BasicProjectExecution.timedInteractiveInvoke(aUtilityTesterMainClass, aMethod, anArguments, TIME_OUT_MSECS);
		    
		    String anOutput = aResultWithOutput.getOutput();
		    if (anOutput == null || anOutput.isEmpty() ) {
		    	return fail("No Output");
		    }

		    String [] parsedOutput=anOutput.split("\n");
		    int callsFound=0;
		    String [] regexList= {
		    	"[Dd]istance,[Dd]uration,[Ee]xhalation,[Ii]sSafe.*",
		    	"[Dd]istance,[Dd]uration,[Ee]xhalation,[Ii]sSafe.*",
		    	"[Dd]istance,[Dd]uration,[Ee]xhalation,[Dd]erived,[Ii]nferred.*",
		    	"30,\\[\\{\\d+,\\d+\\}[,]*\\{\\d+,\\d+\\}[,]*\\{\\d+,\\d+\\}\\].*",
		    	"29,\\[\\{\\d+,\\d+\\}[,]*\\{\\d+,\\d+\\}[,]*\\{\\d+,\\d+\\}\\].*",
		    	"32,\\[\\{\\d+,\\d+\\}[,]*\\{\\d+,\\d+\\}\\].*"
		    };
		    String [] methodTestName= {
		    		"PrintGeneratedCombinationDerivedSafety",
		    		"PrintGeneratedCombinationInferredSafety",
		    		"CompareSafetyComputations",
		    		"PrintSafeDistancesAndDurations with args Medium exhalation",
		    		"PrintSafeDistancesAndDurations with args Medium exhalation -1",
		    		"PrintSafeDistancesAndDurations with args Medium exhalation +2"
		    };
		    
		    for(String line:parsedOutput) {
		    	if(line.matches(regexList[callsFound])) {
		    		callsFound++;
		    	}
		    }

		    if(callsFound<regexList.length) {
		    	System.out.println("Missing call to "+methodTestName[callsFound]);
		    	System.out.println("Note make sure calls are in the order listed on the assingment document");
		    	return fail("View console output for more information");
		    }

		    return pass();
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
