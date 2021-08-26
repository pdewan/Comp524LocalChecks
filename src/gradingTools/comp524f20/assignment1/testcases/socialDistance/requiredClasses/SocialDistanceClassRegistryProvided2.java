package gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.BasicProjectIntrospection;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f20.assignment1.SocialDistanceClassRegistry;
import gradingTools.comp524f20.assignment1.socialDistance.testInterfaces.TestModelInterface;
import gradingTools.shared.testcases.utils.ConfigurationWriter;
//@MaxValue(2)
public class SocialDistanceClassRegistryProvided2 extends PassFailJUnitTestCase {
	public static final Class REGISTRY_INTERFACE = SocialDistanceClassRegistry.class;
	public Object classRegistry;
	public TestModelInterface timingOutClassRegistryProxy;

//	public SocialDistanceClassRegistry getClassRegistry() {
//		return classRegistry;
//	}
//	public SocialDistanceClassRegistry getTimingOutClassRegistryProxy() {
//		return timingOutClassRegistryProxy;
//	}

	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {		
			classRegistry = (SocialDistanceClassRegistry) BasicProjectIntrospection.createInstanceOfPredefinedSupertype(REGISTRY_INTERFACE);
			if (classRegistry == null)	{
				
				return fail("No registry class in classa path:" + System.getProperty("java.class.path"));
			}

			timingOutClassRegistryProxy = (TestModelInterface) BasicProjectIntrospection.createTimingOutProxy(TestModelInterface.class, classRegistry);
			
			 ConfigurationWriter.writeConfiguration(project, classRegistry);
			return pass();		
	}

}