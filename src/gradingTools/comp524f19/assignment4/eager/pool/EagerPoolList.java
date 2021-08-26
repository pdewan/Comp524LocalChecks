package gradingTools.comp524f19.assignment4.eager.pool;

import org.apache.commons.lang.StringUtils;

import main.lisp.evaluator.parallel.pool.AbstractThreadPool;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(25)
@IsExtra(true)
public class EagerPoolList extends EagerPoolChecker {
	public static final String[] STUDENT_INPUT = 
//		{"(funcall curriedNumAtoms (list 2 (cons 4 5)))"};
		{
	 "(setEvalMode \"EAGER\")",
	 "(setEagerPool T)",
	 "(list ",
	    "(progn" ,
		     "(printThread)", 
		     "(+ 1 2)", 
	     ")",
	   "(progn " ,
		    "(sleep 100)" , 
		    "(printThread)",  
		     "(- 2 1)", 
	     ")",
	    "(progn",
		     "(sleep 100)", 
		      "(printThread)",
		     "(- 2 1)", 
	     ")",
	  ")",
//	  "(list ",
//	    "(progn" ,
//		     "(printThread)", 
//		     "(+ 1 2)", 
//	     ")",
//	   "(progn " ,
//		    "(sleep 100)" , 
//		    "(printThread)",  
//		     "(- 2 1)", 
//	     ")",
//	    "(progn",
//		     "(sleep 100)", 
//		      "(printThread)",
//		     "(- 2 1)", 
//	     ")",
//	  ")"
//	 "(list ",
//		    "(progn" ,
//		     "(printThread)", 
//		     "(+ 1 2)", 
//		     ")",
//		   "(progn " ,
//		    "(sleep 100)" , 
//		    "(printThread)",  
//		     "(- 2 1)", 
//		     ")",
//		    "(progn",
//		     "(sleep 100)", 
//		      "(printThread)",
//		     "(- 2 1)", 
//		     ")",
//	 ")",
//		  "(list ",
//		    "(progn" ,
//		     "(printThread)", 
//		     "(+ 1 2)", 
//		     ")",
//		   "(progn " ,
//		    "(sleep 100)" , 
//		    "(printThread)",  
//		     "(- 2 1)", 
//		     ")",
//		    "(progn",
//		     "(sleep 100)", 
//		      "(printThread)",
//		     "(- 2 1)", 
//		     ")",
//		  ")"
		};

	public static final String[] STUDENT_TO_STRING = {
			"\"EAGER\"",
			"T",
			"(3 1 1)",
//			"(3 1 1)"
			};
	public static final String[] GRADER_INPUT = {"(funcall isList (cons 5 6))"};
	public static final String[] GRADER_TO_STRING = {"NIL"};
	protected int poolCountAferDoParallel;
//	protected  Set<String> listenableEvaluators() {
////		return Set.of(new String[] {"printThread"});
//		return new HashSet<>(Arrays.asList(new String[] {"printThread"}));
//
//	}
	@Override
	protected String[] expectedStudentOutput() {
		return STUDENT_TO_STRING;
	}
	@Override
	protected String[] expectedGraderOutput() {
		return GRADER_TO_STRING;
	}
	@Override
	protected String[] studentInputLines() {
		return STUDENT_INPUT;
	}
	@Override
	protected String[] graderInputLines() {
		// TODO Auto-generated method stub
		return GRADER_INPUT;
	}
	public static int getWorkerNumberFromThreadToString(String aThreadToString) {
		try {
			String aWorkerNumberSubstring = StringUtils.substringBetween(aThreadToString, AbstractThreadPool.WORKER_THREAD_NAME_PREFIX, ",");
			return Integer.parseInt(aWorkerNumberSubstring);
		} catch (Exception e) {
			return -1;
		}
		
	}
//	protected TestCaseResult checkPrintThreads() {
//		
//		Set<String> aThreadNames = new HashSet();
//		String aParentThreadName = null;
//		int aNumChildThreads = 0;
//		for (SExpression anEvaluatorResult:evaluatorResults) {
//			String aThreadName = anEvaluatorResult.toString();
//			int aThreadNumber = getWorkerNumberFromThreadToString(aThreadName);
//			if (aThreadNumber >= 0) {
//				aNumChildThreads++;
//				aThreadNames.add(aThreadName);
//			}
//			if (aThreadNumber > poolCountAferDoParallel) {
//				return fail("aThreadNumber:" + aThreadNumber + " in thread name:" + aThreadName + " > poolCountAferDoParallel:" + poolCountAferDoParallel);
//			}
////			if (aThreadNumber < 0) {
////				aParentThreadName = aThreadName;
////			} else {
////				aThreadNames.add(anEvaluatorResult.toString());	
////			}
//		}
////		int aNumChildThreads = aThreadNames.size();
////		if (aParentThreadName == null) {
////			return fail("Parent thread (Thread name without pool worker name) did not printThread");
////		}
//		if (aNumChildThreads != 2) {
//			return fail ("Expected # worker threads:" + 2 + " Actual worker threads:" + aThreadNames);
//		}
//		return pass();
//	}
//	protected TestCaseResult compareOutput() {
//		DoParallelPool aDoParallelPool = (DoParallelPool) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(DoParallelPool.class);;
//		if (!aDoParallelPool.isPassed()) {
//			return fail(DoParallelPool.class.getName() + " failed, fix it before running this test");
//		}
//		poolCountAferDoParallel = aDoParallelPool.getPoolCountAfterDoParallel();
//		return super.compareOutput();
//		
//				
//	}
	@Override
	protected int numExpectedChildThreads() {
		return 2;
	}
	
}
