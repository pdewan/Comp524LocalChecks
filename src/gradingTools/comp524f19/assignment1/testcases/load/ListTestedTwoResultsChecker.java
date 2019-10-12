package gradingTools.comp524f19.assignment1.testcases.load;

import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Checks if test file has calls to list with two or more results")
@MaxValue(10)
public class ListTestedTwoResultsChecker extends AbstractFunctionTestedTwoResultsChecker {

	@Override
	protected String functionName() {
		return "LIST";
	}

	
}
