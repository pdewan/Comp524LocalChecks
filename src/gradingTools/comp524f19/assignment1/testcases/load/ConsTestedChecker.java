package gradingTools.comp524f19.assignment1.testcases.load;

import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Checks if test file has a call to cons")
@MaxValue(10)
public class ConsTestedChecker extends AbstractFunctionTestedChecker {

	@Override
	protected String functionName() {
		return "CONS";
	}

	
}
