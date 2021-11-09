package gradingTools.comp524f21.assignment6.testCases.basicOperations;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(10)
@IsExtra(true)
@Explanation("Checks if COND works for edge cases")
public class A6ExtraCondChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {
			"(cond)",
			"(cond (T nil))",
			"(cond (T))",
			"(cond (nil) ((+ 11 12)))",
			"(cond (nil))",
	};
	
	public static final String[] STUDENT_TO_STRING = {
			"NIL",
			"NIL",
			"T",
			"23",
			"NIL",
	};

	@Override
	protected String[] expectedStudentOutput() {
		return STUDENT_TO_STRING;
	}
	@Override
	protected String[] expectedGraderOutput() {
		return STUDENT_TO_STRING;
	}
	@Override
	protected String[] studentInputLines() {
		return STUDENT_INPUT;
	}
	@Override
	protected String[] graderInputLines() {
		return STUDENT_INPUT;
	}

	
}
