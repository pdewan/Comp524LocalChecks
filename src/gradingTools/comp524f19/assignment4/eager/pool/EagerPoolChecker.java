package gradingTools.comp524f19.assignment4.eager.pool;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.GradingMode;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import gradingTools.comp524f19.assignment4.eager.basic.EagerBasicChecker;
import gradingTools.comp524f19.assignment4.eager.basic.EagerBasicList;
import gradingTools.interpreter.checkers.ADiffPatchChecker;
import gradingTools.interpreter.checkers.CheckerResult;
import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.OperationRegisterer;
import main.lisp.evaluator.parallel.pool.AbstractThreadPool;
import main.lisp.evaluator.parallel.pool.ThreadPool;
import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
import util.misc.ThreadSupport;
import util.trace.Tracer;

public abstract class EagerPoolChecker extends EagerBasicChecker {
	protected int poolCountAferDoParallel;
//	public static long WAIT_FOR_OUTPUT_TIME = 2000;
	
	protected abstract int numExpectedChildThreads();
//	protected String[] listenableEvaluatorsArray() {
//		return new String[] {"printThread"};
//	}
	public static int getWorkerNumberFromThreadToString(String aThreadToString) {
		try {
			String aWorkerNumberSubstring = StringUtils.substringBetween(aThreadToString, AbstractThreadPool.WORKER_THREAD_NAME_PREFIX, ",");
			return Integer.parseInt(aWorkerNumberSubstring);
		} catch (Exception e) {
			return -1;
		}
		
	}
	protected TestCaseResult checkPrintThreads() {
		Tracer.info(this, "Waiting for threads output for ms: " + WAIT_FOR_OUTPUT_TIME);
		ThreadSupport.sleep(WAIT_FOR_OUTPUT_TIME);
		Set<String> aThreadNames = new HashSet();
		String aParentThreadName = null;
		int aNumChildThreads = 0;
		for (SExpression anEvaluatorResult:evaluatorResults) {
			String aThreadName = anEvaluatorResult.toString();
			int aThreadNumber = getWorkerNumberFromThreadToString(aThreadName);
			if (aThreadNumber >= 0) {
				aNumChildThreads++;
				aThreadNames.add(aThreadName);
			}
			if (aThreadNumber > poolCountAferDoParallel) {
				return fail("aThreadNumber:" + aThreadNumber + " in thread name:" + aThreadName + " > poolCountAferDoParallel:" + poolCountAferDoParallel);
			}
//			if (aThreadNumber < 0) {
//				aParentThreadName = aThreadName;
//			} else {
//				aThreadNames.add(anEvaluatorResult.toString());	
//			}
		}
//		int aNumChildThreads = aThreadNames.size();
//		if (aParentThreadName == null) {
//			return fail("Parent thread (Thread name without pool worker name) did not printThread");
//		}
		int aNumExpectedThreads = numExpectedChildThreads();
		if (aNumChildThreads != aNumExpectedThreads) {
			return fail ("Expected # worker threads:" + aNumExpectedThreads+ " Actual worker threads:" + aThreadNames);
		}
		return pass();
	}
	protected TestCaseResult compareOutput() {
		DoParallelPool aDoParallelPool = (DoParallelPool) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(DoParallelPool.class);;
		if (!aDoParallelPool.isPassed()) {
			return fail(DoParallelPool.class.getName() + " failed, fix it before running this test");
		}
		poolCountAferDoParallel = aDoParallelPool.getPoolCountAfterDoParallel();
		return super.compareOutput();
		
				
	}
	
}
