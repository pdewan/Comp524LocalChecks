package gradingTools.comp524f20.assignment1.testcases.socialDistance.style;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.basics.sharedTestCase.checkstyle.NamedConstants;
import gradingTools.basics.sharedTestCase.checkstyle.PublicMethodsOverride;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(10)
@IsExtra(true)
public class A1PublicMethodsOverride extends PublicMethodsOverride{
	 public A1PublicMethodsOverride() {
		 super();
	 }
	
	public TestCaseResult test(Project aProject, boolean autoGrade) throws NotAutomatableException, NotGradableException {
	        return super.test(aProject, autoGrade);

	        
	    }
}
