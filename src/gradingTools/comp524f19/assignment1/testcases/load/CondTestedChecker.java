package gradingTools.comp524f19.assignment1.testcases.load;

import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Checks if test file has a call to cond")
@MaxValue(10)
public class CondTestedChecker extends AbstractFunctionTestedChecker {

	@Override
	protected String functionName() {
		return "COND";
	}

	
}
