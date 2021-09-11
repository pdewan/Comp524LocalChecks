package gradingTools.comp524f21.assignment2.source;

import gradingTools.basics.sharedTestCase.checkstyle.CheckstyleInterfaceDefinedTestCase;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceClassRegistryProvided;
import util.annotations.MaxValue;
@MaxValue(2)
public class SocialDistanceViewISAPropertyListener extends CheckstyleInterfaceDefinedTestCase{
	final Class[] PRECEDING_TESTS = {
			SocialDistanceClassRegistryProvided.class

	};
	@Override
	protected Class[] precedingTests() {
			return PRECEDING_TESTS;
	}
	public SocialDistanceViewISAPropertyListener() {
		super("@SocialDistanceView", "java.beans.PropertyChangeListener");
		// TODO Auto-generated constructor stub
	}
	
}
