package gradingTools.comp524f20.assignment1.testcases.socialDistance.style;

import gradingTools.basics.sharedTestCase.checkstyle.ExpectedCallsKnownMax;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(10)
@IsExtra(true)
public class InterpolatedReuse extends ExpectedCallsKnownMax {
	
/*
[@BasicSocialDistanceUtility] has made expected call @BasicSocialDistanceUtility!isInterpolatedSafe:int;int;int->boolean. Good! [MissingMethodCall]
[@BasicSocialDistanceUtility] has not made expected call @BasicSocialDistanceUtility!isInterpolatedSafe:int;int->boolean. [MissingMethodCall]
[@BasicSocialDistanceUtility] has made expected call @BasicSocialDistanceUtility!isInterpolatedSafe:int;int;int->boolean. Good! [MissingMethodCall]
class safeSocialization.util.SafeSocializationUtil:[@BasicSocialDistanceUtility] has made expected call @BasicSocialDistanceUtility!isGivenSafe:int;int;int->boolean. Good! [MissingMethodCall
*/
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
