package gradingTools.comp524f24.assignment6;

import main.ClassRegistryA3;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.OperationRegisterer;
import main.lisp.parser.terms.SExpression;

public interface ClassRegistryA6 extends ClassRegistryA3{
	public default Class<? extends OperationRegisterer> getAdditionalStatefulOperationRegisterer(){return null;}
	public default Class<? extends Environment> getNestedDynamicEnvironment(){return null;}
	public default Class<? extends Evaluator> getDefparameterEvaluator(){return null;}
	public default Class<? extends Evaluator> getDefvarEvaluator(){return null;}
	public default Class<? extends Evaluator> getDefunEvaluator(){return null;}
	public default Class<? extends Evaluator> getCompleteFuncallEvaluator(){return null;}
}
