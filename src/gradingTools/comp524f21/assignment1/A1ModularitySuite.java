package gradingTools.comp524f21.assignment1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.ExpectedSubtleJavaDocs;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.InterpolatedReuse;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.MVCAndFactoryCalls;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.ModelReuse;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.PrintingCodeReuse;
import gradingTools.comp524f21.assignment1.testcases.sociatDistance.style.ExpectedJavaDocGivenSafe;
import gradingTools.comp524f21.assignment1.testcases.sociatDistance.style.ExpectedJavaDocHighInterpolation;
import gradingTools.comp524f21.assignment1.testcases.sociatDistance.style.ExpectedJavaDocHighInterpolationHelper;
import gradingTools.comp524f21.assignment1.testcases.sociatDistance.style.ExpectedJavaDocLowInterpolationHelper;
import gradingTools.comp524f21.assignment1.testcases.sociatDistance.style.ExpectedJavaDocLowInterpolation;
import gradingTools.comp524f21.assignment1.testcases.sociatDistance.style.Interpolated2Reuse;
import gradingTools.comp524f21.assignment1.testcases.sociatDistance.style.Interpolated3Reuse;
import gradingTools.comp524f21.assignment1.testcases.sociatDistance.style.PrintDerivedReuse;
import util.annotations.IsExtra;


@RunWith(Suite.class)
@Suite.SuiteClasses({

	Interpolated3Reuse.class,
	Interpolated2Reuse.class,
//	PrintDerivedReuse.class,
	
	ExpectedJavaDocLowInterpolation.class,
	ExpectedJavaDocHighInterpolation.class,
	ExpectedJavaDocHighInterpolationHelper.class,
	ExpectedJavaDocLowInterpolationHelper.class,
	ExpectedJavaDocGivenSafe.class,

//	ExpectedSubtleJavaDocs.class,
	
	
})
	

//@MaxValue(50)
@IsExtra(true)
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

	

