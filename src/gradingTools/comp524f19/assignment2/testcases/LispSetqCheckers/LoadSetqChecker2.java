package gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers;

import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Checks if test file has a call, (setq B (+ A 13))")
@MaxValue(15)
public class LoadSetqChecker2 extends AbstractFunctionSetqChecker {

	@Override
	protected String functionName() {
		return "SETQ";
	}

	@Override
	protected String arg0() {
		return "B";
	}

	@Override
	protected String arg1() {
		// TODO Auto-generated method stub
		return "(+ A 13)";
	}

	@Override
	protected String result() {
		// TODO Auto-generated method stub
		return "42";
	}
	
}
