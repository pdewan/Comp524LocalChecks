package gradingTools.comp524f19.assignment3.testcases.FunctionExpressionsCheckers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment4.requiredClasses.LoadLispChecker;
import gradingTools.comp524f19.assignment4.requiredClasses.TestLispFileProvided;

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
