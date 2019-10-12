package gradingTools.comp524f19.assignment2.testcases;

import grader.basics.execution.BasicProjectExecution;

public abstract class AbstractLispExpressionResultChecker extends AbstractLispExpressionChecker {
	protected  String actualOutput() {
		return BasicProjectExecution.toString(resultSExpressions);
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
