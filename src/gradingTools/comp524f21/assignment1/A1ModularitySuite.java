package gradingTools.comp524f21.assignment1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.ExpectedSubtleJavaDocs;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.InterpolatedReuse;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.MVCAndFactoryCalls;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.ModelReuse;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.PrintingCodeReuse;


@RunWith(Suite.class)
@Suite.SuiteClasses({

	InterpolatedReuse.class,	
	PrintingCodeReuse.class,
	ExpectedSubtleJavaDocs.class,
	
	
})
	

//@MaxValue(50)
public class A1ModularitySuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(A1ModularitySuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	static {
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
//		setCheckStyleConfiguration("unc_checks_524_A1.xml");
//	}
}

	

