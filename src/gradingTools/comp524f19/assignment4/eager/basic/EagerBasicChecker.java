package gradingTools.comp524f19.assignment4.eager.basic;

import java.util.HashSet;
import java.util.Set;

import grader.basics.junit.TestCaseResult;
import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import main.lisp.parser.terms.SExpression;

public abstract class EagerBasicChecker extends AbstractLispExpressionResultChecker {
	
	public static long WAIT_FOR_OUTPUT_TIME = 2000;
	protected abstract int numExpectedChildThreads();
	protected String[] listenableEvaluatorsArray() {
		return new String[] {"printThread"};
	}
	protected TestCaseResult checkPrintThreads() {
//		Tracer.info(this, "Waiting for threads output for ms: " + WAIT_FOR_OUTPUT_TIME);
//		ThreadSupport.sleep(WAIT_FOR_OUTPUT_TIME);
		Set<String> aThreadNames = new HashSet();
		String aMainThreadName = null;
		for (SExpression anEvaluatorResult:evaluatorResults) {
			String aThreadName = anEvaluatorResult.toString();
			if (!aThreadName.contains("Eval")) {
				aMainThreadName = aThreadName;
			} else {
				aThreadNames.add(anEvaluatorResult.toString());	
			}
		}
		int aNumChildThreads = aThreadNames.size();
		if (aMainThreadName == null) {
			return fail("Parent thread (thread name without substring, Eval) did not printThread");
		}
		int aNumExpectedThreads = numExpectedChildThreads();
		if (aNumChildThreads != aNumExpectedThreads) {
			return fail ("Expected # Eval threads:" + 2 + " Actual Eval threads:" + aThreadNames);
		}
		return pass();
	}
	protected TestCaseResult compareOutput() {		
		TestCaseResult aResult = super.compareOutput();
		if (!aResult.isPass()) {
			return aResult;
		}
		return checkPrintThreads();
//		Set<String> aThreadNames = new HashSet();
//		String aMainThreadName = null;
//		for (SExpression anEvaluatorResult:evaluatorResults) {
//			String aThreadName = anEvaluatorResult.toString();
//			if (!aThreadName.contains("Eval")) {
//				aMainThreadName = aThreadName;
//			} else {
//				aThreadNames.add(anEvaluatorResult.toString());	
//			}
//		}
//		int aNumChildThreads = aThreadNames.size();
//		if (aMainThreadName == null) {
//			return fail("Thread name without substring, Eval, did not printThread");
//		}
//		if (aNumChildThreads != 2) {
//			return fail ("Expected # Eval threads:" + 2 + " Actual Eval threads:" + aThreadNames);
//		}
//		return pass();
				
	}
	
}
