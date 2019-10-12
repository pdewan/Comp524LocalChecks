package gradingTools.comp524f19.assignment2.requiredClasses;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.ClassRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.MainClassProvided;
import gradingTools.comp524f19.assignment2.testcases.OperationRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.SExpressionClassProvided;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	ClassRegistryProvided.class,
	SExpressionClassProvided.class,
	MainClassProvided.class,
	OperationRegistryProvided.class
	
})
	

//@MaxValue(50)
public class A2RequiredClassesSuite {
	
}
