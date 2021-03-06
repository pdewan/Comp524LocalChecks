package gradingTools.comp524f20.assignment6.testcases.functionExpression;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment3.testcases.FunctionExpressionsCheckers.FunExpGeneratedNumAtomChecker;
import gradingTools.comp524f19.assignment3.testcases.FunctionExpressionsCheckers.FunExpGeneratedToStringChecker;
import gradingTools.comp524f19.assignment3.testcases.FunctionExpressionsCheckers.FunExpTraverseGenChecker;
import gradingTools.comp524f19.assignment3.testcases.FunctionExpressionsCheckers.FunExpTraverseGenChecker2;
import gradingTools.comp524f19.assignment4.requiredClasses.LoadLispChecker;
import gradingTools.comp524f19.assignment4.requiredClasses.TestLispFileProvided;
import util.annotations.IsExtra;

@RunWith(Suite.class)
@Suite.SuiteClasses({
TimesGeneratorChecker.class,
PlusGeneratorChecker.class

	
})
	
@IsExtra(true)
public class BasicFunctionExpressionSuite {
	
}
