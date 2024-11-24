package gradingTools.comp524f24.assignment6;

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
import gradingTools.comp524f21.assignment6.style.A6CommonPropertiesInherited;
import gradingTools.comp524f21.assignment6.style.A6CommonSignaturesAreInherited;
import gradingTools.comp524f21.assignment6.style.A6Encapsulation;
import gradingTools.comp524f21.assignment6.style.A6NoHiddenFields;
import gradingTools.comp524f21.assignment6.style.A6NoStarImports;
import gradingTools.comp524f21.assignment6.style.A6NonPublicAccessModifiersMatched;
import gradingTools.comp524f21.assignment6.style.A6PackageDeclarations;
import gradingTools.comp524f21.assignment6.style.A6PublicMethodsOverride;
import gradingTools.comp524f21.assignment6.style.F21A6NoCheckstyleWarnings;
import util.annotations.IsExtra;

@RunWith(Suite.class)
@Suite.SuiteClasses({
A6CommonPropertiesInherited.class,
A6CommonSignaturesAreInherited.class,
A6Encapsulation.class,
//A5InterfaceAsType.class,
A6NoHiddenFields.class,
A6NonPublicAccessModifiersMatched.class,
A6PublicMethodsOverride.class,
A6NoStarImports.class,
A6PackageDeclarations.class,
F21A6NoCheckstyleWarnings.class,
//ProjectMatchesTemplate.class,
	
})
	
public class A6GeneralStyleSuite {
	
}
