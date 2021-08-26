package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import java.io.File;
import java.util.Scanner;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SafeSocializationtxtProvided;
import util.annotations.MaxValue;
@MaxValue(10)
public class WekaFileSizeTest extends PassFailJUnitTestCase {
	public static final int TIME_OUT_MSECS = 100; // secs
	
	private static final int BENS_FILE_SIZE_LINES=114;
	
	public WekaFileSizeTest() {
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
			SafeSocializationtxtProvided aSafeSocializationFileProvided = (SafeSocializationtxtProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SafeSocializationtxtProvided.class);			
			File aSafeSocilizationFile = aSafeSocializationFileProvided.getRequiredFile();

			
//			SocialDistanceClassRegistry aClassRegistry = aClassRegistryProvided.getTimingOutClassRegistryProxy();  

		    if (aSafeSocilizationFile == null) {
		    	return fail ("Missing SafeSocialization.txt");
		    }
		    
		    int numLines=0;
			Scanner scan = new Scanner(aSafeSocilizationFile);
			while(scan.hasNextLine()) {
				scan.nextLine();
				numLines++;
			}
		    scan.close();
//		    double aPercentage = ((double) aNumSuccesses)/aResults.length;
//		    return aPercentage == 1?pass():partialPass(aPercentage, aNumSuccesses + " tests passed out of " +   aResults.length);  

		    double aPercentage=BENS_FILE_SIZE_LINES/((double)numLines);
		    
		    return aPercentage >= 1?pass():partialPass(aPercentage, "Weka training data (SafeSocialization.txt) should be at "+BENS_FILE_SIZE_LINES+" lines or less while still accurate with other tests");  

		} catch ( Throwable e) {
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
