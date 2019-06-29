package gradingTools.comp524f19.assignment1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment1.testcases.CustomCommandIncrementalPromptTestCase;
import gradingTools.comp524f19.assignment1.testcases.CustomCommandPromptTestCase;
import gradingTools.comp524f19.assignment1.testcases.IncrementalInputPromptTestCase;
import gradingTools.comp524f19.assignment1.testcases.PromptTestCase;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	PromptTestCase.class,
	IncrementalInputPromptTestCase.class
})


public class PromptSuite {
	
}
