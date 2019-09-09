package gradingTools.comp524f19.assignment1.testcases.load;

import java.util.List;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import main.lisp.parser.terms.SExpression;

public abstract class AbstractFunctionTestedChecker extends PassFailJUnitTestCase {
	protected abstract String functionName();
	protected String check(SExpression anInputSExpression, SExpression aResultSExpression) {
		String aFunctionName = functionName();
		boolean aSuccess = aFunctionName.equals(anInputSExpression.getHead().toString());
		if (!aSuccess) {
			return "Expecting in test file a call to " + aFunctionName;
		}
		return "";
	}

	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		LoadChecker aLoadChecker = (LoadChecker) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(LoadChecker.class);
		List<SExpression> anInputSExpressions = aLoadChecker.getInputSExpressions();
		List<SExpression> aResultSExpressions = aLoadChecker.getResultSExpressions();
		String aMessage = null;
		for (int i = 0; i < anInputSExpressions.size(); i++) {
			 aMessage = check(anInputSExpressions.get(i), aResultSExpressions.get(i));
			 if (aMessage.isEmpty()) {
				 return pass();
			 }
		}
		return fail(aMessage);
	}

}
