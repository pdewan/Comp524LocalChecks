package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

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
@MaxValue(7)
public class PrintGeneratedCombinationInferredSafetyTest extends AbstractPrintDerivedSafetyValidator {
	public static final int TIME_OUT_MSECS = 300; // secs
	
	protected final String methodName = "printGivenAndGeneratedCombinationsInferredSafety";
	protected final String aVerifyingMethodName="isInferredSafe";

	public PrintGeneratedCombinationInferredSafetyTest() {
	}
	@Override
	protected  String methodName() {
		return methodName;
	}
	
	@Override
	protected String verifyingMethodName() {
		return aVerifyingMethodName;
	}
	
	protected static String[] anExpectedOutput= {
			"Distance,Duration,Exhalation,IsSafe",
			"13,30,30,true",
			"6,30,10,true",
			"27,30,50,true",
			"13,15,50,true",
			"13,120,10,true",
			"27,120,30,true",
			"6,15,30,true"
	};
	protected String[] anExpectedOutput() {
		return anExpectedOutput;
	}
	
	protected boolean isPassing=false;
	public boolean isPassing() {
		return isPassing;
	}
	
	protected boolean isOutputValid(String[] anOutputLines,Class aUtilityClass,Method aVerifyingMethod) throws Throwable {
		String [] anExpectedOutputList=anExpectedOutput();
	    boolean passing=true;
	    for(int i=0;i<anOutputLines.length;i++) {
	    	if(i<anExpectedOutputList.length) {
	    		if(!anExpectedOutputList[i].equals(anOutputLines[i])) {
	    			passing=false;
	    			System.err.println("Output line: \""+anOutputLines[i]+"\" does not match expected \""+anExpectedOutputList[i]+"\"");
	    		}
	    	}else if (i==anExpectedOutputList.length) {
	    		if(!anOutputLines[i].matches("-+?")) {
	    			passing=false;
		    		System.err.println("Output line: \""+anOutputLines[i]+"\" does not match regex \"-+\"");
	    		}
	    	}else {
	    		if(!verify(anOutputLines[i],aUtilityClass,aVerifyingMethod)){
	    			passing=false;
	    			System.err.println("Result on line: \""+anOutputLines[i]+"\" does not match expected result for method:\""+ verifyingMethodName() +"\"");
	    		}
	    	}
	    }
	    return passing;
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
		    Class[] aParameterTypes = argumentTypes();
		    Method aMethod = aUtilityClass.getMethod(methodName(), aParameterTypes);
		    Object[] anArguments = getArguments();
		    ResultWithOutput aResultWithOutput1 = BasicProjectExecution.timedInteractiveInvoke(aUtilityClass, aMethod, anArguments, TIME_OUT_MSECS);
		    
		    String anOutput1 = aResultWithOutput1.getOutput();
		    if (anOutput1 == null || anOutput1.isEmpty() ) {
		    	return fail("No Output");
		    }
		    
		    String [] anOutputLines1 = anOutput1.split("\n");
		    if (anOutputLines1.length != 19) {
		    	return fail("Output does not match desired line length");
		    }
		    
		    ResultWithOutput aResultWithOutput2 = BasicProjectExecution.timedInteractiveInvoke(aUtilityClass, aMethod, anArguments, TIME_OUT_MSECS);
		    
		    String anOutput2 = aResultWithOutput2.getOutput();
		    if (anOutput2 == null || anOutput2.isEmpty() ) {
		    	return fail("No Output");
		    }
		    
		    String [] anOutputLines2 = anOutput2.split("\n");
		    if (anOutputLines2.length != 19) {
		    	return fail("Output does not match desired line length");
		    }
		    
		    if (anOutput1.equals(anOutput2)) {
		    	return fail("Two successive calls return same output");
		    }
		   
		    Method aVerifyingMethod =  aUtilityClass.getMethod(verifyingMethodName(), verifyingArgumentTypes()); 
		    
		    isPassing=isOutputValid(anOutputLines1,aUtilityClass,aVerifyingMethod)&&isOutputValid(anOutputLines2,aUtilityClass,aVerifyingMethod);
		    
		    return isPassing?pass():fail("View console output for more information");
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
