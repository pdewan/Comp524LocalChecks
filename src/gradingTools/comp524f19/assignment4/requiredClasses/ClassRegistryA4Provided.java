package gradingTools.comp524f19.assignment4.requiredClasses;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.BasicProjectIntrospection;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import main.ClassRegistryA4;
//@MaxValue(10)
public class ClassRegistryA4Provided extends PassFailJUnitTestCase {
	public static final Class REGISTRY_INTERFACE = ClassRegistryA4.class;
	public ClassRegistryA4 classRegistry;
	public ClassRegistryA4 timingOutClassRegistryProxy;

	public ClassRegistryA4 getClassRegistry() {
		return classRegistry;
	}
	public ClassRegistryA4 getTimingOutClassRegistryProxy() {
		return timingOutClassRegistryProxy;
	}
	protected Class registryClass() {
		return REGISTRY_INTERFACE;
	}

	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {		
			classRegistry = (ClassRegistryA4) BasicProjectIntrospection.createInstanceOfPredefinedSupertype(REGISTRY_INTERFACE);
			if (classRegistry == null)	{
				
				return fail("No class implementing:" + registryClass().getCanonicalName() + " in class path:" + System.getProperty("java.class.path"));
			}
			timingOutClassRegistryProxy = (ClassRegistryA4) BasicProjectIntrospection.createTimingOutProxy(REGISTRY_INTERFACE, classRegistry);
			return pass();		
	}

}
