package gradingTools.comp524f21.assignment5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f21.assignment5.style.a5specific.ComparatorEvaluatorCodeReuse;
import gradingTools.comp524f21.assignment5.style.a5specific.MainSetsExpressionFactory;
import gradingTools.comp524f21.assignment5.style.a5specific.MainCallsMain;
import gradingTools.comp524f21.assignment5.style.a5specific.LoadCallsInterpreterModelSingleton;
import gradingTools.comp524f21.assignment5.style.a5specific.LoadCallsReadAllLines;
import gradingTools.comp524f21.assignment5.style.a5specific.MainRegistersOperators;
import util.annotations.IsExtra;

@RunWith(Suite.class)
@Suite.SuiteClasses({
ComparatorEvaluatorCodeReuse.class,
MainRegistersOperators.class,
LoadCallsInterpreterModelSingleton.class,
MainSetsExpressionFactory.class,
MainCallsMain.class,
LoadCallsReadAllLines.class,	
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
