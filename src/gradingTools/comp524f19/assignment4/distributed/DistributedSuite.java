package gradingTools.comp524f19.assignment4.distributed;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.ClassRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.MainClassProvided;
import gradingTools.comp524f19.assignment2.testcases.OperationRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.SExpressionClassProvided;
import gradingTools.comp524f19.assignment4.distributed.basic.DistributedBasic;
import gradingTools.comp524f19.assignment4.distributed.collaborative.DistributedCollaborative;
import main.lisp.evaluator.parallel.pool.ThreadPoolWorker;
import util.annotations.MaxValue;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	DistributedBasic.class,
	DistributedCollaborative.class
})
	

public class DistributedSuite {
	
}
