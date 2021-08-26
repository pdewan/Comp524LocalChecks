package gradingTools.comp524f20.assignment6;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.BasicProjectIntrospection;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import main.ClassRegistryA3;
//@MaxValue(10)
public class ClassRegistryA3Provided extends PassFailJUnitTestCase {
	public static final Class REGISTRY_INTERFACE = ClassRegistryA3.class;
	public ClassRegistryA3 classRegistry;
	public ClassRegistryA3 timingOutClassRegistryProxy;

	public ClassRegistryA3 getClassRegistry() {
		return classRegistry;
	}
	public ClassRegistryA3 getTimingOutClassRegistryProxy() {
		return timingOutClassRegistryProxy;
	}
	protected Class registryClass() {
		return REGISTRY_INTERFACE;
	}

	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {		
			classRegistry = (ClassRegistryA3) BasicProjectIntrospection.createInstanceOfPredefinedSupertype(REGISTRY_INTERFACE);
			if (classRegistry == null)	{
				
				return fail("No class implementing:" + registryClass().getCanonicalName() + " in class path:" + System.getProperty("java.class.path"));
			}
			timingOutClassRegistryProxy = (ClassRegistryA3) BasicProjectIntrospection.createTimingOutProxy(REGISTRY_INTERFACE, classRegistry);
			return pass();		
	}

}
