package gradingTools.comp524f19.assignment1.testcases.loadLogical;

import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
@Explanation("Checks if test file has calls to or with two or more results")
public class OrTestedTwoResultsChecker extends AbstractFunctionTestedTwoResultsChecker {

	@Override
	protected String functionName() {
		return "OR";
	}

	
}
