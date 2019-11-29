package gradingTools.comp524f19.assignment4.eager.pool;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.ClassRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.MainClassProvided;
import gradingTools.comp524f19.assignment2.testcases.OperationRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.SExpressionClassProvided;
import main.lisp.evaluator.parallel.pool.ThreadPoolWorker;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	EarlyJoinMutableJoiner.class,
	LateJoinMutableJoiner.class,
	ThreadPoolDefined.class,
	DoParallelPool.class,
	EagerPoolListChecker.class
//	LateJoinBasicJoinerTester.class,
//	EagerBasicListChecker.class
	
})
	

//@MaxValue(50)
public class EagerPoolSuite {
	
}
