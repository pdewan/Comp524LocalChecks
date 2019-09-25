package gradingTools.comp524f19.assignment2.testcases.LogicalCheckers;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(10)
@IsExtra(true)
@Explanation("Checks if AND works for variable args")
public class VariableArgumentAndChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(and (/= 3 4) (> 3 2) (+ 8 9) (- 3 1))"};
	public static final String[] STUDENT_TO_STRING = {"2"};
	public static final String[] GRADER_INPUT = {"(and (list 1 2 3 4) (not (/= 1 1)) (eval (quote (+ 1 2))) (cons 1 2))"};
	public static final String[] GRADER_TO_STRING = {"(1 . 2)"};
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
