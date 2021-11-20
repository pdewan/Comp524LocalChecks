package gradingTools.comp524f21.assignment5.toString;

import gradingTools.comp524f20.assignment5.testcases.toString.AbstractLispExpressionResultDeepChecker;
import util.annotations.MaxValue;
@MaxValue(5)
public class ListToStringDeepCheckerAdvanced extends AbstractLispExpressionResultDeepChecker {
	public static final String[] STUDENT_INPUT = {"(cons 5 (cons (cons (cons \"A\" \"6\") nil) (cons (cons 7 nil) nil)))"};
	public static final String[] STUDENT_TO_STRING = {"(5 . (((\"A\" . \"6\") . NIL) . ((7 . NIL) . NIL)))"};
	public static final String[] GRADER_INPUT = {"(list \"a\" (cons 1 2) (eval (quote (list 1 (and T T)))))"};
	public static final String[] GRADER_TO_STRING = {"(\"a\" . ((1 . 2) . ((1 . (T . NIL)) . NIL)))"};

	@Override
	protected String[] expectedStudentOutput() {
		return GRADER_TO_STRING;
	}
	@Override
	protected String[] expectedGraderOutput() {
		return GRADER_TO_STRING;
	}
	@Override
	protected String[] studentInputLines() {
		return GRADER_INPUT;
	}
	@Override
	protected String[] graderInputLines() {
		return GRADER_INPUT;
	}

	
}
