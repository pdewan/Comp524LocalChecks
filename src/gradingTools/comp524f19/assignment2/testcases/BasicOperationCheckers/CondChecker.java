package gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@MaxValue(10)
@Explanation("Checks if COND works")
public class CondChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(cond (T (+ 2 1)) (T (+1)) (T (= 1 +)))"};
	public static final String[] STUDENT_TO_STRING = {"3"};
	public static final String[] GRADER_INPUT = {"(cond ((< 3 1) T) (T (+ 1 1)) (T 3))"};
	public static final String[] GRADER_TO_STRING = {"2"};
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
