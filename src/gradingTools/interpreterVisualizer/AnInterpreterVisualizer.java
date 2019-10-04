package gradingTools.interpreterVisualizer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import main.lisp.interpreter.ObservableLispInterpreter;
import main.lisp.parser.terms.SExpression;
import util.annotations.Visible;
import util.models.PropertyListenerRegisterer;

public class AnInterpreterVisualizer implements InterpreterVisualizer{
	SExpression inputSExpression;
	SExpression resultSExpression;
	PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	@Override
	public SExpression getInputSExpression() {
		return inputSExpression;
	}
	@Override
	public void setInputSExpression(SExpression newVal) {
		SExpression oldValue = inputSExpression;
		this.inputSExpression = newVal;
		propertyChangeSupport.firePropertyChange("InputSExpression", oldValue, newVal);
	}
	@Override
//	@Visible(false)
	public SExpression getResultSExpression() {
		return resultSExpression;
	}
	@Override
	public void setResultSExpression(SExpression newVal) {
		SExpression oldValue = resultSExpression;
		this.resultSExpression = newVal;
		propertyChangeSupport.firePropertyChange("ResultSExpression", oldValue, newVal);
	}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertyChangeSupport.addPropertyChangeListener(aListener);
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String aPropertyName = evt.getPropertyName();
		if (ObservableLispInterpreter.EXPRESSION_PROPERTY == aPropertyName) {
			setInputSExpression((SExpression) evt.getNewValue());
		} else if (ObservableLispInterpreter.RESULT_PROPERTY == aPropertyName) {
			setResultSExpression((SExpression) evt.getNewValue());
		}
	}
	
	

}
