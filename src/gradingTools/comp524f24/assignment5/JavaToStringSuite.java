package gradingTools.comp524f24.assignment5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment1.testcases.toString.BaseCaseListToStringChecker;
import gradingTools.comp524f19.assignment1.testcases.toString.BaseCaseSExpressionToStringChecker;
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
import gradingTools.comp524f21.assignment5.toString.ListToStringCheckerAdvanced;
import gradingTools.comp524f21.assignment5.toString.ListToStringCheckerBasic;
import gradingTools.comp524f21.assignment5.toString.ListToStringDeepCheckerAdvanced;
import gradingTools.comp524f21.assignment5.toString.ListToStringDeepCheckerBasic;
import util.annotations.IsExtra;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	BaseCaseSExpressionToStringChecker.class,
	BaseCaseListToStringChecker.class,
	ListToStringCheckerBasic.class,
	ListToStringCheckerAdvanced.class,
	ListToStringDeepCheckerBasic.class,
	ListToStringDeepCheckerAdvanced.class,
	
})
	
public class JavaToStringSuite {
	
}
