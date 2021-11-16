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
public class IdentifierCallsEnvironmentLookup extends CheckstyleMethodCalledTestCase{
	
	
	@Override
	protected Class[] precedingTests() {
			return IdentifierCallsOptionalGet.prereq;
	}
	
	public IdentifierCallsEnvironmentLookup() {
		super("IdentifierAtomWithLookup", "main.lisp.evaluator.Environment!lookup:main.lisp.parser.terms.IdentifierAtom->Optional");
	}
	
}
