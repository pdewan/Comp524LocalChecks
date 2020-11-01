package gradingTools.comp524f20.assignment5.testcases.toString;

import util.annotations.MaxValue;
@MaxValue(10)
public class ListToStringDeepChecker extends AbstractLispExpressionResultDeepChecker {
	public static final String[] STUDENT_INPUT = {"(cons 5 (cons (cons (cons \"A\" \"6\") nil) (cons (cons 7 nil) nil)))"};
	public static final String[] STUDENT_TO_STRING = {"(5 . (((\"A\" . \"6\") . NIL) . ((7 . NIL) . NIL)))"};
	public static final String[] GRADER_INPUT = {"(list \"a\" (cons 1 2) (eval (quote (list 1 (and T T)))))"};
	public static final String[] GRADER_TO_STRING = {"(a . ((1 . 2) . ((1 . (T . NIL)) . NIL)))"};
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
