package gradingTools.comp524f20.assignment1.testcases.socialDistance.style;

import gradingTools.basics.sharedTestCase.checkstyle.ExpectedJavaDocsCheck;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(30)
@IsExtra(true)
@Explanation("JavaDocs from assignment writeup reflecting subtle modularity in utility class")
public class ExpectedSubtleJavaDocs extends ExpectedJavaDocsCheck {
	static String[][] tagAndMethods = {
			{".BasicSocialDistanceUtility", ".*"},
			{".BasicSocialDistanceUtility", ".*"},

	};
/*
 *  method interpolateDistance in class matching [@BasicSocialDistanceUtility] has JavaDoc then it is interpolated low. Good! [ExpectedMethodJavaDoc]

 */
	@Override
	protected String[][] tagAndMethods() {
		return tagAndMethods;
	}

	@Override
	protected int maxPositives() {
		return 6;
	}

}
