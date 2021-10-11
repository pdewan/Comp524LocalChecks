package gradingTools.comp524f20.assignment3.functionParamaters;

import java.util.Arrays;

import grader.basics.execution.NotRunnableException;
import grader.basics.execution.RunningProject;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment1.SocialDistanceInputOutputFactory;
import gradingTools.comp524f20.assignment3.AnAbstractThreeParameterSMLRunningProject;
import gradingTools.comp524f20.assignment3.requiredFiles.SocialDistanceSMLProvided;
import util.annotations.MaxValue;
@MaxValue(20)
public class MatchingSafe extends AnAbstractThreeParameterSMLRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public MatchingSafe() {
	}
	
	private final String functionName="matchingSafe";
	private final String testFunctionName="testCall";
	private final String testMatcherName="testingMatcher";
	
	private boolean hasPassed=false;
	protected boolean hasPassed() {
		return hasPassed;
	}

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
		
			String [] trimmedInputs=Arrays.copyOfRange(inputs, 2, inputs.length);
			String [] outputLines=parseToReadable(output.split("\n"));
			boolean aRetval = regexOutputChecksFailurePrint(outputLines,boolToRegex(SocialDistanceInputOutputFactory.getGivenSafeRegexChecks()),trimmedInputs);

			if (!aRetval) 
				return fail("View console for more detail");
			hasPassed=true;
			return pass();
			

		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}
	
	@Override
	protected String [] generateFunctionCalls(String functionName) {
		setInputNewLine(8);
		int [][] inputList=this.getInputList();
		String [] retVal = new String[inputList.length+3];
	
		//val givenSafeMatcher: (''a * ''b * ''c) * (''a * ''b * ''c) -> bool = (op=)
		
		retVal[0]="fun "+testMatcherName+"((di1, du1, ex1), (di2,du2,ex2)) = di1=ex2 andalso du1=du2 andalso ex1=di2;";
		retVal[1]="fun "+testFunctionName+" encounter = "+ functionName +"("+testMatcherName+",encounter);";
		retVal[2]=getReadabilityCommand();
		
		for(int i=0;i<inputList.length;i++) 
			retVal[i+3]=testFunctionName+"(("+inputList[i][2]+","+inputList[i][1]+","+inputList[i][0]+"));";
		return retVal;
	}
	
}
