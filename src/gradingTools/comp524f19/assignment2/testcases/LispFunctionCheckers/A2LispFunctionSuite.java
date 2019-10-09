package gradingTools.comp524f19.assignment2.testcases.LispFunctionCheckers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import util.annotations.MaxValue;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestLispFileProvided.class,
	LoadLispChecker.class,
	LispIsListChecker.class,
	LispIsListChecker2.class,
	LispIsListChecker3.class,
	LispIsListChecker4.class,
	LispToStringChecker.class,
	LispToStringChecker2.class,
	LispToStringChecker3.class,
	LispToStringChecker4.class
	
})
	

public class A2LispFunctionSuite {
	
}
