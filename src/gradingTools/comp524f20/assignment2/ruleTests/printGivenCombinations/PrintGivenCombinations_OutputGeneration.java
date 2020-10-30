package gradingTools.comp524f20.assignment2.ruleTests.printGivenCombinations;

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
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SafeSocializationtxtProvided;
import gradingTools.comp524f20.assignment2.AnAbstractPrologRunningProject;
import gradingTools.comp524f20.assignment2.requiredFiles.SocialDistancePlProvided;
import gradingTools.comp524f20.assignment2.requiredFiles.SocialDiststancePlNoExternalFunctionsTest;
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
@MaxValue(2)
public class PrintGivenCombinations_OutputGeneration extends AnAbstractPrologRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public PrintGivenCombinations_OutputGeneration() {
	}
	
	private String [] recursionTestInput= {
			"write('recursion validation below\n---\n').",
			"trace(printGivenCombinations,call).",
			"write('tracing was turned on\n').",
			"printGivenCombinations(3).",
			"halt."	
	};
	
	private String [] recursionTestRegex={
			"^---.*",
			"^---.*",
		".*Call.*printGivenCombinations.*",
		".*Call.*printGivenCombinations.*",
		".*Call.*printGivenCombinations.*",
		};
	
	private int [] tableSizeInputParams= {
		7,
		0,
		1,
		2,
		3,
		4,
		5,
		6,
		7,
	};
	
	private int [] offTableSizeInputParams= {
		8,
		10,
		100,
		1000,
		Integer.MAX_VALUE
	};
	
	private String [] tableSizedInputs= {
			
			"printGivenCombinations("+tableSizeInputParams[0]+").",
			"printGivenCombinations("+tableSizeInputParams[1]+").",
			"printGivenCombinations("+tableSizeInputParams[2]+").",
			"printGivenCombinations("+tableSizeInputParams[3]+").",
			"printGivenCombinations("+tableSizeInputParams[4]+").",
			"printGivenCombinations("+tableSizeInputParams[5]+").",
			"printGivenCombinations("+tableSizeInputParams[6]+").",
			"printGivenCombinations("+tableSizeInputParams[7]+").",
			"printGivenCombinations("+tableSizeInputParams[8]+").",
	};
	private String [] nonTableSizedInputs= {
			"write('nonTableSizedInputs output below\n---\n').",
			
			"printGivenCombinations("+offTableSizeInputParams[0]+").",
			"printGivenCombinations("+offTableSizeInputParams[1]+").",
			"printGivenCombinations("+offTableSizeInputParams[2]+").",
			"printGivenCombinations("+offTableSizeInputParams[3]+").",
			"printGivenCombinations("+offTableSizeInputParams[4]+").",
			
			
	};
	
	private String [] outputOrder = null;
	
	protected int [] getTableSizeInputParams() {
		return tableSizeInputParams;
	}
	
	protected int [] getNonTableSizedInputParams() {
		return offTableSizeInputParams;
	}
	
	protected String [] getOutputOrder() {
		return outputOrder;
	}
	
	protected String [] getTabledSizedInputs() {
		return tableSizedInputs;
	}
	protected String [] getNonTableSizedInputs() {
		return nonTableSizedInputs;
	}
	
	private String output=null;
	
	public String getOutput() {
		return output;
	}
	
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {

			SocialDistancePlProvided aSocialDistanceFileProvided = (SocialDistancePlProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistancePlProvided.class);			
			
			String [] inputs=combineArrays(getTabledSizedInputs(),getNonTableSizedInputs(),recursionTestInput);
			
			SocialDiststancePlNoExternalFunctionsTest externalFunctions = (SocialDiststancePlNoExternalFunctionsTest) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDiststancePlNoExternalFunctionsTest.class);			
			if(!externalFunctions.hasPassed()) {
				System.err.println("WARNING EXTERNAL FUNCTIONS FOUND IN FILE SocialDistance.pl");
				//return fail("External functions present in code cannot proceed");
			}
			
			RunningProject aRunningProject = createRunningProject(project,aSocialDistanceFileProvided.getFileName(),inputs);
			if (aRunningProject == null) {
				return fail ("Could not create project. See console messages.");
			}

			String anOutput = aRunningProject.await().replaceAll("\n\n", "\n").replaceAll("\n\n", "\n");
//			LinesMatcher aLinesMatcher = aRunningProject.getLinesMatcher();
			
			findOutputOrder(anOutput); //To ignore order of the outputs
//			String [] defaultOutputOrder = {
//					"13,30,30,true",
//					"6,30,10,true",
//					"27,30,50,true",
//					"13,15,50,true",
//					"13,120,10,true",
//					"27,120,30,true",
//					"6,15,30,true"};
//			outputOrder=defaultOutputOrder;
			
			String errOutput=aRunningProject.getOutputAndErrors().replaceAll("\n\n", "\n").replaceAll("\n\n", "\n");
			boolean retVal=this.regexOutputChecksFailurePrint(errOutput.split("\n"), recursionTestRegex);
			if(!retVal) {
				anOutput=null;
				return fail("recursion not detected in prolog traces");
			}
						
			if(anOutput==null||anOutput.length()==0) {
				return fail("output from running commands is null or empty");
			}
			
			
			if(anOutput==null||anOutput.length()==0) {
				return fail("output from running commands is null or empty");
			}
			
			output=anOutput;
			return pass();
			

		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}
	
	private void findOutputOrder(String output) {
		String [] combination=output.split("\n");
		String [] foundOrder=new String[7];
		String [] defaultOutputOrder = {
				"13,30,30,true",
				"6,30,10,true",
				"27,30,50,true",
				"13,15,50,true",
				"13,120,10,true",
				"27,120,30,true",
				"6,15,30,true"};
		String [] testing=defaultOutputOrder.clone();
		
		int sequenceStart=0;
		int numPassed=0;
		for(int i=0;i<combination.length;i++) {
			if(isValidOutput(combination[i],testing)) {
				foundOrder[i-sequenceStart]=combination[i];
				numPassed++;
			}
			else if(combination[i].matches("false.")||i-sequenceStart==foundOrder.length)
				break;
			else
				sequenceStart++;
		}
		
		if(numPassed==foundOrder.length) {
			System.out.println("output order determined to be:");
			this.outputOrder=foundOrder;
		}else {
			System.out.println("output order could not be determined, using default:");
			this.outputOrder=defaultOutputOrder;
		}
			
		
		for(String order:outputOrder)
			System.out.println(order);
	}
	
	private boolean isValidOutput(String output,String[] validOutputs) {
		for(int i=0;i<validOutputs.length;i++) 
			if(validOutputs[i].equals(output)) {
				validOutputs[i]="";
				return true;
			}
		return false;
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
