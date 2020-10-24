package gradingTools.comp524f20.assignment3.functionParamaters;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment3.listsAndRecursion.ListDerivedSafeSML;
import util.annotations.MaxValue;
import util.trace.Tracer;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	PrintSafety.class,
	ConcisePrintSafety.class,
	ListPrintSafety.class,
	
	MatchingSafe.class,
	MatchingGivenSafe.class,
	MatchingDerivedSafe.class
})
	

//@MaxValue(10)
public class FunctionParametersTestSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(FunctionParametersTestSuite.class);
			Tracer.setKeywordPrintStatus(PrintSafety.class, true);
			Tracer.setKeywordPrintStatus(ConcisePrintSafety.class, true);
			Tracer.setKeywordPrintStatus(ListPrintSafety.class, true);
			
			Tracer.setKeywordPrintStatus(MatchingSafe.class, true);
			Tracer.setKeywordPrintStatus(MatchingGivenSafe.class, true);
			Tracer.setKeywordPrintStatus(MatchingDerivedSafe.class, true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
