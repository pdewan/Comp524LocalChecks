package gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@MaxValue(10)
@Explanation("Checks if LIST works")
public class ListChecker2 extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(list (+ 3 3)  (list (+ 1 2) (cons 4 3)) (- 2 1))"};
	public static final String[] STUDENT_TO_STRING = {"(6 (3 (4 . 3)) 1)"};
	public static final String[] GRADER_INPUT = {"(list (cond (nil 1) (T (+ 1 2))) (cons 1 3) (quote (and 1 2 3)))"};
	public static final String[] GRADER_TO_STRING = {"(3 (1 . 3) (AND 1 2 3))"};
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
