package gradingTools.comp524.assignment1.testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import grader.basics.TestImplementationAPI;
import grader.basics.execution.NotRunnableException;
import grader.basics.execution.RunningProject;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.utils.RunningProjectUtils;
import util.pipe.InputGenerator;

public class CustomCommandIncrementalPromptTestCase extends IncrementalInputPromptTestCase {
	public CustomCommandIncrementalPromptTestCase() {
//		super("Prompt printer test case");
		super();
	}
	
//	public static boolean hasIntegerPrompt(String output) {
//		return output.trim().toLowerCase().contains("int");
//	}
//	
//	public static boolean hasDoublePrompt(String output) {
//		return output.toLowerCase().contains("decimal") || output.toLowerCase().contains("double");
//	}

//	private TestCaseResult testForIntegerPrompt(OutputBasedMixedArithmeticInputGenerator anOutputBasedInputGenerator) {
////		if (output.trim().toLowerCase().contains("int"))
//		if (anOutputBasedInputGenerator.foundIntPrompt())
//			return pass();
//		else
//			return fail("Program does not contain prompt for integer");
//	}
//
//	private TestCaseResult testForDoublePrompt(OutputBasedMixedArithmeticInputGenerator anOutputBasedInputGenerator) {
//		if (anOutputBasedInputGenerator.foundDoublePrompt())
//			return pass();
//		else
//			return fail("Program does not contain prompt for double");
//	}
//	private TestCaseResult testForIntegerPrompt(String output) {
//		if (output.trim().toLowerCase().contains("int"))
//			return pass();
//		else
//			return fail("Program does not contain prompt for integer");
//	}
//
//	private TestCaseResult testForDoublePrompt(String output) {
//		if (output.toLowerCase().contains("decimal") || output.toLowerCase().contains("double"))
//			return pass();
//		else
//			return fail("Program does not contain prompt for double");
//	}
    public static RunningProject createCustomRunningProject(Project project, InputGenerator anInputGenerator, String... anInputs ) {
//    	OutputBasedMixedArithmeticInputGenerator anOutputBasedInputGenerator = new AnOutputBasedMixedArithmeticInputGenerator(1, 1.4);
		try {
    	File aWorkingDirectory = project.getBuildFolder();
		String anEntryPoint = TestImplementationAPI.getMainEntryPoint(project, null);
//		String[] anArgs = new String[] {};
		String[] aCommand = new String[] {aWorkingDirectory + "/" + anEntryPoint};
		return TestImplementationAPI.createRunningProject(aWorkingDirectory, anInputGenerator, aCommand, anInputs);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
    }
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {

			// Get the output when we have no input from the user
//			RunningProject noInputRunningProject = RunningProjectUtils.runProject(project, 1);
			OutputBasedMixedArithmeticInputGenerator anOutputBasedInputGenerator = new AnOutputBasedMixedArithmeticInputGenerator(1, 1.4);
//			File aWorkingDirectory = project.getBuildFolder();
//			String anEntryPoint = TestImplementationAPI.getMainEntryPoint(project, null);
////			String[] anArgs = new String[] {};
//			String[] aCommand = new String[] {aWorkingDirectory + "/" + anEntryPoint};
//			RunningProject aRnningProject = TestImplementationAPI.createRunningProject(aWorkingDirectory, anOutputBasedInputGenerator, aCommand, 10, null, null);
//			
//			RunningProject interactiveInputProject = RunningProjectUtils.runProject(project, 30,
//					anOutputBasedInputGenerator);
			RunningProject aRnningProject = createCustomRunningProject(project, anOutputBasedInputGenerator, null);

			String incOutput = aRnningProject.await();
			if (anOutputBasedInputGenerator.foundDoublePrompt() && anOutputBasedInputGenerator.foundIntPrompt())
				return pass();
			else
				return 	fail("Did not find prompt");
//			String noInputPrompt = noInputRunningProject.await();
//
//			// Get the output when we have integer input from the user
//			RunningProject integerInputRunningProject = RunningProjectUtils.runProject(project, 1,
//					"1");
//			String integerInputPrompt = integerInputRunningProject.await();
//			integerInputPrompt = integerInputPrompt.substring(noInputPrompt.length());
//
//			// Get the output when we have double input from the user
//			RunningProject doubleInputRunningProject = RunningProjectUtils.runProject(project, 1,
//					"1.4");
//			String doubleInputPrompt = doubleInputRunningProject.await();
//			doubleInputPrompt = doubleInputPrompt.substring(noInputPrompt.length());

			// See if the initial prompt is an int or double prompt
//			boolean hasIntPrompt = testForIntegerPrompt(anOutputBasedInputGenerator).getPercentage() > 0;
//			boolean hasDoublePrompt = testForDoublePrompt(anOutputBasedInputGenerator).getPercentage() > 0;
////			boolean samePromptForBoth = hasIntPrompt && hasDoublePrompt;
//			String noInputPrompt = "";
//			String integerInputPrompt = "";
//			String doubleInputPrompt = "";
//			// If we have not seen prompts for ints or doubles, check if they
//			// show up after giving input
//			if (!hasIntPrompt || !hasDoublePrompt) {
//				// Get the output when we have no input from the user
//				RunningProject noInputRunningProject = RunningProjectUtils.runProject(project, 1);
//				 noInputPrompt = noInputRunningProject.await();
//			}
//			
//			if (!hasIntPrompt) {
//				// Get the output when we have double input from the user
//				RunningProject doubleInputRunningProject = RunningProjectUtils.runProject(project, 1,
//						"1.4");
//				 doubleInputPrompt = doubleInputRunningProject.await();
//				doubleInputPrompt = doubleInputPrompt.substring(noInputPrompt.length());
//
//				hasIntPrompt = testForIntegerPrompt(doubleInputPrompt).getPercentage() > 0;
//			}
//			if (!hasDoublePrompt) {
//				// Get the output when we have integer input from the user
//				RunningProject integerInputRunningProject = RunningProjectUtils.runProject(project, 1,
//						"1");
//				 integerInputPrompt = integerInputRunningProject.await();
//				integerInputPrompt = integerInputPrompt.substring(noInputPrompt.length());
//				hasDoublePrompt = testForDoublePrompt(integerInputPrompt).getPercentage() > 0;
//
//			}
//			
//
//			// Create an error message based on our findings
//			String errorMessage = "";
//			double credit = 1.0;
//			if (!hasIntPrompt) {
//				errorMessage += "Program does not prompt for integer inputs\n";
//				credit = 0.5;
//			}
//			if (!hasDoublePrompt) {
//				errorMessage += "Program does not prompt for double inputs\n";
//				if (credit == 0.5) {
//					credit = 0;
//				} else {
//					credit = 0.5;
//				}
//			}
//			if (samePromptForBoth) {
//				errorMessage = "Program does not prompt separately for int and double inputs\n";
//				credit = 0.5;
//			}
//
//			if (credit == 1.0) {
//				return pass();
////			} else if ((noInputPrompt.length()) > 0
////					&& ((integerInputPrompt.length() > 0) || (doubleInputPrompt.length() > 0))) {
////				throw new NotAutomatableException();
////			} else {
//			} else if ((noInputPrompt.length() <= 0 && integerInputPrompt.length() <= 0 && doubleInputPrompt.length() <=0) ) {
//				throw new NotAutomatableException();
//			} else {
//				return partialPass(credit, errorMessage);
//			}
//		}
//
		} catch (NotRunnableException e) {
			throw new NotGradableException(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NotGradableException(e.getMessage());
		}
	}
}
