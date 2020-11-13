package gradingTools.comp524f20.assignment6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment3.testcases.HighOderFunctionCheckers.DotCatChecker;
import gradingTools.comp524f19.assignment3.testcases.HighOderFunctionCheckers.FunArgNumAtomChecker;
import gradingTools.comp524f19.assignment3.testcases.HighOderFunctionCheckers.FunArgNumAtomGenChecker;
import gradingTools.comp524f19.assignment3.testcases.HighOderFunctionCheckers.FunArgToStringChecker;
import gradingTools.comp524f19.assignment3.testcases.HighOderFunctionCheckers.FunArgToStringGenChecker;
import gradingTools.comp524f19.assignment3.testcases.HighOderFunctionCheckers.OneChecker;
import gradingTools.comp524f19.assignment3.testcases.HighOderFunctionCheckers.SumChecker;
import gradingTools.comp524f19.assignment3.testcases.HighOderFunctionCheckers.TraverseChecker;
import gradingTools.comp524f19.assignment3.testcases.HighOderFunctionCheckers.WriteToStringChecker;


@RunWith(Suite.class)
@Suite.SuiteClasses({
//	TestLispFileProvided.class,
//	LoadLispChecker.class,
	DotCatChecker.class,
	OneChecker.class,
	SumChecker.class,
	WriteToStringChecker.class,
	TraverseChecker.class,
	FunArgNumAtomChecker.class,
	FunArgNumAtomGenChecker.class,
	FunArgToStringChecker.class,
	FunArgToStringGenChecker.class

	
})
	

public class HighOrderFunctionSuite {
	
}
