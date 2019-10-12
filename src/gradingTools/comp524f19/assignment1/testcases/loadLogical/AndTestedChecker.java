package gradingTools.comp524f19.assignment1.testcases.loadLogical;

import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Checks if test file has a call to and")
@MaxValue(10)
public class AndTestedChecker extends AbstractFunctionTestedLogicalChecker {

	@Override
	protected String functionName() {
		return "AND";
	}

	
}
