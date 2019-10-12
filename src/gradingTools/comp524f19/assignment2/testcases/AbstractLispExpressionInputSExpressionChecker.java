package gradingTools.comp524f19.assignment2.testcases;

import grader.basics.execution.BasicProjectExecution;

public abstract class AbstractLispExpressionInputSExpressionChecker extends AbstractLispExpressionChecker {
	protected  String actualOutput() {
		return BasicProjectExecution.toString(inputSExpressions);
	}

//	@Override
//	public TestCaseResult test(Project project, boolean autoGrade)
//			throws NotAutomatableException, NotGradableException {
//		try {
////		SExpression anExpression = evaluate("(cons 5 2)");
//			evaluate();
//			return (compareOutput(inputSExpressions));
//			
//		} catch (Throwable e) {
//			e.printStackTrace();
//			return fail(e.getMessage());
//		}
//		
//	}
}
