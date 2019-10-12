package gradingTools.comp524f19.assignment2.testcases.LogicalCheckers;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(10)
@IsExtra(true)
@Explanation("Checks if OR works for variable args")
public class VariableArgumentOrChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(or (/= 1 1) (> 3 3) (>= 2 2) 9)"};
	public static final String[] STUDENT_TO_STRING = {"T"};
	public static final String[] GRADER_INPUT = {"(or (> 2 3) (not 1) nil (+ 2 2))"};
	public static final String[] GRADER_TO_STRING = {"4"};
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
