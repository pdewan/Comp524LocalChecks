package gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@MaxValue(10)
@Explanation("Checks if setq evaluator works")
public class LispSetqChecker3 extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"d"};
	public static final String[] STUDENT_TO_STRING = {"(8 . 3)"};
	public static final String[] GRADER_INPUT = {"f"};
	public static final String[] GRADER_TO_STRING = {"9"};
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
