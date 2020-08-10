package gradingTools.comp524f19.assignment4.eager.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.BasicProjectIntrospection;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f19.assignment1.testcases.MainClassProvided;
import gradingTools.comp524f19.assignment4.requiredClasses.ImmmutableJoinerClassProvided;
import main.ClassRegistry;
import main.util.parallel.Joiner;
import util.annotations.MaxValue;
import util.misc.ThreadSupport;
import util.trace.Tracer;
@MaxValue(20)
public class LateJoinBasicJoinerNonReusing extends EarlyJoinBasicJoiner {
	
	

	protected void setTimeouts() {
		slaveTimeout = 0;
		masterTimeout = 300;
	}
	
	

}
