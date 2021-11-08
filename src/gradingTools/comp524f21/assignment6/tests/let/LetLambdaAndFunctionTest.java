package gradingTools.comp524f21.assignment6.tests.let;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(40)
@IsExtra(true)
public class LetLambdaAndFunctionTest extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {
			"(setq letTestVar1 10)",
			"(setq letTestVar2 42)",
			"(let ((letTestVar1 5) (letTestVar2 3)) ((lambda () (+ letTestVar1 letTestVar2))))",
			"(funcall (let ((letTestVar1 5) (letTestVar2 3)) (function (lambda () (+ letTestVar1 letTestVar2)))))",
	};
	public static final String[] STUDENT_TO_STRING = {"10","42","8","8"};

	
	
	
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
