package gradingTools.comp524f19.assignment2.testcases;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.GradingMode;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.testcase.PassFailJUnitTestCase;
import main.lisp.evaluator.AbstractEvaluator;
import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.OperationManager;
import main.lisp.interpreter.InterpreterModelSingleton;
import main.lisp.interpreter.ObservableLispInterpreter;
import main.lisp.parser.terms.SExpression;
import util.trace.Tracer;

public  abstract class AbstractLispExpressionInputterAndEvaluatorRegisterer extends PassFailJUnitTestCase implements PropertyChangeListener{
	protected List<SExpression> inputSExpressions = new ArrayList<SExpression>();
	
	protected List<SExpression> resultSExpressions = new ArrayList<SExpression>();
	protected List<SExpression> evaluatorInputs = new ArrayList<SExpression>();
	protected List<SExpression> evaluatorResults = new ArrayList<SExpression>();

	protected static boolean initialized = false;
	protected abstract String[] studentInputLines();
	protected abstract String[] graderInputLines();	
	protected String[] listenableEvaluatorsArray() {
		return emptyStrings;
	}
	protected  Set<String> listenableEvaluators() {
		return new HashSet<>(Arrays.asList(listenableEvaluatorsArray()));
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String aPropertyName = evt.getPropertyName();
		if (ObservableLispInterpreter.EXPRESSION_PROPERTY == aPropertyName) {
			inputSExpressions.add ((SExpression) evt.getNewValue());
			Tracer.info(this, "Got input : " + inputSExpressions.get(inputSExpressions.size()-1).toString());
		} else if (ObservableLispInterpreter.RESULT_PROPERTY == aPropertyName) {
			resultSExpressions.add((SExpression) evt.getNewValue());
			Tracer.info(this, "Got result : " + resultSExpressions.get(resultSExpressions.size()-1).toString());
		} else {
			if (listenableEvaluators().contains(aPropertyName)) {
				Tracer.info(this, "Got evalautor event : "+ evt);

				evaluatorInputs.add((SExpression) evt.getOldValue());
				evaluatorResults.add((SExpression) evt.getNewValue());
			}
		}
	}
	public void evaluate() throws Throwable {
		String[] anInput = null;
		if (GradingMode.getGraderRun()) {
			anInput = graderInputLines();
		} else {
			anInput = studentInputLines();
		}
		evaluate(anInput);
	}
	protected String[] oneLine = {""};
    public void evaluate(String aLine) throws Throwable {
    	oneLine[0] = aLine;
    	evaluate(oneLine);
    }
    public static String[] emptyStrings = {};
    protected void registerWithEvaluators() {
    	OperationManager anOperationManager = BuiltinOperationManagerSingleton.get();
    	for (String anEvaluatorName:listenableEvaluators()) {
    		Evaluator anEvaluator = anOperationManager.getEvaluator(anEvaluatorName);
    		if (anEvaluator != null && anEvaluator instanceof AbstractEvaluator) {
    			((AbstractEvaluator) anEvaluator).clearPropertyChangeListeners();
    			((AbstractEvaluator) anEvaluator).addPropertyChangeListener(this);
    		}

    	}
    }
   
    protected void callMain(String[] aLines) throws Throwable {
    	MainClassProvided aMainClassProcessor = (MainClassProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(MainClassProvided.class);
//	 	ExpressionFactory.setClass(anSExpressionClass);
//	 	InterpreterModelSingleton.get().registerPropertyChangeListener(this);
	Class aMainClass = aMainClassProcessor.getMainClass();
	 	initialized = true;
	 	BasicProjectExecution.invokeMain(aMainClass, emptyStrings, ".");
//		Evaluator anEvaluator = BuiltinOperationManagerSingleton.get().getEvaluator("print");

//	 	InterpreterModelSingleton.get().registerPropertyChangeListener(this);
//	 	registerWithEvaluators();
    }
    protected void provideInput(String[] aLines) {
    	for (String aLine:aLines ) {
    		try {
    		InterpreterModelSingleton.get().newInput(aLine);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
    public void evaluate(String[] aLines) throws Throwable {
    	// make sure the class is registered with the factory.
		 
    	
    	if (!initialized) {
    		callMain(aLines);
////        	SExpressionClassProvided anSExpressionClassProcessor = (SExpressionClassProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SExpressionClassProvided.class);
////    		Class<? extends SExpression> anSExpressionClass = anSExpressionClassProcessor.getSExpressionClass();
//    		MainClassProvided aMainClassProcessor = (MainClassProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(MainClassProvided.class);
////   		 	ExpressionFactory.setClass(anSExpressionClass);
////   		 	InterpreterModelSingleton.get().registerPropertyChangeListener(this);
//    		Class aMainClass = aMainClassProcessor.getMainClass();
//   		 	initialized = true;
//   		 	BasicProjectExecution.invokeMain(aMainClass, emptyStrings, ".");
////   			Evaluator anEvaluator = BuiltinOperationManagerSingleton.get().getEvaluator("print");
//
//   		 	InterpreterModelSingleton.get().registerPropertyChangeListener(this);
   		 	
    	}
    	InterpreterModelSingleton.get().clearPropertyChangeListeners();
	 	InterpreterModelSingleton.get().registerPropertyChangeListener(this);
	 	registerWithEvaluators();


    	provideInput(aLines);
//    	newSExpression = null;
//    	for (String aLine:aLines ) {
//    		try {
//    		InterpreterModelSingleton.get().newInput(aLine);
//    		} catch (Exception e) {
//    			e.printStackTrace();
//    		}
//    	}
//    	return newSExpression;
    
    	
    }
    public List<SExpression> getInputSExpressions() {
		return inputSExpressions;
	}
	public List<SExpression> getResultSExpressions() {
		return resultSExpressions;
	}

}
