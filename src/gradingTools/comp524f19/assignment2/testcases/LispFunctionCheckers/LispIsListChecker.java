package gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@MaxValue(15)
@Explanation("Checks if lisp isList works")
public class LispIsListChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(funcall isList (cons 5 NIL))"};
	public static final String[] STUDENT_TO_STRING = {"T"};
	public static final String[] GRADER_INPUT = {"(or 3 nil)"};
	public static final String[] GRADER_TO_STRING = {"3"};
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
