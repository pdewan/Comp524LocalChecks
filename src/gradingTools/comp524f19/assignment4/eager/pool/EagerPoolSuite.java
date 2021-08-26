package gradingTools.comp524f19.assignment4.eager.pool;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	EarlyJoinMutableJoiner.class,
	LateJoinMutableJoiner.class,
	ThreadPoolDefined.class,
	DoParallelPool.class,
	EagerPoolList.class,
	EagerPoolNestedList.class,
	EagerPoolNestedAnd.class,
	EagerPoolNestedOr.class,

//	LateJoinBasicJoinerTester.class,
//	EagerBasicListChecker.class
	
})
	

//@MaxValue(50)
public class EagerPoolSuite {
	
}
