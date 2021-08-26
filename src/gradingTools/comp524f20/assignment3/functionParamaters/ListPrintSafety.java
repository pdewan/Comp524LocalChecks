package gradingTools.comp524f20.assignment3.functionParamaters;

import java.util.ArrayList;
import java.util.List;

import grader.basics.execution.NotRunnableException;
import grader.basics.execution.RunningProject;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment3.AnAbstractThreeParameterSMLRunningProject;
import gradingTools.comp524f20.assignment3.CorrectValues;
import gradingTools.comp524f20.assignment3.requiredFiles.SocialDistanceSMLProvided;
import util.annotations.MaxValue;
@MaxValue(10)
public class ListPrintSafety extends AnAbstractThreeParameterSMLRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public ListPrintSafety() {
	}
	
	private String [] functions= {"givenSafe", "interpolatedSafe", "listDerivedSafe"};
	private String [] printMethods= {"printSafety","concisePrintSafety"};
	
	private String functionName="listPrintSafety";

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {

			SocialDistanceSMLProvided aSocialDistanceFileProvided = (SocialDistanceSMLProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceSMLProvided.class);			
			if (aSocialDistanceFileProvided.getRequiredFile() == null) 
				return fail ("A Social Distance File not Found");
			
			
			int [][] randomlySelected = new int [3][5];
			for(int i=0;i<randomlySelected.length;i++)
				for(int j=0;j<randomlySelected[0].length;j++)
					randomlySelected[i][j]=(int)(Math.random()*this.getInputList().length);
			
			String [] inputs = generateFunctionCalls(randomlySelected);
			RunningProject aRunningProject = createRunningProject(project,aSocialDistanceFileProvided.getFileName(),inputs);
			if (aRunningProject == null) 
				return fail ("Could not create project. See console messages.");
			
			aRunningProject.await();
			
			String output = aRunningProject.getOutput();
			if (output == null || output.length()==0) 
				return fail ("Could not generate output. See console messages.");
			
			String [] regexChecks=generateRegexs(randomlySelected,
					CorrectValues.getGivenSafeRegexChecks(),
					CorrectValues.getInterpolatedRegexChecks(),
					CorrectValues.getDerivedSafeRegexChecks());
			
			boolean aRetval = regexOutputChecksFailurePrint(parseToReadable(output.split("\n")),regexChecks,inputs);

			if (!aRetval) 
				return fail("View console for more detail");
			return pass();
			

		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}
	
	private String[] generateRegexs(int [][] randomlySelected,boolean[]... expectedValues ) {
		int [][] inputList = getInputList();
		List<String> vals = new ArrayList<String>();
		
		for(int i=0;i<randomlySelected.length;i++) 
		for(int k=0;k<printMethods.length;k++)
		for(int m=0;m<functions.length;m++)
			for(int j=0;j<randomlySelected[i].length;j++) 
				if(k==0) 
					vals.add(".*[Dd]istance:"+inputList[randomlySelected[i][j]][0]+
								 " [Dd]uration:"+inputList[randomlySelected[i][j]][1]+
								 " [Ee]xhalation:"+inputList[randomlySelected[i][j]][2]+
								 " [Ss]afe:"+expectedValues[m][randomlySelected[i][j]]+".*");
					
				else if(k==1)
					vals.add(".*("+inputList[randomlySelected[i][j]][0]+
								 ", *"+inputList[randomlySelected[i][j]][1]+
								 ", *"+inputList[randomlySelected[i][j]][2]+
								 ", *"+expectedValues[m][randomlySelected[i][j]]+").*");
		
		String [] retVal = new String[vals.size()];
		vals.toArray(retVal);
		
		return retVal;
	}
	
	protected String [] generateFunctionCalls(int[][] randomlySelected) {		int [][] inputList = getInputList();
		setInputNewLine(8);
		
		List<String> vals = new ArrayList<String>();
		vals.add(getReadabilityCommand());
		for(int i=0;i<randomlySelected.length;i++) {
			String testFeatures="val testFeatures=[";
			for(int j=0;j<randomlySelected[i].length;j++) {
				String input = "("+inputList[randomlySelected[i][j]][0]
						+","+inputList[randomlySelected[i][j]][1]
						+","+inputList[randomlySelected[i][j]][2]+")";
				testFeatures=j==0?testFeatures+input:testFeatures+","+input;
			}
			testFeatures=testFeatures+"];";	
			vals.add(testFeatures);
			for(int j=0;j<printMethods.length;j++)
				for(int k=0;k<functions.length;k++)
					vals.add(functionName+"("+printMethods[j]+","+functions[k]+",testFeatures);");
		}
		
		String [] retVal = new String[vals.size()];
		vals.toArray(retVal);
		
		return retVal;
	}
	
}
