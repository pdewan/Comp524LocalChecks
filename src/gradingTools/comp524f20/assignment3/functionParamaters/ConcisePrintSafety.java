package gradingTools.comp524f20.assignment3.functionParamaters;

import grader.basics.execution.NotRunnableException;
import grader.basics.execution.RunningProject;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment1.SocialDistanceInputOutputFactory;
import gradingTools.comp524f20.assignment3.requiredFiles.SocialDistanceSMLProvided;
import util.annotations.MaxValue;
@MaxValue(15)
public class ConcisePrintSafety extends AnAbstractTwoParameterPrint {
	public static final int TIME_OUT_SECS = 1; // secs	

	public ConcisePrintSafety() {
	}
	
	private String functionName="concisePrintSafety";

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {

			SocialDistanceSMLProvided aSocialDistanceFileProvided = (SocialDistanceSMLProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceSMLProvided.class);			
			if (aSocialDistanceFileProvided.getRequiredFile() == null) 
				return fail ("A Social Distance File not Found");
			
			
			String [] inputs = generateFunctionCalls(functionName);
			RunningProject aRunningProject = createRunningProject(project,aSocialDistanceFileProvided.getFileName(),inputs);
			if (aRunningProject == null) 
				return fail ("Could not create project. See console messages.");
			
			aRunningProject.await();
			
			String output = aRunningProject.getOutput();
			if (output == null || output.length()==0) 
				return fail ("Could not generate output. See console messages.");
			

			String [] regexChecks=generateRegexs(
					SocialDistanceInputOutputFactory.getGivenSafeRegexChecks(),
					SocialDistanceInputOutputFactory.getInterpolatedRegexChecks(),
					SocialDistanceInputOutputFactory.getDerivedSafeRegexChecks());
			
			boolean aRetval = regexOutputChecksFailurePrint(parseToReadable(output.split("\n")),regexChecks,inputs);

			if (!aRetval) 
				return fail("View console for more detail");
			return pass();
			

		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}
	
	private String[] generateRegexs(boolean[]... expectedValues ) {
		
		int [][] inputList = this.getInputList();
		if(inputList.length!=expectedValues[0].length)
			return null;
		
		String [] retVal=new String[(expectedValues.length*expectedValues[0].length)];
		
		for(int i=0;i<expectedValues[0].length;i++)
			for(int j=0;j<expectedValues.length;j++)
				retVal[i*expectedValues.length+j]=
					".*("+inputList[i][0]+
					", *"+inputList[i][1]+
					", *"+inputList[i][2]+
					", *"+expectedValues[j][i]+").*";
				
		return retVal;
	}
	
}
