package gradingTools.comp524f19.assignment3.testcases.HighOderFunctionCheckers;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.MaxValue;
@MaxValue(5)
public class DotCatChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(funcall dotcat \"hello!\" \"world!\")"};
	public static final String[] STUDENT_TO_STRING = {"\"(hello! . world!)\""};
	public static final String[] GRADER_INPUT = {"(funcall isList (cons 5 6))"};
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
