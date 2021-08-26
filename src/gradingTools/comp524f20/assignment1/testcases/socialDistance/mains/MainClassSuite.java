package gradingTools.comp524f20.assignment1.testcases.socialDistance.mains;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import util.trace.Tracer;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	BasicMainTest.class,
	InterpolatingMainTest.class,
	DerivingMainTest.class,
	InferringMainTest.class,
	UtilityTesterMainTest.class
	
})
	

//@MaxValue(50)
public class MainClassSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(MainClassSuite.class);
			Tracer.setKeywordPrintStatus(BasicMainTest.class, true);
			Tracer.setKeywordPrintStatus(InterpolatingMainTest.class, true);
			Tracer.setKeywordPrintStatus(DerivingMainTest.class, true);
			Tracer.setKeywordPrintStatus(InferringMainTest.class, true);
			Tracer.setKeywordPrintStatus(UtilityTesterMainTest.class, true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
