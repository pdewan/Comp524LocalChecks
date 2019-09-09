package gradingTools.comp524f19.assignment1.testcases;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.BasicProjectIntrospection;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import main.ClassRegistry;
import util.annotations.MaxValue;
//@MaxValue(10)
public class ClassRegistryProvided extends PassFailJUnitTestCase {
	public static final Class REGISTRY_INTERFACE = ClassRegistry.class;
	public ClassRegistry classRegistry;
	public ClassRegistry timingOutClassRegistryProxy;

	public ClassRegistry getClassRegistry() {
		return classRegistry;
	}
	public ClassRegistry getTimingOutClassRegistryProxy() {
		return timingOutClassRegistryProxy;
	}

	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {		
			classRegistry = (ClassRegistry) BasicProjectIntrospection.createInstanceOfPredefinedSupertype(REGISTRY_INTERFACE);
			if (classRegistry == null)	{
				return fail("No registry class");
			}
			timingOutClassRegistryProxy = (ClassRegistry) BasicProjectIntrospection.createTimingOutProxy(REGISTRY_INTERFACE, classRegistry);
			return pass();		
	}

}
