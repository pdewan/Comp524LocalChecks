package gradingTools.comp524f21.assignment5.style.a5specific;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(1)
@IsExtra(true)
public class NotCallsTAtomFactory extends CheckstyleMethodCalledTestCase{
	@Override
	protected Class[] precedingTests() {
			return ComparatorEvaluatorCodeReuse.PRECEDING_TESTS;
	}
	//[INFO] D:\dewan_backup\Java\PLProjs\PLProjsJava\.\src\safeSocialization\model\AnInterpolatingSafeSocializationModel.java:8: Expected signature addPropertyChangeListener:java.beans.PropertyChangeListener->void in type safeSocialization.model.AnInterpolatingSafeSocializationModel:[SocialDistanceInterpolatingModel]. Good! [ExpectedSignatures]

//	main.lisp.parser.terms.NilAtomicExpressionFactory!newInstance:->.*,
//	main.lisp.parser.terms.TAtomicExpressionFactory!newInstance:->.*,
	
	public NotCallsTAtomFactory() {
		super("Not", "main.lisp.parser.terms.TAtomicExpressionFactory!newInstance:->.*");
	}
	
}
