package gradingTools.comp524f20.assignment4.listsAndRecursion;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.NotRunnableException;
import grader.basics.execution.RunningProject;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment1.SocialDistanceInputOutputFactory;
import gradingTools.comp524f20.assignment4.AnAbstractThreeParameterLispRunningProject;
import gradingTools.comp524f20.assignment4.requiredFiles.SocialDistanceLispProvided;
import util.annotations.MaxValue;
@MaxValue(10)
public class ListDerivedSafeLisp extends AnAbstractThreeParameterLispRunningProject {
	public static final int TIME_OUT_SECS = 8; // secs
	public static final int OUTPUT_WAIT_TIME = 1000; // ms
	public static final int FIRST_INPUT_DELAY_TIME = 2000; // ms
	public static final int BETWEEN_INPUT_DELAY_TIME = 20; // ms

	@Override
	protected int getTimeout() {
		return TIME_OUT_SECS;
	}

	public ListDerivedSafeLisp() {
	}
	
	private String functionName="listDerivedSafe";
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {

			SocialDistanceLispProvided aSocialDistanceFileProvided = (SocialDistanceLispProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceLispProvided.class);			
			if (aSocialDistanceFileProvided.getRequiredFile() == null) 
				return fail ("A Social Distance File not Found");
			
			String [] inputs = generateFunctionCalls(functionName);
//			int anOldFirstInputDelayTime = BasicExecutionSpecificationSelector.getBasicExecutionSpecification().getFirstInputDelay();
			int anOldBetweenInputDelayTime = BasicExecutionSpecificationSelector.getBasicExecutionSpecification().getBetweenInputDelay();

			int anOldOutputDelayTime = BasicExecutionSpecificationSelector.getBasicExecutionSpecification().getProcessOutputSleepTime();
			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setProcessOutputWaitTime(OUTPUT_WAIT_TIME);
			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setFirstInputDelay(FIRST_INPUT_DELAY_TIME);
			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setBetweenInputDelay(BETWEEN_INPUT_DELAY_TIME);

			RunningProject aRunningProject = createRunningProject(project,aSocialDistanceFileProvided.getFileName(),inputs);
			if (aRunningProject == null) 
				return fail ("Could not create project. See console messages.");
			

			aRunningProject.await();
			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setProcessOutputWaitTime(anOldOutputDelayTime);
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setFirstInputDelay(anOldFirstInputDelayTime);
			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setBetweenInputDelay(anOldBetweenInputDelayTime);

			String output = aRunningProject.getOutput();
			if (output == null || output.length()==0) 
				return fail ("Could not generate output. See console messages.");
			
			
			boolean aRetval = regexOutputChecksFailurePrint(parseToReadable(output.split("\n")),boolToRegex(SocialDistanceInputOutputFactory.getDerivedSafeRegexChecks()),inputs);

			if (!aRetval) 
				return fail("View console for more detail");
			return pass();
			

		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}
	
	
}
