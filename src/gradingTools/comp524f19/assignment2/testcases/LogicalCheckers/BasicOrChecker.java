package gradingTools.comp524f19.assignment2.testcases.LogicalCheckers;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(10)
@Explanation("Checks if OR works for the basic case")
public class BasicOrChecker extends AbstractLispExpressionResultChecker {
	public static final String[] STUDENT_INPUT = {"(or (= 1 2) (+ 3 3))"};
	public static final String[] STUDENT_TO_STRING = {"6"};
	public static final String[] GRADER_INPUT = {"(or t 3)"};
	public static final String[] GRADER_TO_STRING = {"T"};
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
