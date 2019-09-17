package gradingTools.comp524f19.assignment1.testcases.loadLogical;

import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
@Explanation("Checks if test file has calls to and with two or more results")
public class AndTestedTwoResultsChecker extends AbstractFunctionTestedTwoResultsLogicalChecker {

	@Override
	protected String functionName() {
		return "AND";
	}

	
}
