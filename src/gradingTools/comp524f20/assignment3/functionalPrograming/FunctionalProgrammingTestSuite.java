package gradingTools.comp524f20.assignment3.functionalPrograming;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import util.annotations.MaxValue;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	GivenSafeSML.class,
	InterpolatedSafeSML.class
	
})
	

//@MaxValue(10)
public class FunctionalProgrammingTestSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(FunctionalProgrammingTestSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
