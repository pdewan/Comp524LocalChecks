package gradingTools.comp524f19.assignment1.testcases;

import java.util.List;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.GradingMode;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.interpreter.checkers.ADiffPatchChecker;
import gradingTools.interpreter.checkers.CheckerResult;

public abstract class AbstractLispExpressionInputSExpressionChecker extends AbstractLispExpressionChecker {
	protected  String actualOutput() {
		return BasicProjectExecution.toString(inputSExpressions);
	}

//	@Override
//	public TestCaseResult test(Project project, boolean autoGrade)
//			throws NotAutomatableException, NotGradableException {
//		try {
////		SExpression anExpression = evaluate("(cons 5 2)");
//			evaluate();
//			return (compareOutput(inputSExpressions));
//			
//		} catch (Throwable e) {
//			e.printStackTrace();
//			return fail(e.getMessage());
//		}
//		
//	}
}
