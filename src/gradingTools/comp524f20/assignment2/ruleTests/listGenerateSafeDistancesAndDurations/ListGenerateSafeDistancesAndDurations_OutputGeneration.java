package gradingTools.comp524f20.assignment2.ruleTests.listGenerateSafeDistancesAndDurations;

import grader.basics.execution.NotRunnableException;
import grader.basics.execution.RunningProject;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment2.AnAbstractPrologRunningProject;
import gradingTools.comp524f20.assignment2.requiredFiles.SocialDistancePlProvided;
import gradingTools.comp524f20.assignment2.requiredFiles.SocialDiststancePlNoExternalFunctionsTest;
import util.annotations.MaxValue;
@MaxValue(2)
public class ListGenerateSafeDistancesAndDurations_OutputGeneration extends AnAbstractPrologRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public ListGenerateSafeDistancesAndDurations_OutputGeneration() {
	}
	
	private String [] recursionTestInput= {
			"write('recursion validation below\n---\n').",
			"trace(listGenerateSafeDistancesAndDurations,call).",
			"write('tracing was turned on\n').",
			"listGenerateSafeDistancesAndDurations(12,GeneratedTable). ; .",
			
			"halt."	
	};
	
	private String [] recursionTestRegex={
		"^---.*",
		"^---.*",
		".*Call.*listGenerateSafeDistancesAndDurations.*",
		".*Call.*listGenerateSafeDistancesAndDurations.*",
		".*Call.*listGenerateSafeDistancesAndDurations.*"
	};
	
	private String [] trueValueInputs= {
			
			"listGenerateSafeDistancesAndDurations(9,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(0,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(10,GeneratedTable). ; .",
			
			"listGenerateSafeDistancesAndDurations(11,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(11,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(11,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(29,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(29,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(29,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(30,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(30,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(30,GeneratedTable). ; .",
			
			"listGenerateSafeDistancesAndDurations(31,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(49,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(50,GeneratedTable). ; .",
	};
	private String [] falseValueInputs= {
			"write('ListGenerateSafeDistancesAndDurations false outputs below\n---\n').",
			
			"listGenerateSafeDistancesAndDurations(51,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(70,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(101,GeneratedTable). ; .",
			"listGenerateSafeDistancesAndDurations(2147483647,GeneratedTable). ; .",
			
			
	};
	
	protected String [] getTrueValueInputs() {
		return trueValueInputs;
	}
	protected String [] getFalseValueInputs() {
		return falseValueInputs;
	}
	
	private String output=null;
	
	public String getOutput() {
		return output;
	}
	
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {

			SocialDistancePlProvided aSocialDistanceFileProvided = (SocialDistancePlProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistancePlProvided.class);			
			
			String [] inputs=combineArrays(getTrueValueInputs(),getFalseValueInputs(),recursionTestInput);
			
			SocialDiststancePlNoExternalFunctionsTest externalFunctions = (SocialDiststancePlNoExternalFunctionsTest) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDiststancePlNoExternalFunctionsTest.class);			
			if(!externalFunctions.hasPassed()) {
				//System.err.println("WARNING EXTERNAL FUNCTIONS FOUND IN FILE SocialDistance.pl");
				return fail("External functions present in code cannot proceed");
			}
			
			RunningProject aRunningProject = createRunningProject(project,aSocialDistanceFileProvided.getFileName(),inputs);
			if (aRunningProject == null) {
				return fail ("Could not create project. See console messages.");
			}

			String anOutput = aRunningProject.await().replaceAll("\n\n", "\n").replaceAll("\n\n", "\n");
//			LinesMatcher aLinesMatcher = aRunningProject.getLinesMatcher();
			
			String errOutput=aRunningProject.getOutputAndErrors().replaceAll("\n\n", "\n").replaceAll("\n\n", "\n");
			boolean retVal=regexOutputChecksFailurePrint(errOutput.split("\n"), recursionTestRegex);
			if(!retVal) {
				anOutput=null;
				return fail("recursion not detected in prolog traces");
			}
						
			if(anOutput==null||anOutput.length()==0) {
				return fail("output from running commands is null or empty");
			}
			
			output=anOutput;
			return pass();
			

		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}

}
