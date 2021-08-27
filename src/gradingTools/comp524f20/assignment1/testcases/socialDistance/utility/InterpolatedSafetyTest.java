package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment1.SocialDistanceInputOutputFactory;
import util.annotations.MaxValue;
@MaxValue(7)
public class InterpolatedSafetyTest extends AbstractThreeParameterSafetyTest {
	
	protected  Object[] getResults() {
		boolean [] results = SocialDistanceInputOutputFactory.getInterpolatedRegexChecks();
		return SocialDistanceInputOutputFactory.boolToObj(results);
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