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
@MaxValue(10)
public class CompareSafetyComputationsTest extends AbstractPrintDerivedSafetyValidator {
	public static final int TIME_OUT_MSECS = 300; // secs
	
	protected final String derivedMethodName = "isDerivedSafe";
	protected final String inferredMethodName = "isInferredSafe";
	protected final String methodName="compareSafetyComputations";
	
	public CompareSafetyComputationsTest() {
	}	
	
	protected  String derivedMethodName() {
		return derivedMethodName;
	}
	
	@Override
	protected String methodName() {
		return methodName;
	}
	
	protected  String inferredMethodName() {
		return inferredMethodName;
	}

	protected Double accuracy=null;
	protected Double getAccuracy(){
		return accuracy;
	};
	
	protected boolean isPassing=false;
	public boolean isPassing() {
		return isPassing;
	}
	
	
	protected boolean isOutputValid(String[] anOutputLines,Class aUtilityClass,Method aDerivedVerifyingMethod,Method aInferredVerifyingMethod) throws Throwable {
		
		for(int i=0;i<anOutputLines.length;i++) {
			if(i==0) 
				if(anOutputLines[i].matches("[Dd]istance,[Dd]uration,[Ee]xhalation,[Dd]erived,[Ii]nferred\n*?"))
					continue;
				else {
					System.out.println("Initial line does not match required format: [Dd]istance,[Dd]uration,[Ee]xhalation,[Dd]erived,[Ii]nferred");
					return false;
				}
			String [] anOutputComponents=anOutputLines[i].split(",");
			if(anOutputComponents.length!=5)
				throw new NotGradableException("Output does not have 5 command separated components");
			
			String dataValues=anOutputComponents[0]+","+anOutputComponents[1]+","+anOutputComponents[2]+",";
			if(!(verify(dataValues+anOutputComponents[3],aUtilityClass,aDerivedVerifyingMethod)
			    &verify(dataValues+anOutputComponents[4],aUtilityClass,aInferredVerifyingMethod)))
				return false;	
		}
	    return true;
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
		    
//		    ResultWithOutput aResultWithOutput1 = BasicProjectExecution.timedInteractiveInvoke(aUtilityClass, aMethod, anArguments, TIME_OUT_MSECS);
//		    String anOutput1 = aResultWithOutput1.getOutput();
//		    if (anOutput1 == null || anOutput1.isEmpty() ) {
//		    	return fail("No Output");
//		    }
//		    
//		    String [] anOutputLines1 = anOutput1.split("\n");
//		    if (anOutputLines1.length != 11) {
//		    	return fail("Output does not match desired line length");
//		    }
//		    
//		    ResultWithOutput aResultWithOutput2 = BasicProjectExecution.timedInteractiveInvoke(aUtilityClass, aMethod, anArguments, TIME_OUT_MSECS);
//		    
//		    String anOutput2 = aResultWithOutput2.getOutput();
//		    if (anOutput2 == null || anOutput2.isEmpty() ) {
//		    	return fail("No Output");
//		    }
//		    
//		    String [] anOutputLines2 = anOutput2.split("\n");
//		    if (anOutputLines2.length != 11) {
//		    	return fail("Output does not match desired line length");
//		    }
//		    
//		    if (anOutput1.equals(anOutput2)) {
//		    	return fail("Two successive calls return same output");
//		    }
		    
		    Method aVerifyingMethodDerived =  aUtilityClass.getMethod(derivedMethodName(), verifyingArgumentTypes()); 
		    Method aVerifyingMethodInferred=  aUtilityClass.getMethod(inferredMethodName(), verifyingArgumentTypes());
		    String lastOutput=null;
		    int numberCorrect=0;
		    int trials=10;
		    for(int i=0;i<trials;i++) {
		    	ResultWithOutput aResultWithOutput = BasicProjectExecution.timedInteractiveInvoke(aUtilityClass, aMethod, anArguments, TIME_OUT_MSECS);
			    String anOutput = aResultWithOutput.getOutput().replaceAll("I\\*\\*\\*.*\n", "");
			    int retVal = (int) aResultWithOutput.getResult();
			    
			    String [] anOutputLines = anOutput.split("\n");
			    if (anOutputLines.length != 11) 
			    	return fail("Output does not match desired line length");
			    
			    if(lastOutput!=null&&lastOutput.equals(anOutput)) 
				    return fail("Two successive calls return same output");
			    lastOutput=anOutput;
			    
			    if(!isOutputValid(anOutputLines,aUtilityClass,aVerifyingMethodDerived,aVerifyingMethodInferred))
			    	return fail("An output does not match expected from isInferredSafe and/or isDerivedSafe");
			    
			    int correctCheck=0;
			    for(int j=1;j<anOutputLines.length;j++) {
			    	String[] methodResults=anOutputLines[j].split(",");
			    	if(methodResults[3].startsWith(methodResults[4]))
			    		correctCheck++;
			    }
			    
			    if(correctCheck!=retVal) {
			    	return fail("returned integer does not match determined correct values");
			    }
			    numberCorrect+=correctCheck;
		    }
		    
		    
		    
		    isPassing=true;
//		    double accuracy=((double)numberCorrect)/(trials*10);
//		    return accuracy >= 0.8?pass():partialPass(accuracy, "accuracy for tests too low"); 
		    return pass();

		} catch ( Throwable e) {
			System.err.println(e.getMessage());
			throw new NotGradableException(e.getMessage());
		}
	}

}
