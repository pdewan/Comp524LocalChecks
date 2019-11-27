package gradingTools.comp524f19.assignment4.requiredClasses;

import java.io.File;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;

public class LoadFile extends PassFailJUnitTestCase {

	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		try {
			JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(LoadLispChecker.class);
			return pass();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return fail(e.getMessage());
		}
	}

}
