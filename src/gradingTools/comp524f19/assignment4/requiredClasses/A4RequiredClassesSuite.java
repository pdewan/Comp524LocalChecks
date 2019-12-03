package gradingTools.comp524f19.assignment4.requiredClasses;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment1.testcases.load.LoadChecker;
import gradingTools.comp524f19.assignment2.testcases.ClassRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.MainClassProvided;
import gradingTools.comp524f19.assignment2.testcases.OperationRegistryProvided;
import gradingTools.comp524f19.assignment2.testcases.SExpressionClassProvided;
import main.lisp.evaluator.parallel.pool.ThreadPoolWorker;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	ClassRegistryProvided.class,
	ClassRegistryA4Provided.class,
	SExpressionClassProvided.class,
	MainClassProvided.class,
//	OperationRegistryProvided.class,
	TestLispFileProvided.class,
	LoadLispChecker.class,
	LoadFile.class,
	ImmmutableJoinerClassProvided.class,
	MutableJoinerClassProvided.class,
	ThreadPoolClassProvided.class,
	ThreadPoolWorkerClassProvided.class
	
})
	

//@MaxValue(50)
public class A4RequiredClassesSuite {
	
}
