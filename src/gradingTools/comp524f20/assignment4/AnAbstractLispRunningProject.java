package gradingTools.comp524f20.assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.RunningProject;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.AnAbstractRegexLineChecker;
import gradingTools.utils.RunningProjectUtils;

public abstract class AnAbstractLispRunningProject extends AnAbstractRegexLineChecker {
	public static final int TIME_OUT_SECS = 4; // secs
		
	protected int getTimeout() {
		return BasicExecutionSpecificationSelector.getBasicExecutionSpecification().getProcessTimeOut();
	}
	public AnAbstractLispRunningProject() {
	}
	
	private String forReadability = "(print \"Results:\")";
	protected String getReadabilityCommand() {
		return forReadability;
	}
	
	
	protected RunningProject createRunningProject (Project aProject, String fileName, String... inputs) {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.LISP_LANGUAGE);
		RunningProject aRunningProject = RunningProjectUtils.runProjectandWithMainFile(aProject, fileName, TIME_OUT_SECS,inputs);
		return aRunningProject;
	}
	
	protected String [] combineArrays(String[]... arrays) {
		List<String> combined = new ArrayList<String>();
		for(String[] array:arrays)
			for(String value:array)
				combined.add(value);
		String [] retVal = new String[combined.size()];
		combined.toArray(retVal);
		return retVal;
	}

	protected String[] parseToReadable(String [] allOutput) {
		for(int i=0;i<allOutput.length;i++)
			if(allOutput[i].matches(".*Results.*"))
				return Arrays.copyOfRange(allOutput, i-1, allOutput.length);
		
		System.err.println("ERROR: Unable to find results of sperator print statment"); 
		System.err.println("Please check your code in eclipse and see if it compiles with no errors.");
		System.err.println("Here is the collected output:");
		for(int i=0;i<allOutput.length;i++)
			System.out.println(allOutput[i]);
		throw new NotGradableException("potential error when compiling your lisp file");
	}

	protected String [] boolToRegex(boolean [] list) {
		String [] retVal =new String[list.length];
		for(int i=0;i<list.length;i++)
			if(list[i])
				retVal[i]=".*T.*";
			else
				retVal[i]=".*NIL.*";
		return retVal;
	}
	
}
