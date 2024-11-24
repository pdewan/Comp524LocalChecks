package gradingTools.comp524f19.assignment4.testcases.FunFreeVariablesCheckers;

import java.util.List;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f19.assignment1.testcases.load.LoadChecker;
import gradingTools.comp524f19.assignment4.requiredClasses.LoadLispChecker;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.SExpression;

public abstract class AbstractDefiniationChecker extends PassFailJUnitTestCase {
	protected abstract String functionName();
	protected abstract String lispFunctionName();
	protected String check(SExpression anInputSExpression, SExpression aResultSExpression, String aName) {
		String aFunctionName = aName;
		if(equal(anInputSExpression,aFunctionName)) {
			return "";
		}
		else {
			return "Expecting in test file a call to " + aFunctionName;
		}
		
		
	}
	protected boolean equal(SExpression anInputSExpression, String aName){
		String aFunctionName = aName;
		if (anInputSExpression instanceof Atom)
		{
			return aFunctionName.equals(anInputSExpression.toString());
		}
		else {
			return (equal(anInputSExpression.getHead(),aFunctionName) || equal(anInputSExpression.getTail(),aFunctionName));
		}

	}

	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
//		LoadChecker aLoadChecker = (LoadChecker) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(LoadChecker.class);
		LoadLispChecker aLoadChecker = (LoadLispChecker) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(LoadLispChecker.class);

		List<SExpression> anInputSExpressions = aLoadChecker.getInputSExpressions();
		List<SExpression> aResultSExpressions = aLoadChecker.getResultSExpressions();
		String aMessage = null;
		String bMessage = null;
		String aFunctionName = functionName();
		for (int i = 0; i < anInputSExpressions.size()-1; i++) {
			 aMessage = check(anInputSExpressions.get(i+1), aResultSExpressions.get(i), lispFunctionName());
			 if (aMessage.isEmpty()) {
				 bMessage = check(anInputSExpressions.get(i+1), aResultSExpressions.get(i), functionName());
				 if(bMessage.isEmpty())
				 {
					 return pass();
				 }
			 }
		}
		return fail("Expecting a call to " + aFunctionName + " when defining " + lispFunctionName());
	}

}
