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
@Explanation("Checks combination of operations")
public class CombinationChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(eval (eval (list (quote cond) (list (quote (or (/= 1 1) (and nil 3))) (cons 1 2)) (list (quote (< 3 2)) 3) (list (quote (and 2 T)) (quote (quote (+ 2 2)))))))"};
	public static final String[] STUDENT_TO_STRING = {"4"};
	public static final String[] GRADER_INPUT = {"(eval (quote (cond ((and  1 2) (eval (quote (list (quote +) 1 2)))))))"};
	public static final String[] GRADER_TO_STRING = {"(+ 1 2)"};
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
