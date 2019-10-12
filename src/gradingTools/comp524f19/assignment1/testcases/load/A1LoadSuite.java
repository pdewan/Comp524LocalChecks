package gradingTools.comp524f19.assignment1.testcases.load;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestLispFileProvided.class,
	LoadChecker.class,
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
public class A1LoadSuite {
	
}
