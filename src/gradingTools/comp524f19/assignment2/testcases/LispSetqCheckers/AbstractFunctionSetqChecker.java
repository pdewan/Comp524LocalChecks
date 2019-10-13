package gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers;

import java.util.List;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LoadLispChecker;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.SExpression;
import util.trace.Tracer;

public abstract class AbstractFunctionSetqChecker extends PassFailJUnitTestCase {
	protected abstract String functionName();
	protected abstract String arg0();
	protected abstract String arg1();
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
		String anArg0 = arg0();
		String anArg1 = arg1();
		if(anInputSExpression instanceof Atom)
		{
			return aFunctionName.equals(anInputSExpression.toString());
		}
		boolean funName = aFunctionName.equals(anInputSExpression.getHead().toString()) ;
		boolean headName =anArg0.equals(anInputSExpression.getTail().getHead().toString());
		boolean tailName = anArg1.equals(anInputSExpression.getTail().getTail().getHead().toString());
		return (funName&&headName&&tailName);
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
		return fail("Expecting in test file a call to ( " + aFunctionName + " " + arg0() + " " + arg1() + ") with result " + result());
	}

}
