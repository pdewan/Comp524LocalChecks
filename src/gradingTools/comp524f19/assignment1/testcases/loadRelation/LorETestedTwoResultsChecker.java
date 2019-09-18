package gradingTools.comp524f19.assignment1.testcases.loadRelation;

import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Checks if test file has calls to <= with two or more results")
@MaxValue(10)
public class LorETestedTwoResultsChecker extends AbstractFunctionTestedTwoResultsRelationChecker {

	@Override
	protected String functionName() {
		return "<=";
	}

	
}
