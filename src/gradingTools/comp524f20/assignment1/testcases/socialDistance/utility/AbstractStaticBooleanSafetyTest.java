package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

public abstract class AbstractStaticBooleanSafetyTest extends AbstractSocialDistanceUitilityStaticFunctionCallTest {
	public static final int TIME_OUT_SECS = 1; // secs
	
	static Object[] results = {
			true,
			false
	};
	
	
	protected  Object[] getResults() {
		return results;
	};

	public AbstractStaticBooleanSafetyTest() {
	}

	
}
