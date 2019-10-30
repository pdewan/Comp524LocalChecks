package gradingTools.comp524f19.assignment3.testcases.FunctionExpressionsCheckers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LoadLispChecker;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.TestLispFileProvided;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestLispFileProvided.class,
	LoadLispChecker.class,
	FunExpTraverseGenChecker.class,
	FunExpTraverseGenChecker2.class,
	FunExpGeneratedNumAtomChecker.class,
	FunExpGeneratedToStringChecker.class

	
})
	

public class A3FunctionExpressionsSuite {
	
}
