package gradingTools.comp524f19.assignment4.eager.basic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.ClassRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.MainClassProvided;
import gradingTools.comp524f19.assignment2.testcases.OperationRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.SExpressionClassProvided;
import gradingTools.comp524f19.assignment4.eager.basic.logical.EagerBasicAnd;
import gradingTools.comp524f19.assignment4.eager.basic.logical.EagerBasicNestedAnd;
import gradingTools.comp524f19.assignment4.eager.basic.logical.EagerBasicNestedOr;
import gradingTools.comp524f19.assignment4.eager.basic.logical.EagerBasicOr;
import main.lisp.evaluator.parallel.pool.ThreadPoolWorker;
import util.annotations.MaxValue;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	EarlyJoinBasicJoiner.class,
	LateJoinBasicJoiner.class,
	SynchronizedEnvironment.class,	
	EagerBasicList.class,
	EagerBasicNestedList.class,
	
	
})
	

public class EagerBasicSuite {
	
}
