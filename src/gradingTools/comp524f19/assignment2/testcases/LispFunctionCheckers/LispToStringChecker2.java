package gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@MaxValue(15)
@Explanation("Checks if lisp toString works")
public class LispToStringChecker2 extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(funcall toString (List 2 8 (list 9 5)))"};
	public static final String[] STUDENT_TO_STRING = {"\"(2 8 (9 5))\""};
	public static final String[] GRADER_INPUT = {"(funcall toString (List 2 7 (list 4 (cons 5 2))))"};
	public static final String[] GRADER_TO_STRING = {"\"(2 7 (4 (5 . 2)))\""};
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
