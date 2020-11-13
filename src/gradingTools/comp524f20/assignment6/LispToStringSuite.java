package gradingTools.comp524f20.assignment6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispIsListChecker;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispIsListChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispIsListChecker3;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispIsListChecker4;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispToStringChecker;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispToStringChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispToStringChecker3;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispToStringChecker4;
import gradingTools.comp524f19.assignment4.requiredClasses.LoadLispChecker;
import gradingTools.comp524f19.assignment4.requiredClasses.TestLispFileProvided;
import util.annotations.IsExtra;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestLispFileProvided.class,
	LoadLispChecker.class,
	LispIsListChecker.class,
	LispIsListChecker2.class,
	LispIsListChecker3.class,
	LispIsListChecker4.class,
	LispToStringChecker.class,
	LispToStringChecker2.class,
	LispToStringChecker3.class,
	LispToStringChecker4.class
	
})
	
@IsExtra(true)
public class LispToStringSuite {
	
}
