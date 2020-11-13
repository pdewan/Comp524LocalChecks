package gradingTools.comp524f20.assignment6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.LispSetqChecker;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.LispSetqChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.LoadSetqChecker;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.LoadSetqChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispSetqCheckers.LoadSetqChecker3;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	LispSetqChecker.class,
	LispSetqChecker2.class,
	LoadSetqChecker.class,
	LoadSetqChecker2.class,
	LoadSetqChecker3.class
	
	
})
	

public class LispSetqSuite {
	
}
