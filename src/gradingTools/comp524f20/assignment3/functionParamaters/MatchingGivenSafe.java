package gradingTools.comp524f20.assignment3.functionParamaters;

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
@MaxValue(15)
public class MatchingGivenSafe extends AnAbstractThreeParameterSMLRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public MatchingGivenSafe() {
	}
	
	private String functionName="matchingGivenSafe";

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
			
			boolean preReqPassed = ((MatchingSafe) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(MatchingSafe.class)).hasPassed();
			if(!preReqPassed) 
				return fail("MatchingSafe Must Pass first");
			
			
			boolean aRetval = regexOutputChecksFailurePrint(parseToReadable(output.split("\n")),boolToRegex(SocialDistanceInputOutputFactory.getGivenSafeRegexChecks()),inputs);

			if (!aRetval) 
				return fail("View console for more detail");
			return pass();
			

		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}
	
	@Override
	protected String [] generateFunctionCalls(String functionName) {
		setInputNewLine(8);
		int [][] inputList=this.getInputList();
		String [] retVal = new String[inputList.length+1];
		retVal[0]=getReadabilityCommand();
		for(int i=0;i<inputList.length;i++) 
			retVal[i+1]=functionName+"(("+inputList[i][0]+","+inputList[i][1]+","+inputList[i][2]+"));";
		return retVal;
	}
	
}
