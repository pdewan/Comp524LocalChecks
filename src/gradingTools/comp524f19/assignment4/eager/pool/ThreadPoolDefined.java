package gradingTools.comp524f19.assignment4.eager.pool;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.BasicProjectIntrospection;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f19.assignment4.eager.basic.EagerBasicList;
import main.lisp.evaluator.parallel.pool.NullThreadPool;
import main.lisp.evaluator.parallel.pool.ThreadPool;
import main.lisp.evaluator.parallel.pool.ThreadPoolSingleton;
import util.annotations.MaxValue;
@MaxValue(0)
public class ThreadPoolDefined extends PassFailJUnitTestCase {
	ThreadPool threadPoolProxy;

	public ThreadPool getThreadPoolProxy() {
		return threadPoolProxy;
	}

	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		// run main before checking thread singleton
		JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(EagerBasicList.class);
		ThreadPool aThreadPool = ThreadPoolSingleton.get();
		if (aThreadPool == null) {
			return fail("ThreadPoolSingleton.get() returns null");
		}
		if (aThreadPool instanceof NullThreadPool) {
			return fail("ThreadPoolSingleton.get() returns instance of NullThreadPool");
		}
		threadPoolProxy = (ThreadPool) BasicProjectIntrospection.createTimingOutProxy(ThreadPool.class, aThreadPool);
		return pass();
	}

}
