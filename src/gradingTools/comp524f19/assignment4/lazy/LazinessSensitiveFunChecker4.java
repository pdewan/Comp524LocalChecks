package gradingTools.comp524f19.assignment4.lazy;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(10)
@IsExtra(true)
public class LazinessSensitiveFunChecker4 extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(setevalmode \"LAZY\")", "(car (funcall listMToN 2 5))"};
	public static final String[] STUDENT_TO_STRING = {
			"\"LAZY\"",
			"2",
			"2"
			};
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
