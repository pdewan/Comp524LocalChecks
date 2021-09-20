package gradingTools.comp524f20.assignment2.ruleTests.givenSize;

import grader.basics.execution.NotRunnableException;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment2.AnAbstractPrologRunningProject;
import util.annotations.MaxValue;
@MaxValue(6)
public class GivenSizes_TableTest extends AnAbstractPrologRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public GivenSizes_TableTest() {
	}
	
	private static String[] regexChecks={
			"^true\\..*|^true f.*",
			"^true\\..*|^true f.*",
			"^true\\..*|^true f.*",
//			"^---.*",
	};

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {

			GivenSizes_OutputGeneration outputGeneration = (GivenSizes_OutputGeneration) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(GivenSizes_OutputGeneration.class);			
			String anOutput=outputGeneration.getOutput();

			if (anOutput == null) {
				return fail ("Could not generate output. See console messages.");
			}

			boolean aRetval = regexOutputChecksFailurePrint(anOutput.split("\n"),regexChecks,outputGeneration.getTableTestInput());

			if (!aRetval) 
				return fail("View console for more detail");
			return pass();
			
		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}
}
