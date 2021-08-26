package gradingTools.comp524f20.assignment1.socialDistance.factories;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	ModelFactoryTest.class,
	ViewFactoryTest.class,
	ControllerFactoryTest.class,
	ClassifierFactoryTest.class,
	
})
	

public class FactoriesSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(FactoriesSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
