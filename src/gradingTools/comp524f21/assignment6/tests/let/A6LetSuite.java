package gradingTools.comp524f21.assignment6.tests.let;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment3.testcases.LetCheckers.LetGeneratedNumAtomChecker;
import gradingTools.comp524f19.assignment3.testcases.LetCheckers.LetGeneratedToStringChecker;
import util.annotations.IsExtra;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	LetLambdaAndFunctionTest.class,
	BasicLetTest.class
	
})
	
@IsExtra(true)
public class A6LetSuite {
	
}
