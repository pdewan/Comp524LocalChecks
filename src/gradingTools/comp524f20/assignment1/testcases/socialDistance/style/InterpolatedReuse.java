package gradingTools.comp524f20.assignment1.testcases.socialDistance.style;

import gradingTools.basics.sharedTestCase.checkstyle.ExpectedCallsCheck;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(5)
@IsExtra(true)
public class InterpolatedReuse extends ExpectedCallsCheck {
	static String[][] tagAndMethods = {
			{".BasicSocialDistanceUtility", "isInterpolatedSafe.int.int..boolean"},
			{".BasicSocialDistanceUtility", "isInterpolatedSafe.int..boolean"},

	};

	@Override
	protected String[][] tagAndMethods() {
		return tagAndMethods;
	}

	@Override
	protected int maxPositives() {
		return 2;
	}

}
