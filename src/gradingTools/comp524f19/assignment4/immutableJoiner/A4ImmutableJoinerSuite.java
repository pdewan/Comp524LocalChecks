package gradingTools.comp524f19.assignment4.immutableJoiner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.ClassRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.MainClassProvided;
import gradingTools.comp524f19.assignment2.testcases.OperationRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.SExpressionClassProvided;
import main.lisp.evaluator.parallel.pool.ThreadPoolWorker;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	A4EarlyJoinImmutableJoinerTester.class,
	A4LateJoinImmutableJoinerTester.class,
	EagerListChecker.class
	
})
	

//@MaxValue(50)
public class A4ImmutableJoinerSuite {
	
}
