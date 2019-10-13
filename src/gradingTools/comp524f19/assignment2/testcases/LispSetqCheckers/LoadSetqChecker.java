package gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers;

import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Checks if test file has a call, (setq A 29)")
@MaxValue(15)
public class LoadSetqChecker extends AbstractFunctionSetqChecker {

	@Override
	protected String functionName() {
		return "SETQ";
	}

	@Override
	protected String arg0() {
		return "A";
	}

	@Override
	protected String arg1() {
		// TODO Auto-generated method stub
		return "29";
	}

	@Override
	protected String result() {
		// TODO Auto-generated method stub
		return "29";
	}
	
}
