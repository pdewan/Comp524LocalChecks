package gradingTools.comp524f21.assignment6.testCases.basicOperations;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.CombinationChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.CondChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.EvalChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.ListChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.ListChecker2;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.QuoteChecker;


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
	

public class A6BasicOperationSuite {
	
}
