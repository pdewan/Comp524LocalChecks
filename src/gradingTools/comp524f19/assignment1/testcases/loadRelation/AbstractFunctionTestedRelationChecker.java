package gradingTools.comp524f19.assignment1.testcases.loadRelation;

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
import util.trace.Tracer;

public abstract class AbstractFunctionTestedRelationChecker extends PassFailJUnitTestCase {
	protected abstract String functionName();
	protected String check(SExpression anInputSExpression, SExpression aResultSExpression) {
		String aFunctionName = functionName();
		if(equal(anInputSExpression)) {
			return "";
		}
		else {
			return "Expecting in test file a call to " + aFunctionName;
		}
		
		
	}
	protected boolean equal(SExpression anInputSExpression){
		String aFunctionName = functionName();
		if (anInputSExpression instanceof Atom)
		{
			return aFunctionName.equals(anInputSExpression.toString());
		}
		else {
			return (equal(anInputSExpression.getHead()) || equal(anInputSExpression.getTail()));
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
		for (int i = 0; i < anInputSExpressions.size(); i++) {
			 aMessage = check(anInputSExpressions.get(i), aResultSExpressions.get(i));
			 if (aMessage.isEmpty()) {
				 //System.out.println("Found a call to " + functionName() + " : " + anInputSExpressions.get(i).toString());
				 Tracer.info(this, "Found a call to " + functionName() + " : " + anInputSExpressions.get(i).toString());
				 return pass();
			 }
		}
		return fail(aMessage);
	}

}
