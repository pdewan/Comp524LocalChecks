package gradingTools.comp524f21.assignment3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment2.requiredFiles.SocialDistancePlProvided;
import gradingTools.comp524f20.assignment2.requiredFiles.SocialDiststancePlNoExternalFunctionsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	SocialDistancePlProvided.class,
	SocialDiststancePlNoExternalFunctionsTest.class
})
	

//@MaxValue(10)
public class SocialDistanceFileTestSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(SocialDistanceFileTestSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
