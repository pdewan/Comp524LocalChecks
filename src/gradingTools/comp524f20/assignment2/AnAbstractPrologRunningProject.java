package gradingTools.comp524f20.assignment2;

import java.util.ArrayList;
import java.util.List;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.RunningProject;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.mains.AnAbstractRegexLineChecker;
import gradingTools.utils.RunningProjectUtils;

public abstract class AnAbstractPrologRunningProject extends AnAbstractRegexLineChecker {
	public static final int TIME_OUT_SECS = 1; // secs
		

	public AnAbstractPrologRunningProject() {
	}
	protected RunningProject createRunningProject (Project aProject, String fileName, String... inputs) {
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.PROLOG_LANGUAGE);
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

}
