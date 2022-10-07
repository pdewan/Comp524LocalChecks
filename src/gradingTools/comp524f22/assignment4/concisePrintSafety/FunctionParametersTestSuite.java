package gradingTools.comp524f22.assignment4.concisePrintSafety;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment3.functionParamaters.ListPrintSafety;
import gradingTools.comp524f20.assignment3.functionParamaters.MatchingDerivedSafe;
import gradingTools.comp524f20.assignment3.functionParamaters.MatchingGivenSafe;
import gradingTools.comp524f20.assignment3.functionParamaters.MatchingSafe;
import gradingTools.comp524f20.assignment3.functionParamaters.PrintSafety;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	PrintSafety.class,
	ConcisePrintSafetyTest.class,
	ListPrintSafety.class,
	
	MatchingSafe.class,
	MatchingGivenSafe.class,
	MatchingDerivedSafe.class
})
	

//@MaxValue(10)
public class FunctionParametersTestSuite {

	public static void main (String[] args) {
		try {

			BasicJUnitUtils.interactiveTest(FunctionParametersTestSuite.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
