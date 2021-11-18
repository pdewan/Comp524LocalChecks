package gradingTools.comp524f21.assignment6.specificStyle;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LispLambdaChecker;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LispLambdaChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LispLambdaChecker3;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LoadLambdaChecker;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LoadLambdaChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LoadLambdaChecker3;
import util.annotations.MaxValue;
@MaxValue(2)
//@IsExtra(true)
public class FuncallCallsExpressionFactory extends CheckstyleMethodCalledTestCase{
	
	@Override
	protected Class[] precedingTests() {
			return LambdaCallsLambdaFactory.prereq;
	}
	
	public FuncallCallsExpressionFactory() {
		super("BasicFuncallEvaluator", "main.lisp.parser.terms.ExpressionFactory!newInstance:main.lisp.parser.terms.SExpression;main.lisp.parser.terms.SExpression->SExpression");
	}
	
}
