package gradingTools.comp524f19.assignment2.testcases.RelationalCheckers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import util.annotations.MaxValue;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	GreaterChecker.class,
	GreaterOrEqualChecker.class,
	LessChecker.class,
	LessOrEqualChecker.class
	
})
	

public class A2RelationalSuite {
	
}
