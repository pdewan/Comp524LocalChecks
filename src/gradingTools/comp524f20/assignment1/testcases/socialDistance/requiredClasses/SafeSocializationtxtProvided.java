package gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses;

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
//@MaxValue(2)
public class SafeSocializationtxtProvided extends PassFailJUnitTestCase {
	protected File socialDistanceText;

	public File getRequiredFile() {
		return socialDistanceText;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {	
		 
		 try {
			File socialDistancefile = new File(project.getProjectFolder()+"/SafeSocialization.txt");
		    
			if(!socialDistancefile.exists()||!socialDistancefile.isFile())
				return fail("SocialDistance.txt not found");
			
			socialDistanceText=socialDistancefile;
			
//			Scanner scan = new Scanner(socialDistancefile);
//			while(scan.hasNextLine()) {
//				System.out.println(scan.nextLine());
//			}
			
			return pass();		
		 } 		 catch (Exception e) {
			 return fail (e.getMessage());
		 } catch (Throwable e) {
			 	return fail(e.getMessage());
		}
	}

}
