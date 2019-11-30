package gradingTools.comp524f19.assignment4.eager.pool;

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
@MaxValue(25)
@IsExtra(true)
public class EagerPoolNestedList extends EagerPoolList {
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
		     "(list",
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
		  ")",
		  "(list ",
		    "(progn" ,
			     "(printThread)", 
			     "(+ 1 2)", 
		     ")",
		     "(list",
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
		  ")"
		};

	public static final String[] STUDENT_TO_STRING = {
			"\"EAGER\"",
			"T",
			"(3 (1 1))",
			"(3 (1 1))"
			};
	

	@Override
	protected String[] expectedStudentOutput() {
		return STUDENT_TO_STRING;
	}
//	@Override
//	protected String[] expectedGraderOutput() {
//		return GRADER_TO_STRING;
//	}
	@Override
	protected String[] studentInputLines() {
		return STUDENT_INPUT;
	}
//	@Override
//	protected String[] graderInputLines() {
//		// TODO Auto-generated method stub
//		return GRADER_INPUT;
//	}
//	protected TestCaseResult checkPrintThreads() {
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
//			return fail("Parent thread (thread name without substring, Eval) did not printThread");
//		}
//		if (aNumChildThreads != 2) {
//			return fail ("Expected # Eval threads:" + 2 + " Actual Eval threads:" + aThreadNames);
//		}
//		return pass();
//	}
//	protected TestCaseResult compareOutput() {		
//		TestCaseResult aResult = super.compareOutput();
//		if (!aResult.isPass()) {
//			return aResult;
//		}
//		return checkPrintThreads();
////		Set<String> aThreadNames = new HashSet();
////		String aMainThreadName = null;
////		for (SExpression anEvaluatorResult:evaluatorResults) {
////			String aThreadName = anEvaluatorResult.toString();
////			if (!aThreadName.contains("Eval")) {
////				aMainThreadName = aThreadName;
////			} else {
////				aThreadNames.add(anEvaluatorResult.toString());	
////			}
////		}
////		int aNumChildThreads = aThreadNames.size();
////		if (aMainThreadName == null) {
////			return fail("Thread name without substring, Eval, did not printThread");
////		}
////		if (aNumChildThreads != 2) {
////			return fail ("Expected # Eval threads:" + 2 + " Actual Eval threads:" + aThreadNames);
////		}
////		return pass();
//				
//	}
	
}
