package gradingTools.comp524f20.assignment2.requiredFiles;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	SocialDistancePlProvided.class,
	SocialDiststancePlNoMagicNumbersTest.class,
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
