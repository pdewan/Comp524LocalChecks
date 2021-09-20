package gradingTools.comp524f20.assignment2.ruleTests.generateSafeDistancesAndDurations;

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
public class GenerateSafeDistancesAndDurations_OutputGeneration extends AnAbstractPrologRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public GenerateSafeDistancesAndDurations_OutputGeneration() {
	}
	
	private String [] trueValueInputs= {
			"generateSafeDistancesAndDurations(Distance,Duration,9). ;", "; .",
			"generateSafeDistancesAndDurations(Distance,Duration,9). ;", "; .",
			
			"generateSafeDistancesAndDurations(Distance,Duration,0). ;", "; .",
			"generateSafeDistancesAndDurations(Distance,Duration,0). ;", "; .",
			
			"generateSafeDistancesAndDurations(Distance,Duration,10). ;", "; .",
			"generateSafeDistancesAndDurations(Distance,Duration,10). ;", "; .",
			
			
			
			"generateSafeDistancesAndDurations(Distance,Duration,11). ;", ";", "; .",
			"generateSafeDistancesAndDurations(Distance,Duration,11). ;", ";", "; .",
			"generateSafeDistancesAndDurations(Distance,Duration,11). ;", ";", "; .",
			
			"generateSafeDistancesAndDurations(Distance,Duration,29). ;", ";", "; .",
			"generateSafeDistancesAndDurations(Distance,Duration,29). ;", ";", "; .",
			"generateSafeDistancesAndDurations(Distance,Duration,29). ;", ";", "; .",
			
			"generateSafeDistancesAndDurations(Distance,Duration,30). ;", ";", "; .",
			"generateSafeDistancesAndDurations(Distance,Duration,30). ;", ";", "; .",
			"generateSafeDistancesAndDurations(Distance,Duration,30). ;", ";", "; .",
			
			
			
			"generateSafeDistancesAndDurations(Distance,Duration,31). ;", "; .",
			"generateSafeDistancesAndDurations(Distance,Duration,31). ;", "; .",
			
			"generateSafeDistancesAndDurations(Distance,Duration,49). ;", "; .",
			"generateSafeDistancesAndDurations(Distance,Duration,49). ;", "; .",
			
			"generateSafeDistancesAndDurations(Distance,Duration,50). ;", "; .",
			"generateSafeDistancesAndDurations(Distance,Duration,50). ;", "; .",
	};
	private String [] falseValueInputs= {
			"write('generateSafeDistancesAndDurations false outputs below\n---\n').",
			
			"generateSafeDistancesAndDurations(Distance,Duration,51).",
			"generateSafeDistancesAndDurations(Distance,Duration,70).",
			"generateSafeDistancesAndDurations(Distance,Duration,101).",
			"generateSafeDistancesAndDurations(Distance,Duration,2147483647).",
			
			"halt."	
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
			
			String [] inputs=combineArrays(getTrueValueInputs(),getFalseValueInputs());
			
			SocialDiststancePlNoExternalFunctionsTest externalFunctions = (SocialDiststancePlNoExternalFunctionsTest) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDiststancePlNoExternalFunctionsTest.class);			
			if(!externalFunctions.hasPassed()) {
				System.err.println("WARNING EXTERNAL FUNCTIONS FOUND IN FILE SocialDistance.pl");
				//return fail("External functions present in code cannot proceed");
			}
			
			RunningProject aRunningProject = createRunningProject(project,aSocialDistanceFileProvided.getFileName(),inputs);
			if (aRunningProject == null) {
				return fail ("Could not create project. See console messages.");
			}

			String anOutput = aRunningProject.await().replaceAll("\n\n", "\n");
//			LinesMatcher aLinesMatcher = aRunningProject.getLinesMatcher();
			
			
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
