package gradingTools.comp524f19.assignment1.testcases.loadLogical;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
//import gradingTools.comp524f19.assignment4.requiredClasses.TestLispFileProvided;
//import gradingTools.comp524f19.assignment4.requiredClasses.LoadLispChecker;

@RunWith(Suite.class)
@Suite.SuiteClasses({
//	TestLispFileProvided.class,
//	LoadChecker.class,
//	LoadLispChecker.class,
	AndTestedChecker.class,
	AndTestedTwoResultsChecker.class,
	NotTestedChecker.class,
	NotTestedTwoResultsChecker.class,
	OrTestedChecker.class,
	OrTestedTwoResultsChecker.class
	
})
	

//@MaxValue(50)
public class LispInterpreterLoadLogicalSuite {
	
}
