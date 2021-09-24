package gradingTools.comp524f21.assignment3.prologStaticChecks;

import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(5)
@IsExtra(true)
public class ExpectedDocsPrintGivenCombinations extends AbstractSocialDistanceCommentsPrologTest {

	
	private final String [] regex = {".*You will need to recursively reduce both the safety table and N*"};
	
	private final String [] methodName = {".*[Pp]rintGivenCombinations.*"};
	
	@Override
	public String [] getCommentRegex() {
		return regex;
	}

	@Override
	public String [] getMethodName() {
		return methodName;
	}


}
