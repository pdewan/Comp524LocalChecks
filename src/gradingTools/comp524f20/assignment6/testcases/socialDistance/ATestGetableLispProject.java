package gradingTools.comp524f20.assignment6.testcases.socialDistance;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment3.CorrectValues;
import gradingTools.comp524f20.assignment4.AnAbstractThreeParameterLispRunningProject;

public class ATestGetableLispProject extends AnAbstractThreeParameterLispRunningProject{

	private static final String FUNCTION_NAME="listDerivedSafe";
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		return null;
	}

	protected String [] getTests() {
		String [] retVal = new String[inputList.length];
		for(int i=0;i<inputList.length;i++) 
			retVal[i]="(funcall "+FUNCTION_NAME+" "+inputList[i][0]+" "+inputList[i][1]+" "+inputList[i][2]+")";
		return retVal;
	}
	
	protected String [] getExpectedAnswers() {
		boolean [] list = CorrectValues.getDerivedSafeRegexChecks();
		String [] retVal =new String[list.length];
		for(int i=0;i<list.length;i++)
			if(list[i])
				retVal[i]="T";
			else
				retVal[i]="NIL";
		return retVal;
		
	}
	
}
