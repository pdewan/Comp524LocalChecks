package gradingTools.interpreterVisualizer;

import bus.uigen.ObjectEditor;
import grader.basics.execution.BasicProjectExecution;
import grader.basics.project.BasicProjectIntrospection;
import grader.basics.project.CurrentProjectHolder;
import grader.basics.project.Project;
import gradingTools.comp524f19.assignment1.testcases.ClassRegistryProvided;
import main.ClassRegistry;
import main.lisp.interpreter.InterpreterModelSingleton;

public class InterpreterVisualizerMain {
	public static void main(String[] args) {
		InterpreterVisualizer anInterpreterVisualizer = new AnInterpreterVisualizer();
		ObjectEditor.edit(anInterpreterVisualizer);
		Project aProject = CurrentProjectHolder.getOrCreateCurrentProject();

		ClassRegistry aClassRegistry = (ClassRegistry) BasicProjectIntrospection.createInstanceOfPredefinedSupertype(ClassRegistryProvided.REGISTRY_INTERFACE);
		Class aMainClass = aClassRegistry.getMain();

		//	 	ExpressionFactory.setClass(anSExpressionClass);
	 	InterpreterModelSingleton.get().registerPropertyChangeListener(anInterpreterVisualizer);
	 	try {
			BasicProjectExecution.invokeMainDirect(aMainClass);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		 	InterpreterModelSingleton.get().registerPropertyChangeListener(anInterpreterVisualizer);

	}

}
