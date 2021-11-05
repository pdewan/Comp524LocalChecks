package gradingTools.comp524f21.assignment5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f21.assignment5.style.a5specific.ComparatorEvaluatorCodeReuse;
import gradingTools.comp524f21.assignment5.style.a5specific.LTECallsNilAtomFactory;
import gradingTools.comp524f21.assignment5.style.a5specific.LTECallsTAtomFactory;
import gradingTools.comp524f21.assignment5.style.a5specific.LoadCallsInterpreterModelSingleton;
import gradingTools.comp524f21.assignment5.style.a5specific.LoadCallsNilAtomFactory;
import gradingTools.comp524f21.assignment5.style.a5specific.LoadCallsReadAllLines;
import gradingTools.comp524f21.assignment5.style.a5specific.LoadCallsTAtomFactory;
import gradingTools.comp524f21.assignment5.style.a5specific.MainCallsMain;
import gradingTools.comp524f21.assignment5.style.a5specific.MainRegistersOperators;
import gradingTools.comp524f21.assignment5.style.a5specific.MainSetsExpressionFactory;
import gradingTools.comp524f21.assignment5.style.a5specific.NotCallsNilAtomFactory;
import gradingTools.comp524f21.assignment5.style.a5specific.NotCallsTAtomFactory;
import util.annotations.IsExtra;

@RunWith(Suite.class)
@Suite.SuiteClasses({
ComparatorEvaluatorCodeReuse.class,
MainRegistersOperators.class,
LoadCallsInterpreterModelSingleton.class,
MainSetsExpressionFactory.class,
MainCallsMain.class,
LoadCallsReadAllLines.class,	
LoadCallsTAtomFactory.class,
LoadCallsNilAtomFactory.class,
NotCallsTAtomFactory.class,
NotCallsNilAtomFactory.class,
LTECallsTAtomFactory.class,
LTECallsNilAtomFactory.class,
})

//@MaxValue(50)
@IsExtra(true)
public class F21A5AssignmentSpecificStyle {
	public static void main (String[] args) {
		try {
			BasicJUnitUtils.interactiveTest(F21A5AssignmentSpecificStyle.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
