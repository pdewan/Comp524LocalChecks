package gradingTools.comp524f19.assignment2.testcases.LogicalCheckers;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import main.lisp.parser.terms.SExpression;
import util.annotations.MaxValue;
@MaxValue(10)
public class NotChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(not (+ 1 8))"};
	public static final String[] STUDENT_TO_STRING = {"NIL"};
	public static final String[] GRADER_INPUT = {"(not (/= 1 1))"};
	public static final String[] GRADER_TO_STRING = {"T"};
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
