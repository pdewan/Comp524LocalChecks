package gradingTools.comp524f21.assignment5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f21.assignment5.style.a5specific.ComparatorEvaluatorCodeReuse;
import gradingTools.comp524f21.assignment5.style.a5specific.LTECallsNilAtomFactory;
import gradingTools.comp524f21.assignment5.style.a5specific.LTECallsTAtomFactory;
import gradingTools.comp524f21.assignment5.style.a5specific.LoadCallsInterpreterModelSingleton;
import gradingTools.comp524f21.assignment5.style.a5specific.LoadCallsNewInput;
import gradingTools.comp524f21.assignment5.style.a5specific.LoadCallsNilAtomFactory;
import gradingTools.comp524f21.assignment5.style.a5specific.LoadCallsReadAllLines;
import gradingTools.comp524f21.assignment5.style.a5specific.LoadCallsTAtomFactory;
import gradingTools.comp524f21.assignment5.style.a5specific.MainCallsSkeletonMain;
import gradingTools.comp524f21.assignment5.style.a5specific.MainCallsOperationRegisterer;
import gradingTools.comp524f21.assignment5.style.a5specific.MainSetsExpressionFactory;
import gradingTools.comp524f21.assignment5.style.a5specific.NotCallsNilAtomFactory;
import gradingTools.comp524f21.assignment5.style.a5specific.NotCallsTAtomFactory;
import gradingTools.comp524f21.assignment5.style.a5specific.ToStringAsListCallsHelper;
import gradingTools.comp524f21.assignment5.style.a5specific.ToStringAsListHelperIsRecursive;
import gradingTools.comp524f21.assignment5.style.a5specific.ToStringCallsToStringAsList;
import util.annotations.IsExtra;

@RunWith(Suite.class)
@Suite.SuiteClasses({
ComparatorEvaluatorCodeReuse.class,
MainCallsOperationRegisterer.class,
LoadCallsInterpreterModelSingleton.class,
LoadCallsNewInput.class,
MainSetsExpressionFactory.class,
MainCallsSkeletonMain.class,
LoadCallsReadAllLines.class,	
LoadCallsTAtomFactory.class,
LoadCallsNilAtomFactory.class,
NotCallsTAtomFactory.class,
NotCallsNilAtomFactory.class,
LTECallsTAtomFactory.class,
LTECallsNilAtomFactory.class,
ToStringAsListCallsHelper.class,
ToStringCallsToStringAsList.class,
ToStringAsListHelperIsRecursive.class,
})

//@MaxValue(50)
@IsExtra(true)
public class F21A5AssignmentSpecificSourceChecks {
	public static void main (String[] args) {
		try {
			BasicJUnitUtils.interactiveTest(F21A5AssignmentSpecificSourceChecks.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
