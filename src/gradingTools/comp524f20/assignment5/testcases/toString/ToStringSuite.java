package gradingTools.comp524f20.assignment5.testcases.toString;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment1.testcases.toString.BaseCaseListToStringChecker;
import gradingTools.comp524f19.assignment1.testcases.toString.BaseCaseSExpressionToStringChecker;
import gradingTools.comp524f19.assignment1.testcases.toString.ListToStringChecker;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	BaseCaseSExpressionToStringChecker.class,
	BaseCaseListToStringChecker.class,
	ListToStringChecker.class,
	ListToStringDeepChecker.class
	
})
	

public class ToStringSuite {
	
}
