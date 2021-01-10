package gradingTools.comp524f20.assignment1.testcases.socialDistance.style;

import gradingTools.basics.sharedTestCase.checkstyle.ExpectedCallsKnownMax;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(10)
@IsExtra(true)
public class InterpolatedReuse extends ExpectedCallsKnownMax {
	static String[][] tagAndMethods = {
			{".BasicSocialDistanceUtility", "isInterpolatedSafe.int.int..boolean"},
			{".BasicSocialDistanceUtility", "isInterpolatedSafe.int..boolean"},
			{".BasicSocialDistanceUtility", "isInterpolatedSafe.int.int.int..boolean"},

			

	};

	@Override
	protected String[][] tagAndMethods() {
		return tagAndMethods;
	}

	@Override
	protected int maxPositives() {
		return 3;
	}

}
