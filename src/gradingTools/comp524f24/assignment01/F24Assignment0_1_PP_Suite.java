package gradingTools.comp524f24.assignment01;

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
import gradingTools.shared.testcases.concurrency.oddNumbers.BasicsLargerProblem;
import gradingTools.shared.testcases.concurrency.oddNumbers.BasicsSmallProblem;
import gradingTools.shared.testcases.concurrency.oddNumbers.FairAllocationLargerProblem;
import gradingTools.shared.testcases.concurrency.oddNumbers.FairAllocationSmallProblem;
import gradingTools.shared.testcases.concurrency.oddNumbers.ForkJoinLargerProblem;
import gradingTools.shared.testcases.concurrency.oddNumbers.ForkJoinSmallProblem;
import gradingTools.shared.testcases.concurrency.oddNumbers.LargerNumberOfRandoms;
import gradingTools.shared.testcases.concurrency.oddNumbers.LargerNumberSuite;
import gradingTools.shared.testcases.concurrency.oddNumbers.SmallNumberOfRandoms;
import gradingTools.shared.testcases.concurrency.oddNumbers.SmallNumberSuite;
import gradingTools.shared.testcases.concurrency.oddNumbers.SynchronizationLargerProblem;
import gradingTools.shared.testcases.concurrency.oddNumbers.SynchronizationSmallProblem;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	F24SmallNumbersSuite.class,
	F24LargerNumbersSuite.class,
	F24OddNumbersPiazzaPostSuite.class

})
	

//@MaxValue(50)
public class F24Assignment0_1_PP_Suite {
//	public static final String ROOT_CLASS = "ConcurrentOddNumbers";
//	public static final String DISPATCHER_CLASS = "OddNumbersDispatcher";
//
////	public static final String WORKER_CLASS = "OddNumbersWorke";
//	public static final String WORKER_CLASS = "OddNumbersWorkerCode";

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F24Assignment0_1_PP_Suite.class);


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
