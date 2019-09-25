package gradingTools.comp524f19.assignment2.testcases.RelationalCheckers;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@MaxValue(10)
@Explanation("Checks if <= works")
public class LessOrEqualChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(<= (+ 1 2) (eval 5))"};
	public static final String[] STUDENT_TO_STRING = {"T"};
	public static final String[] GRADER_INPUT = {"(<= 3 (cond (nil 1) (T 2)))"};
	public static final String[] GRADER_TO_STRING = {"NIL"};
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
