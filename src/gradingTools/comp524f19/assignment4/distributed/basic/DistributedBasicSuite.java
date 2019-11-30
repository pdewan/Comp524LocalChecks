package gradingTools.comp524f19.assignment4.distributed.basic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.ClassRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.MainClassProvided;
import gradingTools.comp524f19.assignment2.testcases.OperationRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.SExpressionClassProvided;
import gradingTools.comp524f19.assignment4.distributed.basic.DistributedBasicClientAndServerInput;
import gradingTools.comp524f19.assignment4.distributed.basic.DistributedBasicClientInput;
import gradingTools.comp524f19.assignment4.distributed.collaborative.DistributedCollaborativeClient2AndServerInput;
import gradingTools.comp524f19.assignment4.distributed.collaborative.DistributedCollaborativeClient2Input;
import gradingTools.comp524f19.assignment4.distributed.collaborative.DistributedCollaborativeClient2ServerAndClient1Input;
import main.lisp.evaluator.parallel.pool.ThreadPoolWorker;
import util.annotations.MaxValue;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	DistributedBasicClientInput.class,
	DistributedBasicClientAndServerInput.class
	
})
	

public class DistributedBasicSuite {
	
}
