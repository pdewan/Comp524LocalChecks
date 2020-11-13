package gradingTools.comp524f20.assignment6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.RelationalCheckers.GreaterChecker;
import gradingTools.comp524f19.assignment2.testcases.RelationalCheckers.GreaterOrEqualChecker;
import gradingTools.comp524f19.assignment2.testcases.RelationalCheckers.LessChecker;
import gradingTools.comp524f19.assignment2.testcases.RelationalCheckers.LessOrEqualChecker;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	GreaterChecker.class,
	GreaterOrEqualChecker.class,
	LessChecker.class,
	LessOrEqualChecker.class
	
})
	

public class RelationalSuite {
	
}
