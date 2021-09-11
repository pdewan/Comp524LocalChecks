package gradingTools.comp524f21.assignment2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.ExpectedSubtleJavaDocs;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.InterpolatedReuse;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.MVCAndFactoryCalls;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.ModelReuse;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.PrintingCodeReuse;
import gradingTools.comp524f21.assignment2.modularity.DerivedAndInferredPrintCallSharedProcedure;
import gradingTools.comp524f21.assignment2.modularity.DerivedPrintIsNotDirect;
import gradingTools.comp524f21.assignment2.modularity.InferredPrintIsNotDirect;
import gradingTools.comp524f21.assignment2.source.SocialDistanceControllerFetchesModelSingleton;
import util.annotations.IsExtra;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	
//	InterpolatedReuse.class,	
	DerivedAndInferredPrintCallSharedProcedure.class,
	DerivedPrintIsNotDirect.class,
	InferredPrintIsNotDirect.class,
//	ExpectedSubtleJavaDocs.class,
	SocialDistanceControllerFetchesModelSingleton.class,
	ModelReuse.class,
//	MVCAndFactoryCalls.class
	
})
	

//@MaxValue(50)
@IsExtra(true)
public class F21A2Modularity {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F21A2Modularity.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	static {
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
//		setCheckStyleConfiguration("unc_checks_524_A1.xml");
//	}
}

	

