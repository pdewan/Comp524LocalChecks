package gradingTools.comp524f20.assignment3.functionReturnValues;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import util.annotations.MaxValue;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	CurriedOnceInterpolatedSafe.class,
	CurriedTwiceInterpolatedSafe.class,
	CurryableInterpolatedSafe.class,
	
	CurryableMatchingSafe.class,
	CurriedMatchingDerivedSafe.class,
	CurriedMatchingGivenSafe.class
	
})
	

//@MaxValue(10)
public class FunctionReturnValuesTestSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(FunctionReturnValuesTestSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
