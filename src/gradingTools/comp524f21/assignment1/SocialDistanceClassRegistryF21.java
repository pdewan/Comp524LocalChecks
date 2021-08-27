package gradingTools.comp524f21.assignment1;

import gradingTools.comp524f20.assignment1.SocialDistanceClassRegistry;

public interface SocialDistanceClassRegistryF21 extends SocialDistanceClassRegistry {

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
