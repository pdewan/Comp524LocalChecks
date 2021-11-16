package gradingTools.comp524f21.assignment6.style;

import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.A1NoCheckstyleWarnings;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(10)
@IsExtra(true)
public class F21A6NoCheckstyleWarnings extends A1NoCheckstyleWarnings {
	@Override
	protected Class[] precedingTests() {
		return A6CommonPropertiesInherited.PRECEDING_TESTS;
	}
}
