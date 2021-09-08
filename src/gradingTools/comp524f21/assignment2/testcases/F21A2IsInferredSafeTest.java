package gradingTools.comp524f21.assignment2.testcases;

import grader.basics.junit.JUnitTestsEnvironment;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.utility.IsInferredSafeTest;
import util.annotations.Explanation;
import util.annotations.MaxValue;

@MaxValue(45)
@Explanation("Checks for table, table off by one, and Random Value inputs")
public class F21A2IsInferredSafeTest extends IsInferredSafeTest{

	@Override
	protected boolean verifyDerivedSafe() {
		F21A2DerivedSafetyVerifier derivedTest = (F21A2DerivedSafetyVerifier) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(F21A2DerivedSafetyVerifier.class);
		return derivedTest == null || !derivedTest.allTestsPassed();
	}
}
