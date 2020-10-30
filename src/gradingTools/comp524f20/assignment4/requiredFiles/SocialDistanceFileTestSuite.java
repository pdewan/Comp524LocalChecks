package gradingTools.comp524f20.assignment4.requiredFiles;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import util.annotations.MaxValue;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	SocialDistanceLispProvided.class,
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
