package gradingTools.comp524f20.assignment1.testcases.socialDistance.style;

import gradingTools.basics.sharedTestCase.checkstyle.ExpectedCallsCheck;
import gradingTools.basics.sharedTestCase.checkstyle.ExpectedJavaDocsCheck;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(10)
@IsExtra(true)
public class UtilityJavaDocs extends ExpectedJavaDocsCheck {
	static String[][] tagAndMethods = {
			{".BasicSocialDistanceUtility", ".*"},
			{".BasicSocialDistanceUtility", ".*"},

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
