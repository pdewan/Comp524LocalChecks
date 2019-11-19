package gradingTools.comp524f19.assignment5;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f19.assignment1.testcases.ClassRegistryProvided;
import gradingTools.logs.DifficultyCommandsExtractor;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Determines how many difficulties and their resolutions are explained")
@MaxValue(50)
public class DifficultyExplanationTestCase extends PassFailJUnitTestCase {
	public static final int MAX_DIFFICULTIES = 15;
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(DataCollectionPeriodTestCase.class);
		int aNumDifficulties = DifficultyCommandsExtractor.getNumFilledDifficultyCommands();
		double percentage = Math.min(1, (double)aNumDifficulties/MAX_DIFFICULTIES);
		if (percentage == 1) {
			return pass();
		}
		if (percentage == 0) {
			return fail("No difficulty explanations provided");
		}
		return partialPass(percentage, aNumDifficulties + " difficulties explained out of a maximum of " + MAX_DIFFICULTIES);
	}

}
