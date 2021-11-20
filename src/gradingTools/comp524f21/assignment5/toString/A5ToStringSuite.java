package gradingTools.comp524f21.assignment5.toString;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment1.testcases.toString.BaseCaseListToStringChecker;
import gradingTools.comp524f19.assignment1.testcases.toString.BaseCaseSExpressionToStringChecker;
import gradingTools.comp524f19.assignment1.testcases.toString.ListToStringChecker;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	BaseCaseSExpressionToStringChecker.class,
	BaseCaseListToStringChecker.class,
	ListToStringCheckerBasic.class,
	ListToStringCheckerAdvanced.class,
	ListToStringDeepCheckerBasic.class,
	ListToStringDeepCheckerAdvanced.class,
	
})
	

public class A5ToStringSuite {
	
}
