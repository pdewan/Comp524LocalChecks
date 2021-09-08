package gradingTools.comp524f21.assignment2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.BasicMainTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.DerivingMainTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.InferringMainTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.InterpolatingMainTest;
import util.trace.Tracer;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	BasicMainTest.class,
	InterpolatingMainTest.class,
	DerivingMainTest.class,
	InferringMainTest.class,
	
})
	

//@MaxValue(50)
public class F21A2MainClassSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F21A2MainClassSuite.class);
			Tracer.setKeywordPrintStatus(BasicMainTest.class, true);
			Tracer.setKeywordPrintStatus(InterpolatingMainTest.class, true);
			Tracer.setKeywordPrintStatus(DerivingMainTest.class, true);
			Tracer.setKeywordPrintStatus(InferringMainTest.class, true);
//			Tracer.setKeywordPrintStatus(UtilityTesterMainTest.class, true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
