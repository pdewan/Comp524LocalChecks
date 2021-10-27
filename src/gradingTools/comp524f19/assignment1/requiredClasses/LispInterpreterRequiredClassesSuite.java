package gradingTools.comp524f19.assignment1.requiredClasses;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment1.testcases.ClassRegistryProvided;
import gradingTools.comp524f19.assignment1.testcases.MainClassProvided;
import gradingTools.comp524f19.assignment1.testcases.SExpressionClassProvided;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	ClassRegistryProvided.class,
//	SExpressionClassProvided.class,
	MainClassProvided.class
	
})
	

//@MaxValue(50)
public class LispInterpreterRequiredClassesSuite {
	
}
