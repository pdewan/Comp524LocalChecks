package gradingTools.comp524f19.assignment2.testcases.LogicalCheckers;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@MaxValue(10)
@Explanation("Checks if AND works for the basic case")
public class BasicAndChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(and T 2)"};
	public static final String[] STUDENT_TO_STRING = {"2"};
	public static final String[] GRADER_INPUT = {"(and T nil)"};
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
