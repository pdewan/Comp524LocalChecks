package gradingTools.comp524f19.assignment4.eager.pool;

import static org.junit.Assert.assertTrue;

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
import gradingTools.comp524f19.assignment4.eager.basic.EarlyJoinBasicJoiner;
import gradingTools.comp524f19.assignment4.requiredClasses.ImmmutableJoinerClassProvided;
import gradingTools.comp524f19.assignment4.requiredClasses.MutableJoinerClassProvided;
import main.ClassRegistry;
import main.util.parallel.Joiner;
import main.util.parallel.MutableJoiner;
import util.annotations.MaxValue;
import util.misc.ThreadSupport;
import util.trace.Tracer;

@MaxValue(5)
public class LateJoinMutableJoinerNonReusing extends EarlyJoinMutableJoinerNonReusing {
	protected void setTimeouts() {
		slaveTimeout = 0;
		masterTimeout = 300;
	}
}
