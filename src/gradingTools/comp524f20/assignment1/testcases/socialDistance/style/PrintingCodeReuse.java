package gradingTools.comp524f20.assignment1.testcases.socialDistance.style;

import gradingTools.basics.sharedTestCase.checkstyle.ExpectedCallsCheck;
import gradingTools.basics.sharedTestCase.checkstyle.ExpectedCommonCallsCheck;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(5)
@IsExtra(true)
@Explanation("Checks for reuse of print formats")
public class PrintingCodeReuse extends ExpectedCommonCallsCheck {
	static String[][] tagAndMethods = {
//			{".BasicSocialDistanceUtility", "printGivenAndGeneratedCombinationsDerivedSafety...void"},
			{".BasicSocialDistanceUtility", 
				"(printGivenAndGeneratedCombinationsDerivedSafety...void|printGivenAndGeneratedCombinationsInferredSafety...void)"},

	};

	@Override
	protected String[][] tagAndMethods() {
		return tagAndMethods;
	}

	@Override
	protected int maxPositives() {
		return 1;
	}

}
