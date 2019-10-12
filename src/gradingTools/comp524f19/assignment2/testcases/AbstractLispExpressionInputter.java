package gradingTools.comp524f19.assignment2.testcases;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.GradingMode;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.testcase.PassFailJUnitTestCase;
import main.lisp.interpreter.InterpreterModelSingleton;
import main.lisp.interpreter.ObservableLispInterpreter;
import main.lisp.parser.terms.SExpression;
import util.trace.Tracer;

public  abstract class AbstractLispExpressionInputter extends PassFailJUnitTestCase implements PropertyChangeListener{
	protected List<SExpression> inputSExpressions = new ArrayList<SExpression>();
	
	protected List<SExpression> resultSExpressions = new ArrayList<SExpression>();
	protected boolean initialized = false;
	protected abstract String[] studentInputLines();
	protected abstract String[] graderInputLines();	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String aPropertyName = evt.getPropertyName();
		if (ObservableLispInterpreter.EXPRESSION_PROPERTY == aPropertyName) {
			inputSExpressions.add ((SExpression) evt.getNewValue());
			Tracer.info(this, "Got input : " + inputSExpressions.get(inputSExpressions.size()-1).toString());
		} else if (ObservableLispInterpreter.RESULT_PROPERTY == aPropertyName) {
			resultSExpressions.add((SExpression) evt.getNewValue());
			Tracer.info(this, "Got result : " + resultSExpressions.get(resultSExpressions.size()-1).toString());
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

    public void evaluate(String[] aLines) throws Throwable {
    	// make sure the class is registered with the factory.
		 
    	
    	if (!initialized) {
//        	SExpressionClassProvided anSExpressionClassProcessor = (SExpressionClassProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SExpressionClassProvided.class);
//    		Class<? extends SExpression> anSExpressionClass = anSExpressionClassProcessor.getSExpressionClass();
    		MainClassProvided aMainClassProcessor = (MainClassProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(MainClassProvided.class);
//   		 	ExpressionFactory.setClass(anSExpressionClass);
//   		 	InterpreterModelSingleton.get().registerPropertyChangeListener(this);
    		Class aMainClass = aMainClassProcessor.getMainClass();
   		 	initialized = true;
   		 	BasicProjectExecution.invokeMain(aMainClass, emptyStrings, ".");
   		 	InterpreterModelSingleton.get().registerPropertyChangeListener(this);
   		 	
    	}
//    	newSExpression = null;
    	for (String aLine:aLines ) {
    		try {
    		InterpreterModelSingleton.get().newInput(aLine);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
//    	return newSExpression;
    
    	
    }
    public List<SExpression> getInputSExpressions() {
		return inputSExpressions;
	}
	public List<SExpression> getResultSExpressions() {
		return resultSExpressions;
	}

}
