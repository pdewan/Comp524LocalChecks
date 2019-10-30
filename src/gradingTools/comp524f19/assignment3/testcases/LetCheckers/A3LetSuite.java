package gradingTools.comp524f19.assignment3.testcases.LetCheckers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LoadLispChecker;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.TestLispFileProvided;
import util.annotations.IsExtra;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestLispFileProvided.class,
	LoadLispChecker.class,
	LetGeneratedNumAtomChecker.class,
	LetGeneratedToStringChecker.class

	
})
	
@IsExtra(true)
public class A3LetSuite {
	
}
