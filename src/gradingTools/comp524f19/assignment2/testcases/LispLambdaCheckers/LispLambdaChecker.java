package gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@MaxValue(10)
@Explanation("Checks if lambda works")
public class LispLambdaChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"((lambda (a b) (+ a b)) 1 2)"};
	public static final String[] STUDENT_TO_STRING = {"3"};
	public static final String[] GRADER_INPUT = {"((lambda (a b) (list 3 4 a b)) 1 2)"};
	public static final String[] GRADER_TO_STRING = {"(3 4 1 2)"};
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
