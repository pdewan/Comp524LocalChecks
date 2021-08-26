package gradingTools.comp524f20.assignment2.ruleTests.derivedSafe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	DerivedSafe_OutputGeneration.class,
	DerivedSafe_TableTest.class,
	DerivedSafe_OffTableTrueTest.class,
	DerivedSafe_OffTableFalseTest.class,
})
	

//@MaxValue(10)
public class DerivedSafeTestSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(DerivedSafeTestSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
