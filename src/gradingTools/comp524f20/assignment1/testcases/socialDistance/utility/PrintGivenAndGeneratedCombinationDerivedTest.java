package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import java.lang.reflect.Method;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.execution.ResultWithOutput;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityProvided;
import util.annotations.MaxValue;
@MaxValue(5)
public class PrintGivenAndGeneratedCombinationDerivedTest extends AbstractPrintDerivedSafetyValidator {
	public static final int TIME_OUT_MSECS = 300; // secs
	
	protected final String methodName = "printGivenAndGeneratedCombinationsDerivedSafety";

	//the expected output for first 8 lines
	protected static String[] anExpectedOutput= {
			"Distance,Duration,Exhalation,IsSafe",
			"13,30,30,true",
			"6,30,10,true",
			"27,30,50,true",
			"13,15,50,true",
			"13,120,10,true",
			"27,120,30,true",
			"6,15,30,true"
	};
	protected String[] anExpectedOutput() {
		return anExpectedOutput;
	}
	
	public PrintGivenAndGeneratedCombinationDerivedTest() {
	}
	

	
	@Override
	protected  String methodName() {
		return methodName;
	}

	protected boolean isOutputValid(String[] anOutputLines,Class aUtilityClass,Method aVerifyingMethod) throws Throwable {
		String [] anExpectedOutputList=anExpectedOutput();
	    boolean passing=true;
	    for(int i=0;i<anOutputLines.length;i++) {
	    	if(i<anExpectedOutputList.length) {
	    		if(!anExpectedOutputList[i].equals(anOutputLines[i])) {
	    			passing=false;
	    			System.err.println("Output line: \""+anOutputLines[i]+"\" does not match expected \""+anExpectedOutputList[i]+"\"");
	    		}
	    	}else if (i==anExpectedOutputList.length) {
	    		if(!anOutputLines[i].matches("-+?")) {
	    			passing=false;
		    		System.err.println("Output line: \""+anOutputLines[i]+"\" does not match regex \"-+\"");
	    		}
	    	}else {
	    		if(!verify(anOutputLines[i],aUtilityClass,aVerifyingMethod)){
	    			passing=false;
	    			System.err.println("Result on line: \""+anOutputLines[i]+"\" does not match expected result for method:\""+ verifyingMethodName() +"\"");
	    		}
	    	}
	    }
	    return passing;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
			SocialDistanceUtilityProvided aSocialDistanceUilityProvided = (SocialDistanceUtilityProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceUtilityProvided.class);
			Class aUtilityClass = aSocialDistanceUilityProvided.getRequiredClass();
			
//			SocialDistanceClassRegistry aClassRegistry = aClassRegistryProvided.getTimingOutClassRegistryProxy();  
		    if (aUtilityClass == null) {
		    	return fail ("No utility class");
		    }
		    Class[] aParameterTypes = argumentTypes();
		    Method aMethod = aUtilityClass.getMethod(methodName(), aParameterTypes);
		    Object[] anArguments = getArguments();
		    ResultWithOutput aResultWithOutput1 = BasicProjectExecution.timedInteractiveInvoke(aUtilityClass, aMethod, anArguments, TIME_OUT_MSECS);
		    
		    String anOutput1 = aResultWithOutput1.getOutput().replaceAll("I\\*\\*\\*.*\n", "");
		    if (anOutput1 == null || anOutput1.isEmpty() ) {
		    	return fail("No Output");
		    }
		    
		    String [] anOutputLines1 = anOutput1.split("\n");
		    if (anOutputLines1.length != 19) {
		    	return fail("Output does not match desired line length");
		    }
		    
		    ResultWithOutput aResultWithOutput2 = BasicProjectExecution.timedInteractiveInvoke(aUtilityClass, aMethod, anArguments, TIME_OUT_MSECS);
		    
		    String anOutput2 = aResultWithOutput2.getOutput().replaceAll("I\\*\\*\\*.*\n", "");
		    if (anOutput2 == null || anOutput2.isEmpty() ) {
		    	return fail("No Output");
		    }
		    
		    String [] anOutputLines2 = anOutput2.split("\n");
		    if (anOutputLines2.length != 19) {
		    	return fail("Output does not match desired line length");
		    }
		    
		    if (anOutput1.equals(anOutput2)) {
		    	return fail("Two successive calls return same output");
		    }
		   
		    Method aVerifyingMethod =  aUtilityClass.getMethod(verifyingMethodName(), verifyingArgumentTypes()); 
		    
		    boolean passing=isOutputValid(anOutputLines1,aUtilityClass,aVerifyingMethod)&&isOutputValid(anOutputLines2,aUtilityClass,aVerifyingMethod);
		    
		    return passing?pass():fail("View console output for more information");

		} catch ( Throwable e) {
			System.err.println(e);
			throw new NotGradableException("caused by:" + e.toString());
		}
	}
}
