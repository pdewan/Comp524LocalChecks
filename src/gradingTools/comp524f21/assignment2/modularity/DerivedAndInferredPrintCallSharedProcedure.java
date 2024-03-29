package gradingTools.comp524f21.assignment2.modularity;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleCommonMethodCalledTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@IsExtra(true)
@MaxValue(5)
@Explanation("Checks if the two kinds of print call a common procedure to perform some of the common tasks")
public class DerivedAndInferredPrintCallSharedProcedure extends CheckstyleCommonMethodCalledTestCase {
	final Class[] PRECEDING_TESTS = {
			SocialDistanceClassRegistryProvided.class

	};
	@Override
	protected Class[] precedingTests() {
			return PRECEDING_TESTS;
	}
	public DerivedAndInferredPrintCallSharedProcedure() {
		super("@BasicSocialDistanceUtility", "printGivenAndGeneratedCombinationsDerivedSafety:->void", "printGivenAndGeneratedCombinationsInferredSafety:->void", ".*:.*->void");
		// TODO Auto-generated constructor stub
	}

}
