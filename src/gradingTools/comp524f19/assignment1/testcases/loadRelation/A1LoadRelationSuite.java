package gradingTools.comp524f19.assignment1.testcases.loadRelation;

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
	GreaterTestedChecker.class,
	GreaterTestedTwoResultsChecker.class,
	LessTestedChecker.class,
	LessTestedTwoResultsChecker.class,
	GorETestedChecker.class,
	GorETestedTwoResultsChecker.class,
	LorETestedChecker.class,
	LorETestedTwoResultsChecker.class
	
})
	

//@MaxValue(50)
public class A1LoadRelationSuite {
	
}
