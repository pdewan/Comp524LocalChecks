package gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses;

import java.io.File;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
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
			String socializationTextFile = "SafeSocialization.txt";
			File socialDistancefile = new File(project.getProjectFolder()+"/"+socializationTextFile);
		    
			if(!socialDistancefile.exists()||!socialDistancefile.isFile())
				return fail(socializationTextFile+" not found");
			
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
