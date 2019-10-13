package gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers;

import util.annotations.Explanation;
import util.annotations.MaxValue;
@Explanation("Checks if test file has a call to lambda that takes 2 parameters")
@MaxValue(15)
public class LoadLambdaChecker3 extends AbstractFunctionLambdaChecker{

	@Override
	protected String functionName() {
		// TODO Auto-generated method stub
		return "LAMBDA";
	}

	@Override
	protected int argNum() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	protected String result() {
		// TODO Auto-generated method stub
		return "42";
	}
	
}
