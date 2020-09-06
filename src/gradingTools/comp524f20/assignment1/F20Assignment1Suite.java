package gradingTools.comp524f20.assignment1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
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
import gradingTools.comp524f20.assignment1.testcases.socialDistance.SocialDistanceUtilityTesterMainProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.BasicMainTest;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.MainClassSuite;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.RequiredClassesSuite;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.UtilityClassSuite;
import gradingTools.comp524f20.assignment4.lisp.testcases.LispTestCase;
import util.trace.TraceableWarning;
import util.trace.Tracer;
import util.trace.uigen.UnknownPropertyNotification;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	RequiredClassesSuite.class,
	UtilityClassSuite.class,
	MainClassSuite.class
	
})
	

//@MaxValue(50)
public class F20Assignment1Suite {

	public static void main (String[] args) {
		try {
			TraceableWarning.doNotWarn(UnknownPropertyNotification.class);
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F20Assignment1Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
