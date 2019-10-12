package gradingTools.comp524f19.assignment1.testcases.toString;

import gradingTools.comp524f19.assignment1.testcases.AbstractLispExpressionResultChecker;
import util.annotations.MaxValue;
@MaxValue(10)
public class BaseCaseListToStringChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(cons 5 nil)"};
	public static final String[] STUDENT_TO_STRING = {"(5)"};
	public static final String[] GRADER_INPUT = {"(cons 2 nil)"};
	public static final String[] GRADER_TO_STRING = {"(2)"};
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
