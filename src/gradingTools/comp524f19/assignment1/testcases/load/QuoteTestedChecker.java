package gradingTools.comp524f19.assignment1.testcases.load;

import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
@Explanation("Checks if test file has a call to quote")
public class QuoteTestedChecker extends AbstractFunctionTestedChecker {

	@Override
	protected String functionName() {
		return "QUOTE";
	}

	
}
