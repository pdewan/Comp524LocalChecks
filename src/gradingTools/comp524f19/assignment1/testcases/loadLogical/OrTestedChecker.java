package gradingTools.comp524f19.assignment1.testcases.loadLogical;

import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Checks if test file has a call to or")
@MaxValue(10)
public class OrTestedChecker extends AbstractFunctionTestedLogicalChecker {

	@Override
	protected String functionName() {
		return "OR";
	}

	
}
