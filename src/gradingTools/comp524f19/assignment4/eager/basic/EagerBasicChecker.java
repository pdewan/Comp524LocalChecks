package gradingTools.comp524f19.assignment4.eager.basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.GradingMode;
import grader.basics.junit.TestCaseResult;
import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import gradingTools.interpreter.checkers.ADiffPatchChecker;
import gradingTools.interpreter.checkers.CheckerResult;
import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.OperationRegisterer;
import main.lisp.parser.terms.SExpression;
import util.annotations.Explanation;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
import util.misc.ThreadSupport;
import util.trace.Tracer;

public abstract class EagerBasicChecker extends AbstractLispExpressionResultChecker {
	
	public static long WAIT_FOR_OUTPUT_TIME = 500;
	protected abstract int numExpectedChildThreads();
	protected TestCaseResult checkPrintThreads() {
		Tracer.info(this, "Waiting for threads output for ms: " + WAIT_FOR_OUTPUT_TIME);
		ThreadSupport.sleep(WAIT_FOR_OUTPUT_TIME);
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
