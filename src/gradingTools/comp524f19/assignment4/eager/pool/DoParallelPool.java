package gradingTools.comp524f19.assignment4.eager.pool;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import main.lisp.evaluator.parallel.pool.AbstractThreadPool;
import main.lisp.evaluator.parallel.pool.ThreadPool;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
import util.trace.Tracer;
@IsExtra(true)
@MaxValue(50)
public class DoParallelPool extends PassFailJUnitTestCase implements Runnable{
	protected ThreadPool threadPoolProxy;
	protected Set<Thread> childThreadsFirstPass = new HashSet<>();
	protected Set<Thread> childThreadsSecondPass = new HashSet<>();
	protected boolean isFirstPass = true;
	protected int numRunnables = 5;
	protected int numChildThreads = numRunnables - 1;
//	protected Thread parentThread;
//	protected boolean parentThreadInFirstPass = false;
//	protected boolean parentThreadInSecondPass = false;
	protected Runnable[] runnables = new Runnable[numRunnables];
	protected int maxThreadNumberFirstPass = -1;
	protected int maxThreadNumberSecondPass = -1;
	protected boolean passed = false;
	protected int poolCountAfterDoParallel;




//	int count;
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		ThreadPoolDefined aThreadPoolDefined = (ThreadPoolDefined) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(ThreadPoolDefined.class);
		threadPoolProxy =  aThreadPoolDefined.getThreadPoolProxy();
		Thread parentThread = Thread.currentThread();
		if (threadPoolProxy == null) {
			return fail("ThreadPoolDefined test case failed");
		}
		createRunnables();
		isFirstPass = true;
		threadPoolProxy.doParallel(runnables);
		if (maxThreadNumberFirstPass == -1 ) {
			return fail("Thread names did not follow constraint or thread pool not correctly implemented");
		}
//		if (!parentThreadInFirstPass) {
//			return fail("Parent thread did not invoke runnable in doParallel in first pass");
//		}
		if (childThreadsFirstPass.size() != numChildThreads) {
			return fail("Expected #threads:"+ numChildThreads + " Actual threads:" + childThreadsFirstPass);

		}
		int aCountAfterFirstPass = threadPoolProxy.getCount();
		isFirstPass = false;
		threadPoolProxy.doParallel(runnables);
//		if (!parentThreadInSecondPass) {
//			return fail("Parent thread did not invoke runnable in doParallel in second pass");
//		}
		if (childThreadsSecondPass.size() != numChildThreads) {
			return fail("Expected #threads:"+ numChildThreads + " Actual threads:" + childThreadsSecondPass);

		}
		if (maxThreadNumberSecondPass >= aCountAfterFirstPass) {
			return partialPass(0.5, 
					"Threads not reused? Thread count after first pass:" + aCountAfterFirstPass +
					"maxThreadNumberSecondPass:" + maxThreadNumberSecondPass);

		}
		passed = true;
		poolCountAfterDoParallel = aCountAfterFirstPass;
		return pass();
	}
	public int getPoolCountAfterDoParallel() {
		return poolCountAfterDoParallel;
	}
	public boolean isPassed() {
		return passed;
	}
	@Override
	public synchronized void run() {
//		System.out.println("Run called");
//		count++;
		Thread aThread = Thread.currentThread();
		Tracer.info("DoParallel Thread:" + aThread);
		int aChildThreadNumber = getWorkerNumberFromThreadName(aThread.getName());
		if (aChildThreadNumber < 0) {
			return;
		};

		if (isFirstPass) {
			
				childThreadsFirstPass.add(aThread);
				maxThreadNumberFirstPass = Math.max(maxThreadNumberFirstPass, aChildThreadNumber);
			
		} else {
			
				childThreadsSecondPass.add(aThread);
				maxThreadNumberSecondPass = Math.max(maxThreadNumberSecondPass, aChildThreadNumber);
			
		}
	}
	
	public static int getWorkerNumberFromThreadName(String aThreadName) {
		try {
			String aWorkerNumberSubstring = StringUtils.substringAfter(aThreadName, AbstractThreadPool.WORKER_THREAD_NAME_PREFIX);
			return Integer.parseInt(aWorkerNumberSubstring);
		} catch (Exception e) {
			return -1;
		}
		
	}
	
	protected void createRunnables() {
		
		for (int i = 0; i < numRunnables; i++) {
			runnables[i] = this;
		}
	}

}
