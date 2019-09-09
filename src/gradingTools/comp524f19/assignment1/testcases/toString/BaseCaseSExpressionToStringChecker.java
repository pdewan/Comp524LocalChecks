package gradingTools.comp524f19.assignment1.testcases.toString;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f19.assignment1.testcases.AbstractLispExpressionResultChecker;
import main.lisp.parser.terms.SExpression;

public class BaseCaseSExpressionToStringChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(cons 5 2)"};
	public static final String[] STUDENT_TO_STRING = {"(5 . 2)"};
	public static final String[] GRADER_INPUT = {"(cons 2 5)"};
	public static final String[] GRADER_TO_STRING = {"(2 . 5)"};
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
