package gradingTools.comp524f20.assignment3.requiredFiles;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	SocialDistanceSMLProvided.class,
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
