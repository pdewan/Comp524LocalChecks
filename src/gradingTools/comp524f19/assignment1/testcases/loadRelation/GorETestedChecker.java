package gradingTools.comp524f19.assignment1.testcases.loadRelation;

import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
@Explanation("Checks if test file has a call to >=")
public class GorETestedChecker extends AbstractFunctionTestedRelationChecker {

	@Override
	protected String functionName() {
		return ">=";
	}

	
}
