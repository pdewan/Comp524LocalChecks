package gradingTools.comp524f19.assignment4.testcases.SideEffectsCheckers;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(20)
@IsExtra(true)
public class SideEffectsChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(progn" , 
			"(setq OUTN" , 
			"(progn" , 
			"(setq A 10)" , 
			"(setevalmode \"NORMAL\")" , 
			"(funcall optimizeAtYourPeril (setq A (+ A 3))  (setq A (+ A 7)))  " , 
			")" , 
			")" , 
			"(setq OUTE" , 
			"(progn" , 
			"(setevalmode \"EAGER\")" , 
			"(setDeepCopyEagerEnvironment T)" , 
			"(setq A 10)" , 
			"(funcall optimizeAtYourPeril (setq A (+ A 3))  (setq A (+ A 7)))" , 
			")" , 
			")" , 
			"(setq OUTL" , 
			"(progn" , 
			"(setevalmode \"LAZY\")" , 
			"(setq A 10)" , 
			"(funcall optimizeAtYourPeril (setq A (+ A 3))  (setq A (+ A 7)))" , 
			")" , 
			")" , 
			"(or (or (= OUTE OUTN) (= OUTN OUTL)) (= OUTE OUTL))" , 
			")"};
	public static final String[] STUDENT_TO_STRING = {"NIL"};
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
