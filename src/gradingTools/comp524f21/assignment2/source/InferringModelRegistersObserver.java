package gradingTools.comp524f21.assignment2.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleInterfaceDefinedTestCase;
import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodDefinedTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import util.annotations.MaxValue;
@MaxValue(2)
public class InferringModelRegistersObserver extends CheckstyleMethodDefinedTestCase{
	final Class[] PRECEDING_TESTS = {
			SocialDistanceClassRegistryProvided.class

	};
	@Override
	protected Class[] precedingTests() {
			return PRECEDING_TESTS;
	}
	//[INFO] D:\dewan_backup\Java\PLProjs\PLProjsJava\.\src\safeSocialization\model\AnInterpolatingSafeSocializationModel.java:8: Expected signature addPropertyChangeListener:java.beans.PropertyChangeListener->void in type safeSocialization.model.AnInterpolatingSafeSocializationModel:[SocialDistanceInterpolatingModel]. Good! [ExpectedSignatures]

	public InferringModelRegistersObserver() {
		super("SocialDistancInferringModel", "addPropertyChangeListener:java.beans.PropertyChangeListener->void ");
		// TODO Auto-generated constructor stub
	}
	
}
