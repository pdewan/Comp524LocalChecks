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
public class LambdaCallsLambdaFactory extends CheckstyleMethodCalledTestCase{
	
	protected static final Class[] prereq= {
			LispLambdaChecker.class,
			LispLambdaChecker2.class,
			LispLambdaChecker3.class,
			LoadLambdaChecker.class,
			LoadLambdaChecker2.class,
			LoadLambdaChecker3.class
	};
	
	@Override
	protected Class[] precedingTests() {
			return prereq;
	}
	
	public LambdaCallsLambdaFactory() {
		super("LambdaEvaluator", "main.lisp.evaluator.function.LambdaFactory!newInstance:main.lisp.parser.terms.IdentifierAtom\\[\\];main.lisp.parser.terms.SExpression-\\>Lambda");
	}
	
}
