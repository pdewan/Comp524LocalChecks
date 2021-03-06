package gradingTools.comp524f20.assignment6.testcases.functionExpression;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.MaxValue;
@MaxValue(50)
public class PlusGeneratorChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(funcall ((lambda (x) (function (lambda (y) (+ x y))))2)3)"};
	public static final String[] STUDENT_RESULT = {"5"};
	public static final String[] GRADER_INPUT = STUDENT_INPUT;
	public static final String[] GRADER_RESULT = STUDENT_RESULT;
	@Override
	protected String[] expectedStudentOutput() {
		return STUDENT_RESULT;
	}
	@Override
	protected String[] expectedGraderOutput() {
		return GRADER_RESULT;
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
