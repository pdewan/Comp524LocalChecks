package gradingTools.comp524f20.assignment5.testcases.toString;

import gradingTools.comp524f19.assignment1.testcases.AbstractLispExpressionChecker;

public abstract class AbstractLispExpressionResultDeepChecker extends AbstractLispExpressionChecker {
	protected  String actualOutput() {		
		return resultSExpressions.get(0).toStringAsSExpressionDeep();
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
