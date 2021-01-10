package gradingTools.comp524f20.assignment1.testcases.socialDistance.style;

import gradingTools.basics.sharedTestCase.checkstyle.ExpectedCallsKnownMax;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(15)
@IsExtra(true)
@Explanation("Checks for expected MVC and Factory calls")
public class MVCAndFactoryCalls extends ExpectedCallsKnownMax {
	static String[][] tagAndMethods = {
			{".SocialDistanceMVCInterpolatingMain", ""},
			{".SocialDistanceController", ""},

	};

	@Override
	protected String[][] tagAndMethods() {
		return tagAndMethods;
	}

	@Override
	protected int maxPositives() {
		return 5;
	}

}
