package gradingTools.comp524f19.assignment1.testcases.load;

import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Checks if test file has calls to cond with three or more results")
@MaxValue(20)
public class CondTestedResultsChecker extends AbstractFunctionTestedCondChecker {

	@Override
	protected String functionName() {
		return "COND";
	}

	
}
