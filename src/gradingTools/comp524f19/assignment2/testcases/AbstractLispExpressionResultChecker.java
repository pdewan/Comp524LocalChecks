package gradingTools.comp524f19.assignment2.testcases;

import java.util.List;

import grader.basics.execution.BasicProjectExecution;
import main.LispInterpreterSettings;
import main.lisp.evaluator.lazy.Thunk;
import util.trace.Tracer;

public abstract class AbstractLispExpressionResultChecker extends AbstractLispExpressionChecker {
	public static final String DEFAULT_INPUT_SEPARATOR = "\n";

	protected  String actualOutput() {
		return toString(resultSExpressions);
	}
	public String toString (Object anObject) {
		boolean oldPrintEvals = LispInterpreterSettings.doesThunkPrintEval();
		LispInterpreterSettings.setThunkPrintEvals(true);
		if (anObject instanceof Thunk) {
			return ((Thunk) anObject).eval(null).toString();
		}
		String retVal = anObject.toString();
		LispInterpreterSettings.setThunkPrintEvals(oldPrintEvals);
		return retVal;

	}
	public  String toString( List aList) {
		String retVal = "";
		for (int i = 0; i < aList.size(); i++) {
			if (i > 0) {
				retVal += DEFAULT_INPUT_SEPARATOR;
			}
			retVal += toString(aList.get(i));
		}
		return retVal;
	}

//	@Override
//	public TestCaseResult test(Project project, boolean autoGrade)
//			throws NotAutomatableException, NotGradableException {
//		try {
////		SExpression anExpression = evaluate("(cons 5 2)");
//			return (compareOutput(resultSExpressions));
//			
//		} catch (Throwable e) {
//			e.printStackTrace();
//			return fail(e.getMessage());
//		}
//		
//	}
}
