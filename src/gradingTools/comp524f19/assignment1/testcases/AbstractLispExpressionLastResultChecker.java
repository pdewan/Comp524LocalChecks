package gradingTools.comp524f19.assignment1.testcases;

public abstract class AbstractLispExpressionLastResultChecker extends AbstractLispExpressionChecker {
	protected  String actualOutput() {
		return resultSExpressions.get(resultSExpressions.size() - 1).toString();
		
	}

	
}
