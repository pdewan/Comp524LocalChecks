package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import util.annotations.MaxValue;
@MaxValue(7)
public class InterpolatedSafetyTest extends AbstractThreeParameterSafetyTest {
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
			
			false, //6
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //7
			false,
			false,
			false,
			false,
			false,
			
			false, //8
			false,
			false,
			false,
			false,
			false,
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
		return "isInterpolatedSafe";
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		return super.test(project, autoGrade);
	}
	
}