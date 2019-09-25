package gradingTools.comp524f19.assignment2.testcases.BasicOperationCheckers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import util.annotations.MaxValue;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	CondChecker.class,
	ExtraCondChecker.class,
	QuoteChecker.class,
	EvalChecker.class,
	ListChecker.class,
	ListChecker2.class,
	CombinationChecker.class
	
})
	

public class A2BasicOperationSuite {
	
}
