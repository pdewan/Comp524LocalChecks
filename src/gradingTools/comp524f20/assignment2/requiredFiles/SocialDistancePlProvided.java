package gradingTools.comp524f20.assignment2.requiredFiles;

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
public class SocialDistancePlProvided extends PassFailJUnitTestCase {
	protected File socialDistancePl;

	protected String fileName="SocialDistance.pl";
	
	
	public File getRequiredFile() {
		return socialDistancePl;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {	
		 
		 try {
			String socializationTextFile = getFileName();
			File socialDistancefile = new File(project.getSourceFolder()+"/"+socializationTextFile);
		    
			if(!socialDistancefile.exists()||!socialDistancefile.isFile())
				return fail(socializationTextFile+" not found");
			
			socialDistancePl=socialDistancefile;
			return pass();		
		 } 		 catch (Exception e) {
			 return fail (e.getMessage());
		 } catch (Throwable e) {
			 	return fail(e.getMessage());
		}
	}

}
