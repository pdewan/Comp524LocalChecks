package gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeThreeParam;

import grader.basics.execution.NotRunnableException;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment2.AnAbstractPrologRunningProject;
import util.annotations.MaxValue;
@MaxValue(6)
public class InterpolatedSafe_OffTableFalseTest extends AnAbstractPrologRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public InterpolatedSafe_OffTableFalseTest() {
	}
	
	private static String[] regexChecks={
			"^---.*",
			"^---.*",
			"^false.*",
			"^false.*",
			"^false.*",
			"^false.*",
			"^false.*",
			"^false.*",
			"^false.*",
			
			"^false.*",
			"^false.*",
			"^false.*",
			"^false.*",
			"^false.*",
			"^false.*",
			"^false.*",
			
	};

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {

			InterpolatedSafe_OutputGeneration outputGeneration = (InterpolatedSafe_OutputGeneration) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(InterpolatedSafe_OutputGeneration.class);			
			String anOutput=outputGeneration.getOutput();

			if (anOutput == null) {
				return fail ("Could not generate output. See console messages.");
			}

//			LinesMatcher aLinesMatcher = aRunningProject.getLinesMatcher();
			
			boolean aRetval = regexOutputChecksFailurePrint(anOutput.split("\n"),regexChecks,outputGeneration.getOffTableFalseInputs());

			if (!aRetval) 
				return fail("View console for more detail");
			return pass();
			

		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}

}
