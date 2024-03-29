package gradingTools.comp524f19.assignment4.lazy;

import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(15)
@IsExtra(true)
public class ListMToNCarLazyEval extends AbstractEvaluatorAndResultChecker {
	public static final String[] STUDENT_INPUT = {"(setevalmode \"LAZY\")", "(car (funcall listMToN 2 5))"};
	public static final String[] STUDENT_TO_STRING = {
			"\"LAZY\"",
//			"2",
			"2"
			};
	public static final String[] STUDENT_EXPECTED_EVALUATOR_STRINGS = {
			"2"
			};
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

	protected String[] listenableEvaluatorsArray() {
		return new String[] {"print"};
	}
	@Override
	protected String[] expectedEvaluatorOutput() {
		// TODO Auto-generated method stub
		return STUDENT_EXPECTED_EVALUATOR_STRINGS;
	}
	
}
