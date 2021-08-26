package gradingTools.comp524f20.assignment3.requiredFiles;

import java.io.File;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import util.annotations.MaxValue;

@MaxValue(2)
public class SocialDistanceSMLProvided extends PassFailJUnitTestCase {
	protected File socialDistanceSML;

	protected String fileName="SocialDistance.sml";
	
	
	public File getRequiredFile() {
		return socialDistanceSML;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {	
		 
		 try {
			String socializationTextFile = getFileName();
			String fileLocation= project.getSourceFolder()+"/"+socializationTextFile;
			File socialDistancefile = new File(fileLocation);
		    
			if(!socialDistancefile.exists()||!socialDistancefile.isFile())
				return fail(fileLocation+" not found");
			
			socialDistanceSML=socialDistancefile;
			return pass();		
		 } 		 catch (Exception e) {
			 return fail (e.getMessage());
		 } catch (Throwable e) {
			 	return fail(e.getMessage());
		}
	}

}
