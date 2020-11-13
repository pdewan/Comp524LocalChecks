package gradingTools.comp524f20.assignment6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.BasicAndChecker;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.BasicOrChecker;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.NotChecker;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.VariableArgumentAndChecker;
import gradingTools.comp524f19.assignment2.testcases.LogicalCheckers.VariableArgumentOrChecker;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	BasicAndChecker.class,
	BasicOrChecker.class,
	NotChecker.class,
	VariableArgumentAndChecker.class,
	VariableArgumentOrChecker.class	
})
	

public class LogicalSuite {
	
}
