package gradingTools.comp524f19.assignment4.testcases.FunFreeVariablesCheckers;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(30)
@IsExtra(true)
public class FunFreeVariablesChecker2 extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(setq GV 15)","(funcall FreeVariableBindingTester 13 7 100)"};
	public static final String[] STUDENT_TO_STRING = {"15","1"};
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
