package gradingTools.comp524f19.assignment1.testcases.load;

import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
@Explanation("Checks if test file has a call to eval")
public class EvalTestedChecker extends AbstractFunctionTestedChecker {

	@Override
	protected String functionName() {
		return "EVAL";
	}

	
}
