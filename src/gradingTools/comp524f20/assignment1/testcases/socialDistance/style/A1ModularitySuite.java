package gradingTools.comp524f20.assignment1.testcases.socialDistance.style;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.basics.sharedTestCase.checkstyle.AccessModifiersMatched;
import gradingTools.comp524f19.assignment1.requiredClasses.A1RequiredClassesSuite;
import gradingTools.comp524f19.assignment1.testcases.load.A1LoadSuite;
import gradingTools.comp524f19.assignment1.testcases.load.TestLispFileProvided;
import gradingTools.comp524f19.assignment1.testcases.loadLogical.A1LoadLogicalSuite;
import gradingTools.comp524f19.assignment1.testcases.loadRelation.A1LoadRelationSuite;
import gradingTools.comp524f19.assignment1.testcases.toString.A1ToStringSuite;
import gradingTools.comp524f20.assignment0_1.testcases.GreetingMainProvided;
import gradingTools.comp524f20.assignment0_1.testcases.GreetingRun;
import gradingTools.comp524f20.assignment0_1.testcases.socialDistance.SocialDistanceMainRuns;
import gradingTools.comp524f20.assignment0_4.testcases.LispGreetingLoadAndRun;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityTesterMainProvided;
import gradingTools.comp524f20.assignment4.lisp.testcases.LispTestCase;


@RunWith(Suite.class)
@Suite.SuiteClasses({

	InterpolatedReuse.class,	
	ExpectedSubtleJavaDocs.class,
	ModelReuse.class,
	MVCAndFactoryCalls.class
	
	
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

	

