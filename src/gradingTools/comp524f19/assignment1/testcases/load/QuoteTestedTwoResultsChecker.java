package gradingTools.comp524f19.assignment1.testcases.load;

import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Checks if test file has calls to quote with two or more results")
@MaxValue(10)
public class QuoteTestedTwoResultsChecker extends AbstractFunctionTestedTwoResultsChecker {

	@Override
	protected String functionName() {
		return "QUOTE";
	}

	
}
