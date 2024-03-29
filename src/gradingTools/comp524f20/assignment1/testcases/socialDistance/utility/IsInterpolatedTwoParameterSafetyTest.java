package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import util.annotations.MaxValue;
import gradingTools.comp524f20.assignment1.SocialDistanceInputOutputFactory;

@MaxValue(3)
public class IsInterpolatedTwoParameterSafetyTest extends AbstractSocialDistanceUitilityStaticFunctionCallTest {
	public static final int TIME_OUT_SECS = 1; // secs
	
	private static int SMALL_DISTANCE = SocialDistanceInputOutputFactory.SMALL_DISTANCE,
					   MEDIUM_DISTANCE = SocialDistanceInputOutputFactory.MEDIUM_DISTANCE,
					   LARGE_DISTANCE = SocialDistanceInputOutputFactory.LARGE_DISTANCE,
					   SMALL_DURATION = SocialDistanceInputOutputFactory.SMALL_DURATION,
					   MEDIUM_DURATION = SocialDistanceInputOutputFactory.MEDIUM_DURATION,
					   LARGE_DURATION = SocialDistanceInputOutputFactory.LARGE_DURATION;
	static Object[][] inputCombinations = {
			{MEDIUM_DISTANCE,MEDIUM_DURATION}, //1
			{LARGE_DISTANCE,LARGE_DURATION},
			{SMALL_DISTANCE,SMALL_DURATION},
			
			{MEDIUM_DISTANCE+1,MEDIUM_DURATION}, //2
			{LARGE_DISTANCE+1,LARGE_DURATION},
			{SMALL_DISTANCE+1,SMALL_DURATION},
			{MEDIUM_DISTANCE,MEDIUM_DURATION-1},
			{LARGE_DISTANCE,LARGE_DURATION-1},
			{SMALL_DISTANCE,SMALL_DURATION-1},
			
			{LARGE_DISTANCE-1,MEDIUM_DURATION}, //3
			{Integer.MAX_VALUE,LARGE_DURATION},
			{MEDIUM_DISTANCE-1,SMALL_DURATION},
			{MEDIUM_DISTANCE,SMALL_DURATION+1},
			{LARGE_DISTANCE,MEDIUM_DURATION+1},
			{SMALL_DISTANCE,0},
			
			{SMALL_DISTANCE,LARGE_DURATION}, //4
			{LARGE_DISTANCE,SMALL_DURATION},
			{MEDIUM_DISTANCE,SMALL_DURATION},
			{MEDIUM_DISTANCE,LARGE_DURATION},
			{LARGE_DISTANCE,MEDIUM_DURATION},
			{SMALL_DISTANCE,MEDIUM_DURATION},
			
			{MEDIUM_DISTANCE,MEDIUM_DURATION+1}, //5
			{LARGE_DISTANCE,LARGE_DURATION+1},
			{SMALL_DISTANCE,SMALL_DURATION+1},
			{MEDIUM_DISTANCE-1,MEDIUM_DURATION},
			{LARGE_DISTANCE-1,LARGE_DURATION},
			{SMALL_DISTANCE-1,SMALL_DURATION}
			
	};
	
	static Object[] results = {
			true,
			true,
			true,
			
			true,
			true,
			true,
			true,
			true,
			true,

			true,
			true,
			true,
			true,
			true,
			true,
			
			false,
			false,
			false,
			false,
			false,
			false,

			false,
			false,
			false,
			false,
			false,
			false
	};
	
	private static Class[] aParameterTypes={Integer.TYPE, Integer.TYPE};
	
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