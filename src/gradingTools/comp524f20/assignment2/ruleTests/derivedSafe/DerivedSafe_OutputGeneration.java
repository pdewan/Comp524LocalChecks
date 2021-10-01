package gradingTools.comp524f20.assignment2.ruleTests.derivedSafe;

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
public class DerivedSafe_OutputGeneration extends AnAbstractPrologRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public DerivedSafe_OutputGeneration() {
	}

	
	private final String [] tableValues= {
			"derivedSafe(13,30,30). ; .",
			"derivedSafe(6,30,10). ; .",
			"derivedSafe(27,30,50). ; .",
			"derivedSafe(13,15,50). ; .",
			"derivedSafe(13,120,10). ; .",
			"derivedSafe(27,120,30). ; .",
			"derivedSafe(6,15,30). ; .", //6
	};
	
	private final String [] offTableTrue= {
			"write('Off Table True Tests below this\n---\n').",
			
			"derivedSafe(14,30,30). ; .",
			"derivedSafe(7,30,10). ; .",
			"derivedSafe(27,29,50). ; .",
			"derivedSafe(13,14,50). ; .",
			"derivedSafe(13,120,9). ; .",
			"derivedSafe(27,120,29). ; .",
			"derivedSafe(7,15,30). ; .", //14
			
			"derivedSafe(14,29,29). ; .",
			"derivedSafe(7,29,9). ; .",
			"derivedSafe(28,29,49). ; .",
			"derivedSafe(14,14,49). ; .",
			"derivedSafe(14,119,9). ; .",
			"derivedSafe(28,119,29). ; .",
			"derivedSafe(7,14,29). ; .",//21
	};
	
	private final String [] offTableFalse= {
			"write('Off Table False Tests below this\n---\n').",
			
			"derivedSafe(12,30,30).",
			"derivedSafe(5,30,10).",
			"derivedSafe(27,31,50).",
			"derivedSafe(13,16,50).",
			"derivedSafe(13,120,11).",
			"derivedSafe(27,120,31).",
			"derivedSafe(5,15,30).",
			"derivedSafe(12,31,31).",
			"derivedSafe(5,31,11).",
			"derivedSafe(26,31,51).",
			"derivedSafe(12,16,51).",
			"derivedSafe(12,121,11).",
			"derivedSafe(26,121,31).",
			"derivedSafe(5,16,31).",
			
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
				//System.err.println("WARNING EXTERNAL FUNCTIONS FOUND IN FILE SocialDistance.pl");
				return fail("External functions present in code cannot proceed");
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
