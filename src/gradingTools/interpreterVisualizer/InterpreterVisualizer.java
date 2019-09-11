package gradingTools.interpreterVisualizer;

import java.beans.PropertyChangeListener;

import main.lisp.parser.terms.SExpression;
import util.models.PropertyListenerRegisterer;

public interface InterpreterVisualizer extends PropertyListenerRegisterer, PropertyChangeListener{

	SExpression getInputSExpression();

	void setInputSExpression(SExpression newVal);

	SExpression getResultSExpression();

	void setResultSExpression(SExpression newVal);

}