package gradingTools.comp524f21.assignment3.prologStaticChecks;

import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(5)
@IsExtra(true)
public class ExpectedDocsListGivenSafe extends AbstractSocialDistanceCommentsPrologTest {

	private final String base = ".*Call another query to create the fully safety table, and"
			+ " recursively process the table.*";
	
	private final String [] regex = {base,base};
	
	private final String [] methodName = {".*[Tt]able.*",".*[Ll]istGivenSafe.*"};
	
	@Override
	public String [] getCommentRegex() {
		return regex;
	}

	@Override
	public String [] getMethodName() {
		return methodName;
	}


}
