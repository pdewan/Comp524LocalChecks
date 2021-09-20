package gradingTools.comp524f20.assignment2.ruleTests.InterpolatedSafeThreeParam;

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
public class InterpolatedSafe_OutputGeneration extends AnAbstractPrologRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public InterpolatedSafe_OutputGeneration() {
	}
	
	private final String [] tableValues= {
			"interpolatedSafe(13,30,30). ; .",
			"interpolatedSafe(6,30,10). ; .",
			"interpolatedSafe(27,30,50). ; .",
			"interpolatedSafe(13,15,50). ; .",
			"interpolatedSafe(13,120,10). ; .",
			"interpolatedSafe(27,120,30). ; .",
			"interpolatedSafe(6,15,30). ; .",
	};
	
	private final String [] offTableTrue= {
			"write('Off Table True Tests below this\n---\n').",
			
			"interpolatedSafe(14,30,30). ; .",
			"interpolatedSafe(7,30,10). ; .",
			"interpolatedSafe(27,29,50). ; .",
			"interpolatedSafe(14,14,49). ; .",
			"interpolatedSafe(14,119,9). ; .",
			"interpolatedSafe(28,119,29). ; .",
			"interpolatedSafe(7,14,29). ; .",

			"interpolatedSafe(26,30,30). ; .",
			"interpolatedSafe(12,30,10). ; .",
			"interpolatedSafe(27,16,50). ; .",
			"interpolatedSafe(26,0,31). ; .",
			"interpolatedSafe(26,31,0). ; .",
			"interpolatedSafe(2147483647,31,11). ; .",
			"interpolatedSafe(12,0,11). ; .",
	};
	
	private final String [] offTableFalse= {
			"write('Off Table False Tests below this\n---\n').",
			
			"interpolatedSafe(27,2147483647,50).",
			"interpolatedSafe(27,120,2147483647).",
			"interpolatedSafe(5,15,30).",
			"interpolatedSafe(13,121,10).",
			"interpolatedSafe(27,120,31).",
			"interpolatedSafe(0,15,10).",
			"interpolatedSafe(6,15,2147483647).",

			"interpolatedSafe(13,15,10).",
			"interpolatedSafe(13,15,30).",
			"interpolatedSafe(6,15,50).",
			"interpolatedSafe(6,30,50).",
			"interpolatedSafe(27,30,30).",
			"interpolatedSafe(27,120,10).",
			"interpolatedSafe(27,120,50).",
			
			"halt."
	};
	
	protected String [] getTableValuesInput() {
		return tableValues;
	}
	protected String [] getOffTableTrueInputs() {
		return offTableTrue;
	}
	protected String[] getOffTableFalseInputs(){
		return offTableFalse;
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
			
			String [] inputs=combineArrays(getTableValuesInput(),getOffTableTrueInputs(),getOffTableFalseInputs());
			
			SocialDiststancePlNoExternalFunctionsTest externalFunctions = (SocialDiststancePlNoExternalFunctionsTest) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDiststancePlNoExternalFunctionsTest.class);			
			if(!externalFunctions.hasPassed()) {
				System.err.println("WARNING EXTERNAL FUNCTIONS FOUND IN FILE SocialDistance.pl");
				//return fail("External functions present in code cannot proceed");
			}
			
			RunningProject aRunningProject = createRunningProject(project,aSocialDistanceFileProvided.getFileName(),inputs);
			if (aRunningProject == null) {
				return fail ("Could not create project. See console messages.");
			}

			String anOutput = aRunningProject.await().replaceAll("\n\n", "\n").replaceAll("\n\n", "\n");
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
