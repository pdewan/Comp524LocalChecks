package gradingTools.comp524f23.assignment1;

import gradingTools.comp524f20.assignment1.SocialDistanceClassRegistry;

public interface A1SocialDistanceClassRegistry extends SocialDistanceClassRegistry {

	//From Last Registry do not need to be changed
//	public Class<?> getBasicSocialDistanceUtility();
//	public Class<?> getSocialDistanceUilityTesterMain();
	
	public default Class<?> getSocialDistanceMVCBasicMain(){return null;};
	public default Class<?> getSocialDistanceMVCInterpolatingMain(){return null;};
	public default Class<?> getSocialDistanceMVCDerivingMain(){return null;};
	public default Class<?> getSocialDistanceMVCInferringMain(){return null;};
	public default Class<?> getSocialDistanceBasicModel(){return null;};
	public default Class<?> getSocialDistanceInterpolatingModel(){return null;};
	public default Class<?> getSocialDistancDerivingModel(){return null;};
	public default Class<?> getSocialDistancInferringModel(){return null;};
	public default Class<?> getSocialDistanceView(){return null;};
	public default Class<?> getSocialDistanceController(){return null;};
	public default Class<?> getSocialDistanceModelFactory(){return null;};
	public default Class<?> getSocialDistanceViewFactory(){return null;};
	public default Class<?> getSocialDistanceControllerFactory(){return null;};
	public default Class<?> getSocialDistanceClassifierFactory(){return null;};

}
