package gradingTools.comp524f20.assignment3.functionReturnValues;

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
@MaxValue(7)
public class CurryableInterpolatedSafe extends AnAbstractThreeParameterSMLRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public CurryableInterpolatedSafe() {
	}
	
	private static String functionName="curryableInterpolatedSafe";
	
	public static boolean[] getRegexChecks() {
		
		return combineBoolArrs(SocialDistanceInputOutputFactory.getInterpolatedRegexChecks(),regexChecks);
	}
	
	private static boolean[] regexChecks= {
			true,
			false
	};
	
	private static String [] curryTest = {
			"val curried = "+functionName+" 13;",
			"curried 29 29;",
			"curried 30 1;"
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
			
			boolean aRetval = regexOutputChecksFailurePrint(parseToReadable(output.split("\n")),boolToRegex(getRegexChecks()),inputs);

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
		int [][] inputList=getInputList();
		String [] retVal = new String[inputList.length+1];
		retVal[0]=getReadabilityCommand();
		for(int i=0;i<inputList.length;i++) 
			retVal[i+1]=functionName+" "+inputList[i][0]+" "+inputList[i][1]+" "+inputList[i][2]+";";
		return retVal;
	}
	
	private static boolean [] combineBoolArrs(boolean[]ar1,boolean[] ar2) {
		boolean [] retval = new boolean [ar1.length+ar2.length];
		for(int i=0;i<ar1.length;i++)
			retval[i]=ar1[i];
		for(int i=0;i<ar2.length;i++)
			retval[i+ar1.length]=ar2[i];
		return retval;
		
	}
}
