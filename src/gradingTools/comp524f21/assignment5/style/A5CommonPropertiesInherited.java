package gradingTools.comp524f21.assignment5.style;

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
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.CombinationChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.CondChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.EvalChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.ListChecker;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.ListChecker2;
import gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers.QuoteChecker;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.BasicAndChecker;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.BasicOrChecker;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.NotChecker;
import gradingTools.comp524f19.assignment2.testcases.RelationalCheckers.GreaterChecker;
import gradingTools.comp524f19.assignment2.testcases.RelationalCheckers.GreaterOrEqualChecker;
import gradingTools.comp524f19.assignment2.testcases.RelationalCheckers.LessChecker;
import gradingTools.comp524f19.assignment2.testcases.RelationalCheckers.LessOrEqualChecker;
import gradingTools.comp524f19.assignment4.requiredClasses.LoadLispChecker;
import gradingTools.comp524f21.assignment5.toString.ListToStringCheckerAdvanced;
import gradingTools.comp524f21.assignment5.toString.ListToStringCheckerBasic;
import gradingTools.comp524f21.assignment5.toString.ListToStringDeepCheckerAdvanced;
import gradingTools.comp524f21.assignment5.toString.ListToStringDeepCheckerBasic;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(1)
@IsExtra(true)
public class A5CommonPropertiesInherited extends CommonPropertiesAreInheritedTestCase {
public static final Class[] PRECEDING_TESTS = {
		GreaterTestedChecker.class,
		GreaterTestedTwoResultsChecker.class,
		LessTestedChecker.class,
		LessTestedTwoResultsChecker.class,
		GorETestedChecker.class,
		GorETestedTwoResultsChecker.class,
		LorETestedChecker.class,
		LorETestedTwoResultsChecker.class,
		AndTestedChecker.class,
		AndTestedTwoResultsChecker.class,
		NotTestedChecker.class,
		NotTestedTwoResultsChecker.class,
		OrTestedChecker.class,
		OrTestedTwoResultsChecker.class,
//		LoadChecker.class,
		LoadLispChecker.class,
		ConsTestedChecker.class,
		QuoteTestedChecker.class,
		ListTestedChecker.class,
		EvalTestedChecker.class,
		CondTestedChecker.class,
		ConsTestedTwoResultsChecker.class,
		QuoteTestedTwoResultsChecker.class,
		ListTestedTwoResultsChecker.class,
		EvalTestedTwoResultsChecker.class,
		CondTestedResultsChecker.class,
		BaseCaseSExpressionToStringChecker.class,
		BaseCaseListToStringChecker.class,
		ListToStringCheckerBasic.class,
		ListToStringCheckerAdvanced.class,
		ListToStringDeepCheckerBasic.class,
		ListToStringDeepCheckerAdvanced.class,
		
		// added F24
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
		
};
@Override
protected Class[] precedingTests() {
	return PRECEDING_TESTS;
}
}
