package gradingTools.comp524f20.assignment6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment4.requiredClasses.LoadLispChecker;
import gradingTools.comp524f19.assignment4.requiredClasses.TestLispFileProvided;
import gradingTools.comp524f19.assignment4.testcases.CurryCheckers.CurriedNumAtomChecker;
import gradingTools.comp524f19.assignment4.testcases.CurryCheckers.CurriedToStringChecker;
import util.annotations.IsExtra;


@RunWith(Suite.class)
@Suite.SuiteClasses({
//	TestLispFileProvided.class,
//	LoadLispChecker.class,
	CurriedNumAtomChecker.class,
	CurriedToStringChecker.class

	
})
	
@IsExtra(true)
public class ToStringAtomCurrySuite {
	
}
