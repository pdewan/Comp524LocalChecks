package gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers;

import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Checks if test file has a call to lambda that takes 0 parameter")
@MaxValue(15)
public class LoadLambdaChecker extends AbstractFunctionLambdaChecker{

	@Override
	protected String functionName() {
		// TODO Auto-generated method stub
		return "LAMBDA";
	}

	@Override
	protected int argNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected String result() {
		// TODO Auto-generated method stub
		return "42";
	}
	
}
