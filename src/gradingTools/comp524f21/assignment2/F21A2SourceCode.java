package gradingTools.comp524f21.assignment2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.ExpectedSubtleJavaDocs;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.InterpolatedReuse;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.MVCAndFactoryCalls;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.ModelReuse;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.PrintingCodeReuse;
import gradingTools.comp524f21.assignment2.source.BasicModelRegistersObserver;
import gradingTools.comp524f21.assignment2.source.DerivingModelRegistersObserver;
import gradingTools.comp524f21.assignment2.source.InferringModelRegistersObserver;
import gradingTools.comp524f21.assignment2.source.InterpolatingModelRegistersObserver;
import gradingTools.comp524f21.assignment2.source.SocialDistanceMainSetsModelSingleton;
import gradingTools.comp524f21.assignment2.source.SocialDistanceControllerFetchesModelSingleton;
import gradingTools.comp524f21.assignment2.source.SocialDistanceControllerWritesModel;
import gradingTools.comp524f21.assignment2.source.SocialDistanceMainCallsControllerMethod;
import gradingTools.comp524f21.assignment2.source.SocialDistanceMainFetchesViewSingleton;
import gradingTools.comp524f21.assignment2.source.SocialDistanceViewISAPropertyListener;
import util.annotations.IsExtra;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	SocialDistanceMainSetsModelSingleton.class,
	SocialDistanceMainFetchesViewSingleton.class,
	SocialDistanceMainCallsControllerMethod.class,
	SocialDistanceControllerFetchesModelSingleton.class,
	SocialDistanceControllerWritesModel.class,
	SocialDistanceViewISAPropertyListener.class,
	
	BasicModelRegistersObserver.class,
	DerivingModelRegistersObserver.class,	
	InterpolatingModelRegistersObserver.class,
	InferringModelRegistersObserver.class
	
})
	

//@MaxValue(50)
public class F21A2SourceCode {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F21A2SourceCode.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	static {
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
//		setCheckStyleConfiguration("unc_checks_524_A1.xml");
//	}
}

	

