package gradingTools.comp524f19.assignment1.testcases.loadLogical;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestLispFileProvided.class,
	LoadChecker.class,
	AndTestedChecker.class,
	AndTestedTwoResultsChecker.class,
	NotTestedChecker.class,
	NotTestedTwoResultsChecker.class,
	OrTestedChecker.class,
	OrTestedTwoResultsChecker.class
	
})
	

//@MaxValue(50)
public class A1LoadLogicalSuite {
	
}
