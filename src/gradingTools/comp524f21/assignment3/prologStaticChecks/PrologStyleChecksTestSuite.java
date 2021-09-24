package gradingTools.comp524f21.assignment3.prologStaticChecks;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	APrologProgramGenerator.class,
//	AbstractSocialDistanceCommentsPrologTest.class,
	ExpectedDocsDerivedSafe.class,
	ExpectedDocsPrintGivenCombinations.class,
	ExpectedDocsListGivenSafe.class,
	SocialDistanceMagicNumbersTest.class,
//	SocialDistanceNoExternalFunctionsTest.class,
	SocialDistanceRecursiveTest.class,
	PrologMnemonicNamesTest.class,
})
	

//@MaxValue(10)
public class PrologStyleChecksTestSuite {

	public static void main (String[] args) {
		try {

			BasicJUnitUtils.interactiveTest(PrologStyleChecksTestSuite.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
