package gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers;

import java.util.List;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f19.assignment4.requiredClasses.LoadLispChecker;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public abstract class AbstractFunctionLambdaChecker extends PassFailJUnitTestCase {
	protected abstract String functionName();
	protected abstract int argNum();
	protected abstract String result();
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
		boolean vars = false;
		if(anInputSExpression instanceof Atom)
		{
			return false;
		}
		if(anInputSExpression.getHead() instanceof Atom)
		{
			return false;
		}
		boolean funName = aFunctionName.equals(anInputSExpression.getHead().getHead().toString()) ;
		SExpression aTail = anInputSExpression.getTail();
		for (int i = 0; i < argNum(); i++) {
			if(aTail instanceof Atom)
			{
				return false;
			}
			aTail = aTail.getTail();
		}
		vars = (aTail instanceof NilAtom);
		return funName&&vars;
//		if (anInputSExpression instanceof Atom)
//		{
//			return aFunctionName.equals(anInputSExpression.toString());
//		}
//		else {
//			return (equal(anInputSExpression.getHead()) || equal(anInputSExpression.getTail()));
//		}

	}

	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		LoadLispChecker aLoadChecker = (LoadLispChecker) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(LoadLispChecker.class);
		List<SExpression> anInputSExpressions = aLoadChecker.getInputSExpressions();
		List<SExpression> aResultSExpressions = aLoadChecker.getResultSExpressions();
		String aMessage = null;
		String aFunctionName = functionName();
		String aResult = result();
		for (int i = 0; i < anInputSExpressions.size()-1; i++) {
			 aMessage = check(anInputSExpressions.get(i+1), aResultSExpressions.get(i));
			 if(aMessage.isEmpty() && aResultSExpressions.get(i).toString().equals(aResult))
			 {
				 return pass();
			 }
		}
		return fail("Expecting in test file a call to " + aFunctionName +" takes " + argNum()+ " parameters with result " + result());
	}

}
