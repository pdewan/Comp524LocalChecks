package gradingTools.comp524f20.assignment6.testcases.socialDistance;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;

public class SafetyTableChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(funcall (funcall funExpTraverseUseGenerator one sum) (list 2 (cons 4 5)))"};
	public static final String[] STUDENT_TO_STRING = {"4"};
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
