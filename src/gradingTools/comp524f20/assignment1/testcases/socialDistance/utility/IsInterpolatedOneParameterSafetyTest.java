package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import gradingTools.comp524f20.assignment1.SocialDistanceInputOutputFactory;
import util.annotations.MaxValue;
@MaxValue(2)
public class IsInterpolatedOneParameterSafetyTest extends AbstractSocialDistanceUitilityStaticFunctionCallTest {
	public static final int TIME_OUT_SECS = 1; // secs
	
	private static int SMALL_DISTANCE = SocialDistanceInputOutputFactory.SMALL_DISTANCE,
			   MEDIUM_DISTANCE = SocialDistanceInputOutputFactory.MEDIUM_DISTANCE,
			   LARGE_DISTANCE = SocialDistanceInputOutputFactory.LARGE_DISTANCE;
	
	
	static Object[][] inputCombinations = {
			{MEDIUM_DISTANCE},
			{MEDIUM_DISTANCE+1},
			{LARGE_DISTANCE-1},
			
			{SMALL_DISTANCE},
			{LARGE_DISTANCE},
			{MEDIUM_DISTANCE-1},
			
			{0},
			{LARGE_DISTANCE+1},
			{Integer.MAX_VALUE},
			
	};
	
	static Object[] results = {
			true,
			true,
			true,
			
			false,
			false,
			false,
			
			false,
			false,
			false
	};
	
	private static Class[] aParameterTypes={Integer.TYPE};
	
	@Override
	protected  Object[][] getArguments() {
		return inputCombinations;
	}
	
	@Override
	protected Class [] getParameterTypes() {
		return  aParameterTypes;
	}

	@Override
	protected Object[] getResults() {
		return results;
	}

	@Override
	protected String methodName() {
		return "isInterpolatedSafe";
	}

	
}