package gradingTools.comp524f21.assignment6.specificStyle;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleMethodCalledTestCase;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.LispSetqChecker;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.LispSetqChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.LoadSetqChecker;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.LoadSetqChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.LoadSetqChecker3;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(2)
//@IsExtra(true)
public class IdentifierCallsOptionalGet extends CheckstyleMethodCalledTestCase{
	
	protected static final Class[] prereq= {
			LispSetqChecker.class,
			LispSetqChecker2.class,
			LoadSetqChecker.class,
			LoadSetqChecker2.class,
			LoadSetqChecker3.class
	};
	
	@Override
	protected Class[] precedingTests() {
			return prereq;
	}
	
	public IdentifierCallsOptionalGet() {
		super("IdentifierAtomWithLookup", "java.util.Optional!get:->Object");
	}
	
}
