package gradingTools.comp524f21.assignment6.tests.let;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(10)
@IsExtra(true)
public class BasicLetTest extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {
			"(setq letTestVar1 10)",
			"(let ((letTestVar1 42)) letTestVar1)",
	};
	public static final String[] STUDENT_TO_STRING = {"10","42"};

	
	
	
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
