package gradingTools.comp524f19.assignment1.testcases.loadRelation;

import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
@Explanation("Checks if test file has calls to >= with two or more results")
public class GorETestedTwoResultsChecker extends AbstractFunctionTestedTwoResultsRelationChecker {

	@Override
	protected String functionName() {
		return ">=";
	}

	
}
