package gradingTools.comp524f20.assignment6.testcases.socialDistance;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LoadLispChecker;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.TestLispFileProvided;
import util.annotations.IsExtra;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	SafetyTableChecker.class,
	DerivedSafeChecker.class
	
})
	
@IsExtra(true)
public class FuncallSocialDistanceSuite {
	
}
