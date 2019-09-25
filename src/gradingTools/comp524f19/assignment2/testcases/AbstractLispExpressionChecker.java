package gradingTools.comp524f19.assignment2.testcases;

import java.util.List;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.GradingMode;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.interpreter.checkers.ADiffPatchChecker;
import gradingTools.interpreter.checkers.CheckerResult;

public abstract class AbstractLispExpressionChecker extends AbstractLispExpressionInputter {
	protected abstract String[] expectedStudentOutput();
	protected abstract String[] expectedGraderOutput();
	protected abstract String actualOutput();
	protected TestCaseResult compareOutput() {
		try {
//			SExpression anExpression = evaluate("(cons 5 2)");
				evaluate();
//				String anActualOutput = BasicProjectExecution.toString(anOutput);
				String anActualOutput = actualOutput();

				String anExpectedOutput;
				if (GradingMode.getGraderRun()) {
					anExpectedOutput = BasicProjectExecution.toString(expectedGraderOutput());
				} else {
					anExpectedOutput = BasicProjectExecution.toString(expectedStudentOutput());
				}
				CheckerResult aDiffResult = ADiffPatchChecker.check(anExpectedOutput, anActualOutput);
				if (aDiffResult.isSucceeded()) {
					return pass();
				}
				return fail("Expected strings:" + anExpectedOutput + "actual string " + anActualOutput);			
			} catch (Throwable e) {
				e.printStackTrace();
				return fail(e.getMessage());
			}
	}
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		try {
//		SExpression anExpression = evaluate("(cons 5 2)");
			return (compareOutput());
			
		} catch (Throwable e) {
			e.printStackTrace();
			return fail(e.getMessage());
		}
		
	}
	
}
