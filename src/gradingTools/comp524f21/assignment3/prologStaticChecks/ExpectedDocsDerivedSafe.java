package gradingTools.comp524f21.assignment3.prologStaticChecks;

import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(5)
@IsExtra(true)
public class ExpectedDocsDerivedSafe extends AbstractSocialDistanceCommentsPrologTest {


	private final String baseRegex = ".*Consider the three smaller problems of determining if a distance,"
			+ " duration, or exhalation level is at least as safe as a given distance, duration, "
			+ "and exhalation level.*";
	
	private final String [] regex = {baseRegex,baseRegex,baseRegex
	};
	
	private final String [] methodName = {
			".*[Dd]istance.*",
			".*[Dd]uration.*",
			".*[Ee]xhalation.*",
	};
	
	@Override
	public String [] getCommentRegex() {
		return regex;
	}

	@Override
	public String [] getMethodName() {
		return methodName;
	}


}
