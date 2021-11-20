package gradingTools.comp524f21.assignment5.toString;

import gradingTools.comp524f19.assignment1.testcases.AbstractLispExpressionResultChecker;
import util.annotations.MaxValue;
@MaxValue(15)
public class ListToStringCheckerAdvanced extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(cons 5 (cons (cons (cons \"A\" \"6\") nil) (cons (cons 7 nil) nil)))"};
	public static final String[] STUDENT_TO_STRING = {"(5 ((\"A\" . \"6\")) (7))"};
	public static final String[] GRADER_INPUT = {"(list \"a\" (cons 1 2) (eval (quote (list 1 (and T T)))))"};
	public static final String[] GRADER_TO_STRING = {"(\"a\" (1 . 2) (1 T))"};
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
