package gradingTools.comp524f19.assignment4.lazy;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.GradingMode;
import grader.basics.junit.TestCaseResult;
import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import gradingTools.interpreter.checkers.ADiffPatchChecker;
import gradingTools.interpreter.checkers.CheckerResult;
import main.LispInterpreterSettings;
import main.lisp.evaluator.lazy.Thunk;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(30)
@IsExtra(true)
public class ListMToNCdrLazyEval extends AbstractEvaluatorAndResultChecker {
	public static final String[] STUDENT_INPUT = {"(setevalmode \"LAZY\")", "(cdr (funcall listMToN 2 5))"};
	public static final String[] STUDENT_TO_STRING = {
			"\"LAZY\"",
//			"2",
			"(3 (4 (5))"
			};
	public static final String[] STUDENT_EXPECTED_EVALUATOR_STRINGS = {
			"3",
			"4",
			"5"
			};
	public static final String THUNK_STRING_PREFIX = "(Thunk: [(FUNCALL LISTMTON (";
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
	protected TestCaseResult compareOutput() {
		try {
//			SExpression anExpression = evaluate("(cons 5 2)");
				evaluate();
//				String anActualOutput = BasicProjectExecution.toString(anOutput);
				String anActualOutput = actualOutput();
				
				if (!anActualOutput.contains(THUNK_STRING_PREFIX)) {
					return fail ("tostring() of list cdr should contain:" +THUNK_STRING_PREFIX );
				}
				return pass();

				
			} catch (Throwable e) {
				e.printStackTrace();
				return fail(e.getMessage());
			}
	}
	public String toString (Object anObject) {
		
		String retVal = anObject.toString();
		return retVal;

	}
	
}
