package gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@MaxValue(10)
@Explanation("Checks if LIST works")
public class ListChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(list (+ 2 3)  3 (- 2 1))"};
	public static final String[] STUDENT_TO_STRING = {"(5 3 1)"};
	public static final String[] GRADER_INPUT = {"(list (cons 1 2) (cons 3 nil) 3)"};
	public static final String[] GRADER_TO_STRING = {"((1 . 2) (3) 3)"};
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
