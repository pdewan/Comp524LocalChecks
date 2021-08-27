package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import java.util.Arrays;

import gradingTools.comp524f20.assignment1.SocialDistanceInputOutputFactory;

public abstract class AbstractThreeParameterSafetyTest extends AbstractSocialDistanceUitilityStaticFunctionCallTest {
	public static final int TIME_OUT_SECS = 1; // secs
	
	@Override
	protected  Object[][] getArguments() {
		int [][] inputs = SocialDistanceInputOutputFactory.getInputs();
		return SocialDistanceInputOutputFactory.intToObjs(inputs);
	}

	private static Class[] aParameterTypes={Integer.TYPE, Integer.TYPE, Integer.TYPE};
	
	@Override
	protected Class [] getParameterTypes() {
		return  aParameterTypes;
	}
}