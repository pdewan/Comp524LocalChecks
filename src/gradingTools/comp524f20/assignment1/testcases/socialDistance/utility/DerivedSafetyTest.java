package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import util.annotations.MaxValue;
@MaxValue(7)
public class DerivedSafetyTest extends AbstractThreeParameterSafetyTest {
	static Object[] results = {
			true, //1
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //2
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //3
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //4
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //5
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //6
			false,
			false,
			false,
			false,
			false,
			false,
			
			true, //7
			true,
			true,
			false,
			false,
			false,
			
			true, //8
			true,
			true,
			true,
			true,
			true,
			false,
			
			false, //9
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //10
			false,
			false,
			false,
			false,
			false,
			false
	};
	
	protected  Object[] getResults() {
		return results;
	};
	@Override
	protected String methodName() {
		return "isDerivedSafe";
	}
}