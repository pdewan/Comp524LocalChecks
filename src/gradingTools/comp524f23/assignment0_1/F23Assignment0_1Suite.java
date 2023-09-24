package gradingTools.comp524f23.assignment0_1;

import java.io.PrintStream;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.output.observer.ObservablePrintStream;
import grader.basics.output.observer.ObservablePrintStreamFactory;
import gradingTools.comp524f20.assignment1.socialDistance.factories.FactoriesSuite;
import gradingTools.comp524f21.assignment2.A2GeneralStyle;
import gradingTools.comp524f21.assignment2.A2MainClassSuite;
import gradingTools.comp524f21.assignment2.A2Modularity;
import gradingTools.comp524f21.assignment2.A2RequiredClassesSuite;
import gradingTools.comp524f21.assignment2.A2SourceCode;
import gradingTools.comp524f21.assignment2.A2UtilityClassSuite;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	SmallNumberOfRandoms.class,
	LargerNumberOfRandoms.class	
})
	

//@MaxValue(50)
public class F23Assignment0_1Suite {
	public static final String ROOT_CLASS = "ConcurrentOddNumbers";
	public static final String DISPATCHER_CLASS = "OddNumbersDispatcher";

//	public static final String WORKER_CLASS = "OddNumbersWorke";
	public static final String WORKER_CLASS = "OddNumbersWorkerCode";

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F23Assignment0_1Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		ObservablePrintStream anOservablePrintStream = ObservablePrintStreamFactory.getObservablePrintStream();
		anOservablePrintStream.setRedirectionFrozen(true);
		System.setOut((PrintStream) anOservablePrintStream);
	}
	
}
