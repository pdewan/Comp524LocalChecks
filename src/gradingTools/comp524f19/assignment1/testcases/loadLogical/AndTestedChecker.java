package gradingTools.comp524f19.assignment1.testcases.loadLogical;

import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
@Explanation("Checks if test file has a call to and")
public class AndTestedChecker extends AbstractFunctionTestedChecker {

	@Override
	protected String functionName() {
		return "AND";
	}

	
}
