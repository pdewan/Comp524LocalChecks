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
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import sun.print.resources.serviceui;
import util.trace.Tracer;

public abstract class AbstractFunctionTestedCondChecker extends PassFailJUnitTestCase {
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
	protected SExpression tail(SExpression anInputSExpression) {
		if(anInputSExpression.getTail() instanceof NilAtom)
		{
			return anInputSExpression.getHead().getTail().getHead();
		}
		else {
			return tail(anInputSExpression.getTail());
		}
	}
	
	protected String getString(SExpression anInputSExpression)
	{
		if(anInputSExpression.getHead() instanceof IdentifierAtom)
		{
			return anInputSExpression.eval(null).toString();
		}
		else
		{
			return anInputSExpression.getHead().toString();
		}
	}

	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		LoadChecker aLoadChecker = (LoadChecker) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(LoadChecker.class);
		List<SExpression> anInputSExpressions = aLoadChecker.getInputSExpressions();
		List<SExpression> aResultSExpressions = aLoadChecker.getResultSExpressions();
		String aMessage = null;
		String aFunctionName = functionName();
		String reString = null;
		boolean flagf = false;
		boolean flagl = false;
		boolean flage = false;
		boolean flag3 = false;
		for (int i = 0; i < anInputSExpressions.size()-1; i++) {
			 aMessage = check(anInputSExpressions.get(i+1), aResultSExpressions.get(i));
			 reString = aResultSExpressions.get(i).toString();
			 if (aMessage.isEmpty()) {
				 SExpression search = anInputSExpressions.get(i+1).getTail();
				 int count = 1;
				 while(!(search.getTail() instanceof NilAtom))
				 {
					 count = count+1;
					 search = search.getTail();
				 }
				 if(count<3) {
					 continue;
				 }
				 else {
					 flag3 = true;
				 }
				 search = anInputSExpressions.get(i+1).getTail();
				 String tailString = getString(tail(search));
				 String headString = getString(search.getHead().getTail().getHead());
				 if(tailString.equals(reString) && !flagl) {
					 flagl = true;
					 Tracer.info(this, "Found a result of " + functionName() + " : " + anInputSExpressions.get(i+1).toString() + " with the last case " + reString );
					 //System.out.println("Found a result of " + functionName() + " : " + anInputSExpressions.get(i+1).toString() + " with the last case " + reString);
				 }
				 else if(headString.equals(reString) && !flagf) {
					 flagf = true;
					 Tracer.info(this, "Found a result of " + functionName() + " : " + anInputSExpressions.get(i+1).toString() + " with the first case " + reString);
					 //System.out.println("Found a result of " + functionName() + " : " + anInputSExpressions.get(i+1).toString() + " with the first case " + reString);
				 }
				 else if(!flage&!headString.equals(reString)&!tailString.equals(reString))
				 {
					 flage = true;
					 Tracer.info(this, "Found a result of " + functionName() + " : " + anInputSExpressions.get(i+1).toString() + " with other case " + reString);
					 //System.out.println("Found a result of " + functionName() + " : " + anInputSExpressions.get(i+1).toString() + " with other case " + reString);
					
//					 search = search.getTail();
//					 while(!(search.getTail() instanceof NilAtom)) {
//						 String chString = getString(search.getHead().getTail().getHead());
//						 if(chString.equals(reString)){
//							 flage = true;
//							 break;
//						 }
//						 else {
//							 search = search.getTail();
//						 }
//					 }
				 }
				 
				 if(flagf&&flage&&flagl&&flag3) {
					 return pass();
				 }
			 }

		}
		return fail("Expecting in test file 3 or more results of " + aFunctionName + "with 3 or more cases");
	}

}