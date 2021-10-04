package gradingTools.comp524f21.assignment3.prologStaticChecks;

import gradingTools.comp524f20.assignment2.ruleTests.listGivenSafeTests.ListGivenSafe_OutputGeneration;
import gradingTools.comp524f20.assignment2.ruleTests.listGivenSafeTests.ListGivenSafe_SafeTupleTest;
import gradingTools.comp524f20.assignment2.ruleTests.listGivenSafeTests.ListGivenSafe_ValuesTest;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(5)
@IsExtra(true)
public class ExpectedDocsListGivenSafe extends AbstractSocialDistanceCommentsPrologTest {

	private Class [] PRECEDING_TESTS = {
			ListGivenSafe_OutputGeneration.class,
			ListGivenSafe_SafeTupleTest.class,
			ListGivenSafe_ValuesTest.class,
	};
	
	@Override
	protected Class [] precedingTests() {
		return PRECEDING_TESTS;
	}
	
	private final String base = ".*Call another query to create the full safety table, and then"
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
