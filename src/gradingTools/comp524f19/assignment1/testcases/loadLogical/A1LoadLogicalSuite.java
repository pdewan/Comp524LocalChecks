package gradingTools.comp524f19.assignment1.testcases.loadLogical;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment1.testcases.ClassRegistryProvided;
import gradingTools.comp524f19.assignment1.testcases.MainClassProvided;
import gradingTools.comp524f19.assignment1.testcases.SExpressionClassProvided;
import gradingTools.comp524f19.assignment1.testcases.toString.BaseCaseSExpressionToStringChecker;
import util.annotations.MaxValue;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestLispFileProvided.class,
	LoadChecker.class,
	AndTestedChecker.class,
	AndTestedTwoResultsChecker.class,
	NotTestedChecker.class,
	NotTestedTwoResultsChecker.class,
	OrTestedChecker.class,
	OrTestedTwoResultsChecker.class
	
})
	

//@MaxValue(50)
public class A1LoadLogicalSuite {
	
}