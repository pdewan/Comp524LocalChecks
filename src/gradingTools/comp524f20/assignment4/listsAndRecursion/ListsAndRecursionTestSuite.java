package gradingTools.comp524f20.assignment4.listsAndRecursion;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import util.annotations.MaxValue;
import util.trace.Tracer;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	ListDerivedSafeLisp.class,
	SafetyTableTest.class
})
	

//@MaxValue(10)
public class ListsAndRecursionTestSuite {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			
			BasicJUnitUtils.interactiveTest(ListsAndRecursionTestSuite.class);
//			Tracer.setKeywordPrintStatus(ListDerivedSafeSML.class, true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
