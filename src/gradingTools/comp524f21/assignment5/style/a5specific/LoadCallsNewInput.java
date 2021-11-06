package gradingTools.comp524f21.assignment5.style.a5specific;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(2)
//@IsExtra(true)
public class LoadCallsNewInput extends CheckstyleMethodCalledTestCase{
	@Override
	protected Class[] precedingTests() {
			return ComparatorEvaluatorCodeReuse.PRECEDING_TESTS;
	}
	//[INFO] D:\dewan_backup\Java\PLProjs\PLProjsJava\.\src\safeSocialization\model\AnInterpolatingSafeSocializationModel.java:8: Expected signature addPropertyChangeListener:java.beans.PropertyChangeListener->void in type safeSocialization.model.AnInterpolatingSafeSocializationModel:[SocialDistanceInterpolatingModel]. Good! [ExpectedSignatures]
//[INFO] C:\Users\ajwortas\OneDrive\Comp_524_Grading\MyOldA2\.\src\assignment1\LoadEvaluation.java:1: Some method (eval:main.lisp.parser.terms.SExpression;main.lisp.evaluator.Environment->SExpression) in class assignment1.LoadEvaluation:[@LoadEvaluator] has made expected call main.lisp.interpreter.InterpreterModelSingleton!newInput:*->.*. Good! [MissingMethodCall]
	public LoadCallsNewInput() {
		super("Load", "main.lisp.interpreter.InterpreterModelSingleton!newInput:\\*->\\.\\*");
	}
	
}
