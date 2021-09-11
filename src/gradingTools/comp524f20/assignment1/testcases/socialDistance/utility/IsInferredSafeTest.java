package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import java.io.File;
import java.lang.reflect.Method;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment1.SocialDistanceInputOutputFactory;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SafeSocializationTxtProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityProvided;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@MaxValue(45)
@Explanation("Checks for table, table off by one, and Random Value inputs")
public class IsInferredSafeTest extends AbstractPrintDerivedSafetyValidator {
	public static final int TIME_OUT_MSECS = 300; // secs
	
	protected Class[] parameterTypes= {Integer.TYPE,Integer.TYPE,Integer.TYPE};
	
	protected String methodName="isInferredSafe";
	
	private static final int LARGE_DISTANCE=SocialDistanceInputOutputFactory.LARGE_DISTANCE;
	private static final int LARGE_DURATION=SocialDistanceInputOutputFactory.LARGE_DURATION;
	private static final int LARGE_EXHALATION=SocialDistanceInputOutputFactory.LARGE_EXHALATION;
	private static final double MODIFIER=1.1;
	
	protected Object[][] getSpecifiedTests(){
		int [][] inputs = SocialDistanceInputOutputFactory.getInputs();
		return SocialDistanceInputOutputFactory.intToObjs(inputs);
	}
	
	protected Class[] getParameterTypes() {
		return parameterTypes;
	};

	public IsInferredSafeTest() {
	}

	
	protected String methodName() {
		return methodName;
	};
	
	protected int aRandomNumber(int max, double modifier) {
		return (int)(Math.random()*modifier*max);
	}
	
	protected boolean verifyDerivedSafe() {
		DerivedSafetyTest derivedTest = (DerivedSafetyTest) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(DerivedSafetyTest.class);
		return derivedTest == null || !derivedTest.allTestsPassed();
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
			
			SocialDistanceUtilityProvided aSocialDistanceUilityProvided = (SocialDistanceUtilityProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceUtilityProvided.class);
			Class aUilityClass = aSocialDistanceUilityProvided.getRequiredClass();
			SafeSocializationTxtProvided aSafeSocializationFileProvided = (SafeSocializationTxtProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SafeSocializationTxtProvided.class);
			File aSafeSocilizationFile = aSafeSocializationFileProvided.getRequiredFile();
			
			
			
//			SocialDistanceClassRegistry aClassRegistry = aClassRegistryProvided.getTimingOutClassRegistryProxy();  
		    if (aUilityClass == null) {
		    	return fail ("No utility class");
		    }
		    if (aSafeSocilizationFile == null) {
		    	return fail ("Missing SafeSocialization.txt");
		    }
		    
		    if (verifyDerivedSafe()) {
		    	return fail ("DerivedSafetyTest must pass fully before this test can be properly executed");
		    }
		    
//		    Classifier classifier = new J48();
//		    WekaUtil.buildTreeModel(classifier, aSafeSocilizationFile.toString());
		    
		    
		    Class[] aParameterTypes = getParameterTypes();
		    Method aMethod = aUilityClass.getMethod(methodName(), aParameterTypes);
		    Method aVerifyingMethod = aUilityClass.getMethod(verifyingMethodName(), verifyingArgumentTypes());
		    
		    int tableCorrect=0;
		    int nearTableCorrect=0;
		    int randomCorrect=0;
		    
		    int numTrials=100;
		    Object[][] presetInputs=getSpecifiedTests();
		    
		    for (int anIndex = 0; anIndex < numTrials; anIndex++ ) {
		    	
		    	Object[] anInputCombination;
		    	
		    	if(anIndex<presetInputs.length) {
		    		anInputCombination=presetInputs[anIndex];
		    	}else {
		    		Object[] randomOutput= {aRandomNumber(LARGE_DISTANCE,MODIFIER),
							   aRandomNumber(LARGE_DURATION,MODIFIER),
							   aRandomNumber(LARGE_EXHALATION,MODIFIER)};
		    		anInputCombination=randomOutput;
		    	}
		    	
//		    	double[] anInputCombination = {aRandomNumber(LARGE_DISTANCE,MODIFIER),
//		    								   aRandomNumber(LARGE_DURATION,MODIFIER),
//		    								   aRandomNumber(LARGE_EXHALATION,MODIFIER)};
		    	
//		    	Object anExpectedResult = "true".equals(WekaUtil.predictString(
//		    	          classifier,
//		    	          new String[] {"distance", "duration", "exhalation"},
//		    	          anInputCombination, //new double[] {(double)anInputCombination[0],(double)anInputCombination[1],(double)anInputCombination[2]},
//		    	          "safe",
//		    	          new String[] {"true", "false"}));
		    	
//			    Boolean aRetVal =  (Boolean) BasicProjectExecution.timedInvoke(aUilityClass, aMethod,new Object[]{(int)anInputCombination[0],(int)anInputCombination[1],(int)anInputCombination[2]}, TIME_OUT_MSECS);
		    	Boolean aRetVal =  (Boolean) BasicProjectExecution.timedInvoke(aUilityClass, aMethod,anInputCombination, TIME_OUT_MSECS);
			    
			    if (verify(anInputCombination[0].toString()+","
			    		  +anInputCombination[1].toString()+","
			    		  +anInputCombination[2].toString()+","
			    		  +aRetVal,aUilityClass,aVerifyingMethod)) {
//			    		  +(anIndex%2==1?"false":"true"),aUilityClass,aVerifyingMethod)) {
			    	if(anIndex<7) {
			    		tableCorrect++;
			    	}else if(anIndex<presetInputs.length){
			    		nearTableCorrect++;
			    	}else {
			    		randomCorrect++;
			    	}
			    }

		    }
		    
		    double aPercentage=0;
		   	double [] resultPercentages= {
		    		((double)tableCorrect)/7,
		    		((double)nearTableCorrect)/(presetInputs.length-7),
		    		((double)randomCorrect)/(numTrials-presetInputs.length)
		    };
		   	double [] thresholdPercentages= {
		   			0.95,
		   			0.65,
		   			0.8
		   	};
		   	String [] testNames= {
		   			"table value",
		   			"near table value",
		   			"random value",
		   	};
		    
		   	for(int i=0;i<resultPercentages.length;i++) {
		   		if (resultPercentages[i]<thresholdPercentages[i]) {
		   			System.out.println("When testing " + testNames[i]+" the accuracy was found to be "+resultPercentages[i]+" the minimum required accuracy threshold should be "+thresholdPercentages[i]);
		   			aPercentage+=(1.0/resultPercentages.length)*(resultPercentages[i]/thresholdPercentages[i]);
		   		}else {
		   			aPercentage+=(1.0/resultPercentages.length);		   			
		   		}
		   		System.out.println(resultPercentages[i]);
		   	}
		   	
		   	
		    return aPercentage == 1?pass():partialPass(aPercentage, "view console output");  


		} catch ( Throwable e) {
			throw new NotGradableException();
		}
	}
}
