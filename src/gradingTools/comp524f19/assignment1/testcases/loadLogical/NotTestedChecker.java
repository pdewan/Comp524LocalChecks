package gradingTools.comp524f19.assignment1.testcases.loadLogical;

import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Checks if test file has a call to not")
@MaxValue(10)
public class NotTestedChecker extends AbstractFunctionTestedLogicalChecker {

	@Override
	protected String functionName() {
		return "NOT";
	}

	
}
