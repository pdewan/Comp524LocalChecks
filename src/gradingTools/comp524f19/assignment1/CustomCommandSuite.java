package gradingTools.comp524f19.assignment1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment1.testcases.CustomCommandIncrementalPromptTestCase;
import gradingTools.comp524f19.assignment1.testcases.CustomCommandPromptTestCase;
import util.annotations.MaxValue;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	CustomCommandIncrementalPromptTestCase.class,
	CustomCommandPromptTestCase.class
})

@MaxValue(20)
public class CustomCommandSuite {
	
}
