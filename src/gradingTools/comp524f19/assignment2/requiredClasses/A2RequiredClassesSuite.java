package gradingTools.comp524f19.assignment2.requiredClasses;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment2.testcases.ClassRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.MainClassProvided;
import gradingTools.comp524f19.assignment2.testcases.OperationRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.SExpressionClassProvided;
import util.annotations.MaxValue;


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
