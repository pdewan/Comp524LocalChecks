package gradingTools.comp524f20.assignment2.ruleTests.printGivenCombinations;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	PrintGivenCombinations_OutputGeneration.class,
	PrintGivenCombinations_TableSizedInputs.class,
	PrintGivenCombinatations_NonTableSizedInputs.class,
})
	

//@MaxValue(10)
public class PrintGivenCombinationsTestSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(PrintGivenCombinationsTestSuite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
