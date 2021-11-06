package gradingTools.comp524f21.assignment5.style.a5specific;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(2)
//@IsExtra(true)
public class MainCallsSkeletonMain extends CheckstyleMethodCalledTestCase{
	@Override
	protected Class[] precedingTests() {
			return ComparatorEvaluatorCodeReuse.PRECEDING_TESTS;
	}
	//[INFO] D:\dewan_backup\Java\PLProjs\PLProjsJava\.\src\safeSocialization\model\AnInterpolatingSafeSocializationModel.java:8: Expected signature addPropertyChangeListener:java.beans.PropertyChangeListener->void in type safeSocialization.model.AnInterpolatingSafeSocializationModel:[SocialDistanceInterpolatingModel]. Good! [ExpectedSignatures]

	public MainCallsSkeletonMain() {
		super("Main", "main.Main!main:String\\[\\]->void");
	}
	
}
