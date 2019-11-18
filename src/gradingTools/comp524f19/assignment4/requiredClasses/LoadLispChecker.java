package gradingTools.comp524f19.assignment4.requiredClasses;

import grader.basics.junit.JUnitTestsEnvironment;
import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionLastResultChecker;

public class LoadLispChecker extends AbstractLispExpressionLastResultChecker {
//	public static final String[] STUDENT_OUtPUT = {"\"(2 3 4)\""};
	public static final String[] STUDENT_OUtPUT = {"T"};
//	public static final String[] GRADER_TO_STRING = {"(2 . 5)"};
	@Override
	protected String[] expectedStudentOutput() {
		return STUDENT_OUtPUT;
		
	}
	@Override
	protected String[] expectedGraderOutput() {
		return expectedStudentOutput();
	}
	@Override
	protected String[] studentInputLines() {
		TestLispFileProvided aTestFileProvided = (TestLispFileProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(TestLispFileProvided.class);
		String aLispFileName = aTestFileProvided.getLispFileName();
		return new String[] {"(load \"" + aLispFileName + "\")"};//,"(funcall toStringAsList (List 2 3 4))"};
	}
	@Override
	protected String[] graderInputLines() {
		// TODO Auto-generated method stub
		return studentInputLines();
	}

	
}
