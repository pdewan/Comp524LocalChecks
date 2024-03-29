package gradingTools.comp524f21.assignment5.style.a5specific;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(0)
//@IsExtra(true)
public class LoadCallsReadAllLines extends CheckstyleMethodCalledTestCase{
	@Override
	protected Class[] precedingTests() {
			return ComparatorEvaluatorCodeReuse.PRECEDING_TESTS;
	}
	//[INFO] D:\dewan_backup\Java\PLProjs\PLProjsJava\.\src\safeSocialization\model\AnInterpolatingSafeSocializationModel.java:8: Expected signature addPropertyChangeListener:java.beans.PropertyChangeListener->void in type safeSocialization.model.AnInterpolatingSafeSocializationModel:[SocialDistanceInterpolatingModel]. Good! [ExpectedSignatures]

	public LoadCallsReadAllLines() {
		super("Load", "java.nio.file.Files!readAllLines:java.nio.file.Path->List");
	}
	
}
