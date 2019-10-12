package gradingTools.comp524f19.assignment1.testcases.loadRelation;

import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Checks if test file has a call to <")
@MaxValue(10)
public class LessTestedChecker extends AbstractFunctionTestedRelationChecker {

	@Override
	protected String functionName() {
		return "<";
	}

	
}
