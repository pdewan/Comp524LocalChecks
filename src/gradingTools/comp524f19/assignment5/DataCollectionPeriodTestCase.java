package gradingTools.comp524f19.assignment5;

import java.util.Date;
import java.util.List;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.logs.DifficultyCommandsExtractor;
import gradingTools.logs.DifficultyContext;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@MaxValue(50)
@Explanation("Determines the number of days for which data was collected - max 30")
public class DataCollectionPeriodTestCase extends PassFailJUnitTestCase{
	public static long MS_IN_DAY = 24*60*60*1000;
	public static long MAX_DAYS = 30;
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		DifficultyCommandsExtractor.init();
		DifficultyCommandsExtractor.
//		fillDifficultyCommandsInProjectDirectory(project.getProjectFolder());
		processLogsInProjectFolder(project.getProjectFolder());

//		int numCommands = DifficultyCommandsExtractor.getDifficultyDates().size();
		List<DifficultyContext> aDifficultyLog = DifficultyCommandsExtractor.getDifficultyContext();
		Date aFirstDate = DifficultyCommandsExtractor.getFirstDate();
		Date aLastDate =  DifficultyCommandsExtractor.getLastDate();
		if (aFirstDate == null) {
			return fail("No logged eclipse commands found");
		}
		long aLogDuration = aLastDate.getTime() - aFirstDate.getTime();
		long aNumDays = aLogDuration/MS_IN_DAY;
		double aFractionLogged = (double) aNumDays/MAX_DAYS;
		double percentage = Math.min(1, aFractionLogged);
		if (percentage < 1) {
			return partialPass(percentage, "Logged " + aNumDays + " out of maximum of" + MAX_DAYS);
		}
		return pass();
		
		
//		Date aLastDate = aDifficultyLog.get(aDifficultyLog.size() - 1).date;
		
	}

}
