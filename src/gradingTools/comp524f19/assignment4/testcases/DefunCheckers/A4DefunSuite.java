package gradingTools.comp524f19.assignment4.testcases.DefunCheckers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LoadLispChecker;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.TestLispFileProvided;
import util.annotations.IsExtra;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	CurryableTraverseChecker1.class,
	CurryableTraverseChecker2.class

	
})
	
@IsExtra(true)
public class A4DefunSuite {
	
}
