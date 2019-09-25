package gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@MaxValue(10)
@Explanation("Checks if QUOTE works")
public class QuoteChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(quote (quote (+ 3 4)))"};
	public static final String[] STUDENT_TO_STRING = {"(QUOTE (+ 3 4))"};
	public static final String[] GRADER_INPUT = {"(quote (quote (quote (+ 1 4))))"};
	public static final String[] GRADER_TO_STRING = {"(QUOTE (QUOTE (+ 1 4)))"};
	@Override
	protected String[] expectedStudentOutput() {
		return STUDENT_TO_STRING;
	}
	@Override
	protected String[] expectedGraderOutput() {
		return GRADER_TO_STRING;
	}
	@Override
	protected String[] studentInputLines() {
		return STUDENT_INPUT;
	}
	@Override
	protected String[] graderInputLines() {
		// TODO Auto-generated method stub
		return GRADER_INPUT;
	}

	
}
