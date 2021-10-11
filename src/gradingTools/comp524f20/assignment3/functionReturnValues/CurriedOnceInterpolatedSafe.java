package gradingTools.comp524f20.assignment3.functionReturnValues;

import grader.basics.execution.NotRunnableException;
import grader.basics.execution.RunningProject;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment3.AnAbstractSMLRunningProject;
import gradingTools.comp524f20.assignment3.requiredFiles.SocialDistanceSMLProvided;
import util.annotations.MaxValue;
@MaxValue(7)
public class CurriedOnceInterpolatedSafe extends AnAbstractSMLRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public CurriedOnceInterpolatedSafe() {
	}
	
	private static String functionName="curriedOnceInterpolatedSafe";
	
	private static final int SMALL_DURATION=15,MEDIUM_DURATION=30,LARGE_DURATION=120;
	private static final int SMALL_EXHALATION=10,MEDIUM_EXHALATION=30,LARGE_EXHALATION=50;
	
	
	static int[][] inputCombinations = {
			{MEDIUM_DURATION,MEDIUM_EXHALATION},
			{SMALL_DURATION,LARGE_EXHALATION},
			{LARGE_DURATION,SMALL_EXHALATION},
			
			{MEDIUM_DURATION-1,MEDIUM_EXHALATION},
			{SMALL_DURATION,LARGE_EXHALATION-1},
			{LARGE_DURATION-1,SMALL_EXHALATION},
			
			{MEDIUM_DURATION-1,MEDIUM_EXHALATION-1},
			{SMALL_DURATION-1,LARGE_EXHALATION-1},
			{LARGE_DURATION-1,SMALL_EXHALATION-1},
			
			{LARGE_DURATION,MEDIUM_EXHALATION},
			{MEDIUM_DURATION,LARGE_EXHALATION},
			{LARGE_DURATION,LARGE_EXHALATION},
			
			{MEDIUM_DURATION,MEDIUM_EXHALATION+1},
			{SMALL_DURATION+1,LARGE_EXHALATION},
			{LARGE_DURATION+1,SMALL_EXHALATION+1},
			
			
			
	};
	
	static boolean[] regexChecks = {
			true,
			true,
			true,
			
			true,
			true,
			true,
			
			true,
			true,
			true,
			
			false,
			false,
			false,
			
			false,
			false,
			false,
			
			true,
			false
	};
	
	static String[] curryTest= {
		"val curryTest ="+functionName+" 30;",
		"curryTest 30;",
		"curryTest 31;"
	};

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {

			SocialDistanceSMLProvided aSocialDistanceFileProvided = (SocialDistanceSMLProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceSMLProvided.class);			
			if (aSocialDistanceFileProvided.getRequiredFile() == null) 
				return fail ("A Social Distance File not Found");
			
			String [] inputs = combineArrays(generateFunctionCalls(functionName),curryTest);
			RunningProject aRunningProject = createRunningProject(project,aSocialDistanceFileProvided.getFileName(),inputs);
			if (aRunningProject == null) 
				return fail ("Could not create project. See console messages.");
			
			aRunningProject.await();
			
			String output = aRunningProject.getOutput();
			if (output == null || output.length()==0) 
				return fail ("Could not generate output. See console messages.");
			
			
			boolean aRetval = regexOutputChecksFailurePrint(parseToReadable(output.split("\n")),boolToRegex(regexChecks),inputs);

			if (!aRetval) 
				return fail("View console for more detail");
			return pass();
			

		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}
	

	protected String [] generateFunctionCalls(String functionName) {
		setInputNewLine(8);
		String [] retVal = new String[inputCombinations.length+1];
		retVal[0]=getReadabilityCommand();
		for(int i=0;i<inputCombinations.length;i++) 
			retVal[i+1]=functionName+" "+inputCombinations[i][0]+" "+inputCombinations[i][1]+";";
		return retVal;
	}
}
