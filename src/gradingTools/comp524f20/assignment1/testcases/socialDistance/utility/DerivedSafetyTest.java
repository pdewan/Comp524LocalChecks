package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import gradingTools.comp524f20.assignment1.SocialDistanceInputOutputFactory;
import util.annotations.MaxValue;
@MaxValue(7)
public class DerivedSafetyTest extends AbstractThreeParameterSafetyTest {
	
	protected  Object[] getResults() {
		boolean [] results = SocialDistanceInputOutputFactory.getDerivedSafeRegexChecks();
		return SocialDistanceInputOutputFactory.boolToObj(results);
	};
	@Override
	protected String methodName() {
		return "isDerivedSafe";
	}
}