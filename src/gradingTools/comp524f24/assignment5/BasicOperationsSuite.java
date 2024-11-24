package gradingTools.comp524f24.assignment5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.CombinationChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.CondChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.EvalChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.ListChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.ListChecker2;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.QuoteChecker;
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
import gradingTools.comp524f21.assignment6.testCases.basicOperations.A6ExtraCondChecker;
import util.annotations.IsExtra;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CondChecker.class,
	A6ExtraCondChecker.class,
	QuoteChecker.class,
	EvalChecker.class,
	ListChecker.class,
	ListChecker2.class,
	CombinationChecker.class
	
})
	
public class BasicOperationsSuite {
	
}
