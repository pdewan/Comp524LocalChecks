package gradingTools.comp524f19.assignment4.eager.basic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.ClassRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.MainClassProvided;
import gradingTools.comp524f19.assignment2.testcases.OperationRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.SExpressionClassProvided;
import main.lisp.evaluator.parallel.pool.ThreadPoolWorker;
import util.annotations.MaxValue;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	EarlyJoinBasicJoinerTester.class,
	LateJoinBasicJoinerTester.class,
	EagerBasicListChecker.class,
	SynchronizedEnvironment.class
	
})
	

public class EagerBasicSuite {
	
}
