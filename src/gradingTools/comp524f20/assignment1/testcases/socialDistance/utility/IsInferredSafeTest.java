package gradingTools.comp524f20.assignment1.testcases.socialDistance.utility;

import java.io.File;
import java.lang.reflect.Method;

import grader.basics.execution.BasicProjectExecution;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SafeSocializationtxtProvided;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.requiredClasses.SocialDistanceUtilityProvided;
import util.annotations.Explanation;
import util.annotations.MaxValue;
@MaxValue(45)
@Explanation("Checks for table, table off by one, and Random Value inputs")
public class IsInferredSafeTest extends AbstractPrintDerivedSafetyValidator {
	public static final int TIME_OUT_MSECS = 100; // secs
	
	protected Class[] parameterTypes= {Integer.TYPE,Integer.TYPE,Integer.TYPE};
	
	protected String methodName="isInferredSafe";
	
	private static final int SMALL_DISTANCE=6,MEDIUM_DISTANCE=13,LARGE_DISTANCE=27;
	private static final int SMALL_DURATION=15,MEDIUM_DURATION=30,LARGE_DURATION=120;
	private static final int SMALL_EXHALATION=10,MEDIUM_EXHALATION=30,LARGE_EXHALATION=50;
	private double MODIFIER=1.1;
	
	static Object[][] inputCombinations = {
			{MEDIUM_DISTANCE,MEDIUM_DURATION,MEDIUM_EXHALATION}, //1
			{SMALL_DISTANCE,MEDIUM_DURATION,SMALL_EXHALATION},
			{LARGE_DISTANCE,MEDIUM_DURATION,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,SMALL_DURATION,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,LARGE_DURATION,SMALL_EXHALATION},
			{LARGE_DISTANCE,LARGE_DURATION,MEDIUM_EXHALATION},
			{SMALL_DISTANCE,SMALL_DURATION,MEDIUM_EXHALATION}, //all after here false for given
			
			{MEDIUM_DISTANCE+1,MEDIUM_DURATION,MEDIUM_EXHALATION}, //2
			{SMALL_DISTANCE+1,MEDIUM_DURATION,SMALL_EXHALATION},
			{LARGE_DISTANCE,MEDIUM_DURATION-1,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,SMALL_DURATION-1,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,LARGE_DURATION,SMALL_EXHALATION-1},
			{LARGE_DISTANCE,LARGE_DURATION,MEDIUM_EXHALATION-1},
			{SMALL_DISTANCE+1,SMALL_DURATION,MEDIUM_EXHALATION}, //single change right above
			
			{MEDIUM_DISTANCE+1,MEDIUM_DURATION-1,MEDIUM_EXHALATION-1}, //3
			{SMALL_DISTANCE+1,MEDIUM_DURATION-1,SMALL_EXHALATION-1},
			{LARGE_DISTANCE+1,MEDIUM_DURATION-1,LARGE_EXHALATION-1},
			{MEDIUM_DISTANCE+1,SMALL_DURATION-1,LARGE_EXHALATION-1},
			{MEDIUM_DISTANCE+1,LARGE_DURATION-1,SMALL_EXHALATION-1},
			{LARGE_DISTANCE+1,LARGE_DURATION-1,MEDIUM_EXHALATION-1},
			{SMALL_DISTANCE+1,SMALL_DURATION-1,MEDIUM_EXHALATION-1},
			
			{LARGE_DISTANCE-1,MEDIUM_DURATION,MEDIUM_EXHALATION}, //4
			{MEDIUM_DISTANCE-1,MEDIUM_DURATION,SMALL_EXHALATION},
			{LARGE_DISTANCE,SMALL_DURATION+1,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,0,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,LARGE_DURATION,0},
			{LARGE_DISTANCE,LARGE_DURATION,SMALL_EXHALATION+1},
			{MEDIUM_DISTANCE-1,SMALL_DURATION,MEDIUM_EXHALATION}, //single extreme change
			
			{LARGE_DISTANCE-1,SMALL_DURATION+1,SMALL_EXHALATION+1}, //5
			{MEDIUM_DISTANCE-1,SMALL_DURATION+1,0},
			{Integer.MAX_VALUE,SMALL_DURATION+1,MEDIUM_EXHALATION+1},
			{LARGE_DISTANCE-1,0,MEDIUM_EXHALATION+1},
			{LARGE_DISTANCE-1,MEDIUM_DURATION+1,0},
			{Integer.MAX_VALUE,MEDIUM_DURATION+1,SMALL_EXHALATION+1},
			{MEDIUM_DISTANCE-1,0,SMALL_EXHALATION+1}, //multi extreme change
		};
	
	protected Object[][] getSpecifiedTests(){
		return inputCombinations;
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
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
			
			SocialDistanceUtilityProvided aSocialDistanceUilityProvided = (SocialDistanceUtilityProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceUtilityProvided.class);
			Class aUilityClass = aSocialDistanceUilityProvided.getRequiredClass();
			SafeSocializationtxtProvided aSafeSocializationFileProvided = (SafeSocializationtxtProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SafeSocializationtxtProvided.class);
			File aSafeSocilizationFile = aSafeSocializationFileProvided.getRequiredFile();
			DerivedSafetyTest derivedTest = (DerivedSafetyTest) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(DerivedSafetyTest.class);
			
			
//			SocialDistanceClassRegistry aClassRegistry = aClassRegistryProvided.getTimingOutClassRegistryProxy();  
		    if (aUilityClass == null) {
		    	return fail ("No utility class");
		    }
		    if (aSafeSocilizationFile == null) {
		    	return fail ("Missing SafeSocialization.txt");
		    }
		    
		    if (derivedTest == null || !derivedTest.allTestsPassed()) {
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
//	public static void processExternalMethodSNodes (RootOfProgramSNode aRootOfProgramSNode, RootOfFileSNode aRootOfFileSNode) {
//		for (SNode anSNode:aRootOfFileSNode.getChildren()) {
//			if (anSNode instanceof ExternalMethodSNode) {
//				processExternalMethodSNode(aRootOfProgramSNode, aRootOfFileSNode, (ExternalMethodSNode) anSNode);
//			}
//		}
//	}
//	public static void processExternalMethodSNode (RootOfProgramSNode aRootOfProgramSNode, RootOfFileSNode aRootOfFileSNode, ExternalMethodSNode anExternalMethodSNode) {
//		MethodSNode aMethodSNode = aRootOfProgramSNode.getExternalToInternalMethod().get(anExternalMethodSNode.toString());
//		if (aMethodSNode == null) {
//			aMethodSNode = findMethodSNode(aRootOfProgramSNode, aRootOfFileSNode, anExternalMethodSNode);
//			if (aMethodSNode != null) {
//				aRootOfProgramSNode.getExternalToInternalMethod().put(anExternalMethodSNode.toString(),aMethodSNode );
//			}
//		}
//		if (aMethodSNode != null) {
//			anExternalMethodSNode.setActualMethodSNode(aMethodSNode);
//		}
//	}
//	public static MethodSNode findMethodSNode (RootOfProgramSNode aRootOfProgramSNode, RootOfFileSNode aRootOfFileSNode, ExternalMethodSNode anExternalMethodSNode) {
////		MethodSNode foundMethodSNode = null;
//		for (String aFileName:aRootOfProgramSNode.getFileNameToSNode().keySet()) {
//			if (aFileName.equals(aRootOfFileSNode.getFileName()))
//				continue;
//			
//			RootOfFileSNode aSearchedRootOfFileSNode = aRootOfProgramSNode.getFileNameToSNode().get(aFileName);
//			 for (SNode anSNode:aSearchedRootOfFileSNode.getChildren()) {
//				if (anSNode instanceof MethodSNode && !(anSNode instanceof ExternalMethodSNode)) {
//					if (anSNode.toString().equals(anExternalMethodSNode)) {
//						return (MethodSNode) anSNode;
//						
//					}
////					processExternalMethodSNode(aRootOfProgramSNode, aRootOfFileSNode, (ExternalMethodSNode) anSNode);
//				}
//			}
//		}
//		return null;
//	}
//	public static void processExternalMethodSNodes (RootOfProgramSNode aRootOfProgramSNode) {
//		for (String aFileName:aRootOfProgramSNode.getFileNameToSNode().keySet()) {
//			RootOfFileSNode aRootOfFileSNode = aRootOfProgramSNode.getFileNameToSNode().get(aFileName);
//			processExternalMethodSNodes(aRootOfProgramSNode, aRootOfFileSNode);
//			
//		}
//
//	}
}
