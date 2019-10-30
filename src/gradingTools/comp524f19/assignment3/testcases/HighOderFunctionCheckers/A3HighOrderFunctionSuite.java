package gradingTools.comp524f19.assignment3.testcases.HighOderFunctionCheckers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LoadLispChecker;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.TestLispFileProvided;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestLispFileProvided.class,
	LoadLispChecker.class,
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
	

public class A3HighOrderFunctionSuite {
	
}
