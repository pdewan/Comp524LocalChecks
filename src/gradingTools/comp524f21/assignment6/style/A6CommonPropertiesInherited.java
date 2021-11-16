package gradingTools.comp524f21.assignment6.style;

import gradingTools.basics.sharedTestCase.checkstyle.CommonPropertiesAreInheritedTestCase;
import gradingTools.comp524f19.assignment1.testcases.load.CondTestedChecker;
import gradingTools.comp524f19.assignment1.testcases.load.CondTestedResultsChecker;
import gradingTools.comp524f19.assignment1.testcases.load.ConsTestedChecker;
import gradingTools.comp524f19.assignment1.testcases.load.ConsTestedTwoResultsChecker;
import gradingTools.comp524f19.assignment1.testcases.load.EvalTestedChecker;
import gradingTools.comp524f19.assignment1.testcases.load.EvalTestedTwoResultsChecker;
import gradingTools.comp524f19.assignment1.testcases.load.ListTestedChecker;
import gradingTools.comp524f19.assignment1.testcases.load.ListTestedTwoResultsChecker;
import gradingTools.comp524f19.assignment1.testcases.load.LoadChecker;
import gradingTools.comp524f19.assignment1.testcases.load.QuoteTestedChecker;
import gradingTools.comp524f19.assignment1.testcases.load.QuoteTestedTwoResultsChecker;
import gradingTools.comp524f19.assignment1.testcases.loadLogical.AndTestedChecker;
import gradingTools.comp524f19.assignment1.testcases.loadLogical.AndTestedTwoResultsChecker;
import gradingTools.comp524f19.assignment1.testcases.loadLogical.NotTestedChecker;
import gradingTools.comp524f19.assignment1.testcases.loadLogical.NotTestedTwoResultsChecker;
import gradingTools.comp524f19.assignment1.testcases.loadLogical.OrTestedChecker;
import gradingTools.comp524f19.assignment1.testcases.loadLogical.OrTestedTwoResultsChecker;
import gradingTools.comp524f19.assignment1.testcases.loadRelation.GorETestedChecker;
import gradingTools.comp524f19.assignment1.testcases.loadRelation.GorETestedTwoResultsChecker;
import gradingTools.comp524f19.assignment1.testcases.loadRelation.GreaterTestedChecker;
import gradingTools.comp524f19.assignment1.testcases.loadRelation.GreaterTestedTwoResultsChecker;
import gradingTools.comp524f19.assignment1.testcases.loadRelation.LessTestedChecker;
import gradingTools.comp524f19.assignment1.testcases.loadRelation.LessTestedTwoResultsChecker;
import gradingTools.comp524f19.assignment1.testcases.loadRelation.LorETestedChecker;
import gradingTools.comp524f19.assignment1.testcases.loadRelation.LorETestedTwoResultsChecker;
import gradingTools.comp524f19.assignment1.testcases.toString.BaseCaseListToStringChecker;
import gradingTools.comp524f19.assignment1.testcases.toString.BaseCaseSExpressionToStringChecker;
import gradingTools.comp524f19.assignment1.testcases.toString.ListToStringChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.CombinationChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.CondChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.EvalChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.ListChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.ListChecker2;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.QuoteChecker;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispIsListChecker;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispIsListChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispIsListChecker3;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispIsListChecker4;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispToStringChecker;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispToStringChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispToStringChecker3;
import gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers.LispToStringChecker4;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LispLambdaChecker;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LispLambdaChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LispLambdaChecker3;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LoadLambdaChecker;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LoadLambdaChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LoadLambdaChecker3;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.LispSetqChecker;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.LispSetqChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.LoadSetqChecker;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.LoadSetqChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.LoadSetqChecker3;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.BasicAndChecker;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.BasicOrChecker;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.NotChecker;
import gradingTools.comp524f19.assignment2.testcases.RelationalCheckers.GreaterChecker;
import gradingTools.comp524f19.assignment2.testcases.RelationalCheckers.GreaterOrEqualChecker;
import gradingTools.comp524f19.assignment2.testcases.RelationalCheckers.LessChecker;
import gradingTools.comp524f19.assignment2.testcases.RelationalCheckers.LessOrEqualChecker;
import gradingTools.comp524f19.assignment4.requiredClasses.LoadLispChecker;
import gradingTools.comp524f20.assignment5.testcases.toString.ListToStringDeepChecker;
import gradingTools.comp524f20.assignment6.testcases.socialDistance.DerivedSafeChecker;
import gradingTools.comp524f21.assignment6.testCases.basicOperations.A6ExtraCondChecker;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(1)
@IsExtra(true)
public class A6CommonPropertiesInherited extends CommonPropertiesAreInheritedTestCase {
static final Class[] PRECEDING_TESTS = {
		CondChecker.class,
		QuoteChecker.class,
		EvalChecker.class,
		ListChecker.class,
		ListChecker2.class,
		CombinationChecker.class,
		BasicAndChecker.class,
		BasicOrChecker.class,
		NotChecker.class,
		GreaterChecker.class,
		GreaterOrEqualChecker.class,
		LessChecker.class,
		LessOrEqualChecker.class,
		LispSetqChecker.class,
		LispSetqChecker2.class,
		LoadSetqChecker.class,
		LoadSetqChecker2.class,
		LoadSetqChecker3.class,
		DerivedSafeChecker.class,
		LispLambdaChecker.class,
		LispLambdaChecker2.class,
		LispLambdaChecker3.class,
		LoadLambdaChecker.class,
		LoadLambdaChecker2.class,
		LoadLambdaChecker3.class,
		
};
@Override
protected Class[] precedingTests() {
	return PRECEDING_TESTS;
}
}
