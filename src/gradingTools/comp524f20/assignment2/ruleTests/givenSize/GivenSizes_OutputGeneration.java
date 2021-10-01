package gradingTools.comp524f20.assignment2.ruleTests.givenSize;

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
public class GivenSizes_OutputGeneration extends AnAbstractPrologRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public GivenSizes_OutputGeneration() {
	}

	private final String[] tableTestInputs={
			"givenSizes(6, 15, 10). ; .", 
			"givenSizes(13, 30, 30). ; .",
			"givenSizes(27, 120, 50). ; .",
			"halt."
	};
	private final String[] offTableTestInputs= {
			"write('Off Table Tests below this\n---\n').",
			
			"givenSizes(6, 13, 27).", 
			"givenSizes(99, 30, 50).",
			"givenSizes(13, 29, 30).",
			"halt."	
	};
	
	protected String[] getTableTestInput() {
		return tableTestInputs;
	}
	protected String[] getOffTableTestInput() {
		return offTableTestInputs;
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
			
			String [] inputs=getTableTestInput();//combineArrays(getTableTestInput(),getOffTableTestInput());
			
			SocialDiststancePlNoExternalFunctionsTest externalFunctions = (SocialDiststancePlNoExternalFunctionsTest) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDiststancePlNoExternalFunctionsTest.class);			
			if(!externalFunctions.hasPassed()) {
				//System.err.println("WARNING EXTERNAL FUNCTIONS FOUND IN FILE SocialDistance.pl");
				return fail("External functions present in code cannot proceed");
			}
			
			RunningProject aRunningProject = createRunningProject(project,aSocialDistanceFileProvided.getFileName(),inputs);
			if (aRunningProject == null) {
				return fail ("Could not create project. See console messages.");
			}

			String anOutput = aRunningProject.await().replaceAll("\n\n", "\n");
			
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
