package gradingTools.comp524f20.assignment3.functionReturnValues;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment3.functionParamaters.PrintSafety;
import util.annotations.MaxValue;
import util.trace.Tracer;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	CurriedOnceInterpolatedSafe.class,
	CurriedTwiceInterpolatedSafe.class,
	CurryableInterpolatedSafe.class,
	
	CurryableMatchingSafe.class,
	CurriedMatchingDerivedSafe.class,
	CurriedMatchingGivenSafe.class
	
})
	

//@MaxValue(10)
public class FunctionReturnValuesTestSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(FunctionReturnValuesTestSuite.class);

//			Tracer.setKeywordPrintStatus(CurriedOnceInterpolatedSafe.class, true);
//			Tracer.setKeywordPrintStatus(CurriedTwiceInterpolatedSafe.class, true);
//			Tracer.setKeywordPrintStatus(CurryableInterpolatedSafe.class, true);
//			
//			Tracer.setKeywordPrintStatus(CurryableMatchingSafe.class, true);
//			Tracer.setKeywordPrintStatus(CurriedMatchingDerivedSafe.class, true);
//			Tracer.setKeywordPrintStatus(CurriedMatchingGivenSafe.class, true);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
