package gradingTools.comp524f19.assignment4.eager.pool;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(10)
@IsExtra(true)
public class EagerPoolNestedOr extends EagerPoolChecker {
	public static final String[] STUDENT_INPUT = 
//		{"(funcall curriedNumAtoms (list 2 (cons 4 5)))"};
		{
	 "(setEvalMode \"EAGER\")",
	 "(setEagerPool T)",
	 "(or",
	 	"(progn" ,
	 	 	"(printThread)", 
	 		"(> 5 0)",
	 	 ")",
		 "(or ",
		    "(progn" ,
			     "(printThread)", 
			     "(< 5 0)", 
		     ")",
		   "(progn " ,
			    "(sleep 100)" , 
			    "(printThread)",  
			     "(> 5 0)", 
		     ")",
		    
		  ")",
	   ")" ,
//	   "(or",
//	 	"(progn" ,
//	 	 	"(printThread)", 
//	 		"(> 5 0)",
//	 	 ")",
//		 "(or ",
//		    "(progn" ,
//			     "(printThread)", 
//			     "(< 5 0)", 
//		     ")",
//		   "(progn " ,
//			    "(sleep 100)" , 
//			    "(printThread)",  
//			     "(> 5 0)", 
//		     ")",
//		    
//		  ")",
//	   ")"     
		};

	public static final String[] STUDENT_TO_STRING = {
			"\"EAGER\"",
			"T",
			"T",
//			"T"
			};
	public static final String[] GRADER_INPUT = {"(funcall isList (cons 5 6))"};
	public static final String[] GRADER_TO_STRING = {"NIL"};
	protected  Set<String> listenableEvaluators() {
//		return Set.of(new String[] {"printThread"});
		return new HashSet<>(Arrays.asList(new String[] {"printThread"}));

	}
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
	@Override
	protected int numExpectedChildThreads() {
		return 2;
	}
		
}
