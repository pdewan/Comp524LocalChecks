package gradingTools.comp524f19.assignment1.testcases.loadRelation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


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
