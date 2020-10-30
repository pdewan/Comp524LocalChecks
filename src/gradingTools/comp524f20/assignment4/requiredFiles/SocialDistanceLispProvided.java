package gradingTools.comp524f20.assignment4.requiredFiles;

import java.io.File;
import java.util.Scanner;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f20.assignment0_1.GreetingClassRegistry;
import gradingTools.comp524f20.assignment0_1.GreetingClassRegistryProvided;
import gradingTools.comp524f20.assignment1.SocialDistanceClassRegistry;
import main.ClassRegistry;
import main.lisp.parser.terms.BasicExpression;
import main.lisp.parser.terms.SExpression;
import util.annotations.MaxValue;

@MaxValue(2)
public class SocialDistanceLispProvided extends PassFailJUnitTestCase {
	protected File socialDistanceLisp;

	protected String fileName="SocialDistance.lisp";
	
	
	public File getRequiredFile() {
		return socialDistanceLisp;
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
			
			socialDistanceLisp=socialDistancefile;
			return pass();		
		 } 		 catch (Exception e) {
			 return fail (e.getMessage());
		 } catch (Throwable e) {
			 	return fail(e.getMessage());
		}
	}

}
