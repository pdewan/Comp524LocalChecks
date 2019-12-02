package gradingTools.comp524f19.assignment4.lazy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import grader.basics.junit.TestCaseResult;
import gradingTools.comp524f19.assignment2.testcases.AbstractLispExpressionResultChecker;
import main.lisp.parser.terms.SExpression;
import util.trace.Tracer;

public abstract class AbstractEvaluatorAndResultChecker extends AbstractLispExpressionResultChecker {
	protected abstract String[] expectedEvaluatorOutput();
	protected TestCaseResult compareOutput() {
		TestCaseResult aResult = super.compareOutput();
		if (!aResult.isPass()) {
			return aResult;
		}
		String[] anExpectedOutput = expectedEvaluatorOutput();
	 if (evaluatorResults.size() != anExpectedOutput.length ) {
		 return fail("Expected evaluator results:" + Arrays.toString(anExpectedOutput) + " does not match actual results:" +evaluatorResults); 
	
	 }
		for (int i = 0; i < anExpectedOutput.length; i++  ) {
			String anExpected = anExpectedOutput[i];
			String anActual = evaluatorResults.get(i).toString();
		
			if (!anExpected.equals(anActual)) {
				
				 fail("Expected evaluator result: " + anExpected + " did not match an actual: " + anActual + " at position: " + i  );

			}
		}
		return pass();
	}

}
