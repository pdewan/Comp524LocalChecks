package gradingTools.comp524f19.assignment1.testcases;

import java.util.ArrayList;
import java.util.List;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.GradingMode;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.interpreter.checkers.ADiffPatchChecker;
import gradingTools.interpreter.checkers.CheckerResult;

public abstract class AbstractLispExpressionLastResultChecker extends AbstractLispExpressionChecker {
	protected  String actualOutput() {
		return resultSExpressions.get(resultSExpressions.size() - 1).toString();
		
	}

	
}
