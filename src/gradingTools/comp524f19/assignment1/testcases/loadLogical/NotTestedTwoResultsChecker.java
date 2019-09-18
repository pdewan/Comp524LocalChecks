package gradingTools.comp524f19.assignment1.testcases.loadLogical;

import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Checks if test file has calls to not with two or more results")
@MaxValue(10)
public class NotTestedTwoResultsChecker extends AbstractFunctionTestedTwoResultsLogicalChecker {

	@Override
	protected String functionName() {
		return "NOT";
	}

	
}
