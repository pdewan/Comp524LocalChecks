package gradingTools.comp524f19.assignment1.testcases.load;

import java.util.List;

import com.sun.org.apache.xpath.internal.operations.And;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public abstract class AbstractFunctionTestedTwoResultsChecker extends PassFailJUnitTestCase {
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
		LoadChecker aLoadChecker = (LoadChecker) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(LoadChecker.class);
		List<SExpression> anInputSExpressions = aLoadChecker.getInputSExpressions();
		List<SExpression> aResultSExpressions = aLoadChecker.getResultSExpressions();
		String aMessage = null;
		String firstResult = null;
		String aFunctionName = functionName();
		boolean flag = false;
		for (int i = 0; i < anInputSExpressions.size()-1; i++) {
			 aMessage = check(anInputSExpressions.get(i+1), aResultSExpressions.get(i));
			 if (aMessage.isEmpty() && !flag) {
				 firstResult = aResultSExpressions.get(i).toString();
				 flag =  true;
				 System.out.println("Found the first result of " + functionName() + " : " + anInputSExpressions.get(i+1).toString() + " with result " + firstResult);
			 }
			 else if (aMessage.isEmpty() && flag) {
				 String secondResult = aResultSExpressions.get(i).toString();
				 if(!secondResult.equals(firstResult))
				 {
					 System.out.println("Found the second result of " + functionName() + " : " + anInputSExpressions.get(i+1).toString() + " with result " + secondResult);
					 return pass();
				 }
			}
		}
		return fail("Expecting in test file two results of " + aFunctionName);
	}

}
