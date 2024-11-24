package gradingTools.comp524f19.assignment1.testcases.load;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment4.requiredClasses.LoadLispChecker;


@RunWith(Suite.class)
@Suite.SuiteClasses({
//	TestLispFileProvided.class,
//	LoadChecker.class,
	LoadLispChecker.class,
	ConsTestedChecker.class,
	QuoteTestedChecker.class,
	ListTestedChecker.class,
	EvalTestedChecker.class,
	CondTestedChecker.class,
	ConsTestedTwoResultsChecker.class,
	QuoteTestedTwoResultsChecker.class,
	ListTestedTwoResultsChecker.class,
	EvalTestedTwoResultsChecker.class,
	CondTestedResultsChecker.class
	
})
	

//@MaxValue(50)
public class LispInterpreterLoadSuite {
	
}
