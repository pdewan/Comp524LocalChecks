package gradingTools.comp524f19.assignment1.testcases;

import grader.basics.execution.NotRunnableException;
import grader.basics.execution.RunningProject;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.utils.RunningProjectUtils;

public class CustomCommandPromptTestCase extends PassFailJUnitTestCase {
	public CustomCommandPromptTestCase() {
//		super("Prompt printer test case");
	}

	private TestCaseResult testForIntegerPrompt(String output) {
		if (output.trim().toLowerCase().contains("int"))
			return pass();
		else
			return fail("Program does not contain prompt for integer");
	}

	private TestCaseResult testForDoublePrompt(String output) {
		if (output.toLowerCase().contains("decimal") || output.toLowerCase().contains("double"))
			return pass();
		else
			return fail("Program does not contain prompt for double");
	}

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {

			// Get the output when we have no input from the user
//			RunningProject noInputRunningProject = RunningProjectUtils.runProject(project, 1);
			RunningProject noInputRunningProject = CustomCommandIncrementalPromptTestCase.createCustomRunningProject(project, null);

			String noInputPrompt = noInputRunningProject.await();

			// Get the output when we have integer input from the user
//			RunningProject integerInputRunningProject = RunningProjectUtils.runProject(project, 1,
//					"1");
			RunningProject integerInputRunningProject = CustomCommandIncrementalPromptTestCase.createCustomRunningProject(project, null, "1");
			String integerInputPrompt = integerInputRunningProject.await();
			integerInputPrompt = integerInputPrompt.substring(noInputPrompt.length());

			// Get the output when we have double input from the user
//			RunningProject doubleInputRunningProject = RunningProjectUtils.runProject(project, 1,
//					"1.4");
			RunningProject doubleInputRunningProject = CustomCommandIncrementalPromptTestCase.createCustomRunningProject(project, null,
					"1.4");
			String doubleInputPrompt = doubleInputRunningProject.await();
			doubleInputPrompt = doubleInputPrompt.substring(noInputPrompt.length());

			// See if the initial prompt is an int or double prompt
			boolean hasIntPrompt = testForIntegerPrompt(noInputPrompt).getPercentage() > 0;
			boolean hasDoublePrompt = testForDoublePrompt(noInputPrompt).getPercentage() > 0;
			boolean samePromptForBoth = hasIntPrompt && hasDoublePrompt;

			// If we have not seen prompts for ints or doubles, check if they
			// show up after giving input
			if (!hasIntPrompt) {
				hasIntPrompt = testForIntegerPrompt(doubleInputPrompt).getPercentage() > 0;
			}
			if (!hasDoublePrompt) {
				hasDoublePrompt = testForDoublePrompt(integerInputPrompt).getPercentage() > 0;
			}

			// Create an error message based on our findings
			String errorMessage = "";
			double credit = 1.0;
			if (!hasIntPrompt) {
				errorMessage += "Program does not prompt for integer inputs\n";
				credit = 0.5;
			}
			if (!hasDoublePrompt) {
				errorMessage += "Program does not prompt for double inputs\n";
				if (credit == 0.5) {
					credit = 0;
				} else {
					credit = 0.5;
				}
			}
			if (samePromptForBoth) {
				errorMessage = "Program does not prompt separately for int and double inputs\n";
				credit = 0.5;
			}

			if (credit == 1.0) {
				return pass();
			} else if ((noInputPrompt.length()) > 0
					&& ((integerInputPrompt.length() > 0) || (doubleInputPrompt.length() > 0))) {
				throw new NotAutomatableException();
			} else {
				return partialPass(credit, errorMessage);
			}
		}

		catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}
}
