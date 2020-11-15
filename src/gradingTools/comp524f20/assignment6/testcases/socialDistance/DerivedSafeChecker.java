package gradingTools.comp524f20.assignment6.testcases.socialDistance;

import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import util.annotations.MaxValue;
@MaxValue(30)
public class DerivedSafeChecker extends AbstractLispExpressionResultChecker {
	public static String[] STUDENT_INPUT = null;
	public static String[] STUDENT_TO_STRING = null;
//	public static final String[] GRADER_INPUT = {"(list \"this is a not test\")"};
//	public static final String[] GRADER_TO_STRING = {"NIL"};
	@Override
	protected String[] expectedStudentOutput() {
		return getStudentToString();
	}
	@Override
	protected String[] expectedGraderOutput() {
		return getStudentToString();
	}
	@Override
	protected String[] studentInputLines() {
		return getStudent_Input();
	}
	@Override
	protected String[] graderInputLines() {
		// TODO Auto-generated method stub
		return getStudent_Input();
	}
	
	private String [] getStudent_Input() {
		if(STUDENT_INPUT==null) {
			STUDENT_INPUT = (new ATestGetableLispProject()).getTests();
		}
		return STUDENT_INPUT;
	}
	private String [] getStudentToString() {
		if(STUDENT_TO_STRING==null) {
			STUDENT_TO_STRING=(new ATestGetableLispProject()).getExpectedAnswers();
		}
		return STUDENT_TO_STRING;
	}
	
}
