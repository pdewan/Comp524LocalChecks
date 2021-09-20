package gradingTools.comp524f20.assignment2.ruleTests.generateSafeDistancesAndDurations;

import grader.basics.execution.NotRunnableException;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment2.AnAbstractPrologRunningProject;
import util.annotations.MaxValue;
@MaxValue(8)
public class GenerateSafeDistancesAndDurations_TrueValueTest extends AnAbstractPrologRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public GenerateSafeDistancesAndDurations_TrueValueTest() {
	}
	
	private static String[] regexChecks={
			".*Distance = 6.*",
			".*Duration = 30.*",
			".*Distance = 13.*",
			".*Duration = 120.*",
			
			".*Distance = 6.*",
			".*Duration = 30.*",
			".*Distance = 13.*",
			".*Duration = 120.*",
			
			
			
			".*Distance = 6.*",
			".*Duration = 30.*",
			".*Distance = 13.*",
			".*Duration = 120.*",
			
			".*Distance = 13.*",
			".*Duration = 30.*",
			".*Distance = 27.*", 
			".*Duration = 120.*",
			".*Distance = 6.*",
			".*Duration = 15.*",
			
			".*Distance = 13.*",
			".*Duration = 30.*",
			".*Distance = 27.*", 
			".*Duration = 120.*",
			".*Distance = 6.*",
			".*Duration = 15.*",
			
			".*Distance = 13.*",
			".*Duration = 30.*",
			".*Distance = 27.*", 
			".*Duration = 120.*",
			".*Distance = 6.*",
			".*Duration = 15.*",
			
			
			
			".*Distance = 27.*",
			".*Duration = 30.*",
			".*Distance = 13.*",
			".*Duration = 15.*",
			
			".*Distance = 27.*",
			".*Duration = 30.*",
			".*Distance = 13.*",
			".*Duration = 15.*",
			
			".*Distance = 27.*",
			".*Duration = 30.*",
			".*Distance = 13.*",
			".*Duration = 15.*",
			"^---.*",
	};

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {

			GenerateSafeDistancesAndDurations_OutputGeneration outputGeneration = (GenerateSafeDistancesAndDurations_OutputGeneration) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(GenerateSafeDistancesAndDurations_OutputGeneration.class);			
			String anOutput=outputGeneration.getOutput();

			if (anOutput == null) {
				return fail ("Could not generate output. See console messages.");
			}

//			LinesMatcher aLinesMatcher = aRunningProject.getLinesMatcher();
			
			boolean aRetval = regexOutputChecksFailurePrint(anOutput.split("\n"),regexChecks,outputGeneration.getTrueValueInputs());

			if (!aRetval) 
				return fail("View console for more detail");
			return pass();
			

		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}

}
