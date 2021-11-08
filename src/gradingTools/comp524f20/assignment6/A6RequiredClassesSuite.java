package gradingTools.comp524f20.assignment6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.ClassRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.MainClassProvided;
import gradingTools.comp524f19.assignment2.testcases.OperationRegistryProvided;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	ClassRegistryProvided.class,
//	ClassRegistryA3Provided.class,
	MainClassProvided.class,
//	OperationRegistryProvided.class
	
})
	

//@MaxValue(50)
public class A6RequiredClassesSuite {
	
}
