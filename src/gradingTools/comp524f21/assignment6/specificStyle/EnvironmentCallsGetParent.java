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
public class EnvironmentCallsGetParent extends CheckstyleMethodCalledTestCase{
	
	@Override
	protected Class[] precedingTests() {
			return IdentifierCallsOptionalGet.prereq;
	}
	
	public EnvironmentCallsGetParent() {
		super("NestedLexicalEnvironment", "main.lisp.evaluator.environment.AbstractEnvironment!getParent:->Environment");
	}
	
}
