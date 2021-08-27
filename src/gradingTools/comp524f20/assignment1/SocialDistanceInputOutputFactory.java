package gradingTools.comp524f20.assignment1;

public class SocialDistanceInputOutputFactory {

	public static final int SMALL_DISTANCE=6,MEDIUM_DISTANCE=13,LARGE_DISTANCE=27;
	public static final int SMALL_DURATION=15,MEDIUM_DURATION=30,LARGE_DURATION=120;
	public static final int SMALL_EXHALATION=10,MEDIUM_EXHALATION=30,LARGE_EXHALATION=50;
	
	private static boolean[] INTERPOLATED_VALUES=null,
							 GIVENSAFE_VALUES=null,
							 DERIVEDSAFE_VALUES=null;
	private static int [][] INPUT_VALUES=null;
	
	public static boolean[] getGivenSafeRegexChecks() {
		if(GIVENSAFE_VALUES==null)
			GIVENSAFE_VALUES=generateGivenSafe();
		return GIVENSAFE_VALUES;
	}
	
	public static boolean[] getInterpolatedRegexChecks() {
		if(INTERPOLATED_VALUES==null)
			INTERPOLATED_VALUES=generateInterpolatedSafe();
		return INTERPOLATED_VALUES;
	}
	
	public static boolean[] getDerivedSafeRegexChecks() {
		if(DERIVEDSAFE_VALUES==null)
			DERIVEDSAFE_VALUES=generateDerivedSafe();
		return DERIVEDSAFE_VALUES;
	}
	
	public static int [][] getInputs(){
		if(INPUT_VALUES==null)
			INPUT_VALUES=generateInputList();
		return INPUT_VALUES;	
	}
	
	public static Object[] boolToObj(boolean [] answers) {
		Object [] obj = new Object[answers.length];
		for(int i=0;i<obj.length;i++)
			obj[i] = (Object)answers[i];
		return obj;
	}
	
	public static Object [][] intToObjs(int [][] inputs){
		Object [][] objs = new Object[inputs.length][];
		for(int i=0;i<inputs.length;i++) {
			objs[i]=new Object[inputs[i].length];
			for(int j=0;j<inputs[i].length;j++)
				objs[i][j]=(Object)inputs[i][j];
		}
		return objs;
	}
	
	private final static boolean [] generateInterpolatedSafe(){
		boolean [] temp = {
			true, //1
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //2
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //3
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //4
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //5
			true,
			true,
			true,
			true,
			true,
			true,
			
			false, //6
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //7
			false,
			false,
			false,
			false,
			false,
			
			false, //8
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //9
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //10
			false,
			false,
			false,
			false,
			false,
			false
		};
		return temp;
	}
	
	private final static boolean[] generateGivenSafe() {
		boolean [] temp = {	
			true, //1
			true,
			true,
			true,
			true,
			true,
			true,
			
			false, //2
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //3
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //4
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //5
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //6
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //7
			false,
			false,
			false,
			false,
			false,
			
			false, //8
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //9
			false,
			false,
			false,
			false,
			false,
			false,
			
			false,	//10
			false,
			false,
			false,
			false,
			false,
			false
		};
		return temp;
	}

	private final static boolean[] generateDerivedSafe() {
		boolean [] temp = {
			true, //1
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //2
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //3
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //4
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //5
			true,
			true,
			true,
			true,
			true,
			true,
			
			true, //6
			false,
			false,
			false,
			false,
			false,
			false,
			
			true, //7
			true,
			true,
			false,
			false,
			false,
			
			true, //8
			true,
			true,
			true,
			true,
			true,
			false,
			
			false, //9
			false,
			false,
			false,
			false,
			false,
			false,
			
			false, //10
			false,
			false,
			false,
			false,
			false,
			false
		};
		return temp;
	}
	
	private final static int [][] generateInputList(){
		int [][] temp = {
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
			{SMALL_DISTANCE+1,SMALL_DURATION-1,MEDIUM_EXHALATION-1}, //multi change right above
			
			{LARGE_DISTANCE-1,MEDIUM_DURATION,MEDIUM_EXHALATION}, //4
			{MEDIUM_DISTANCE-1,MEDIUM_DURATION,SMALL_EXHALATION},
			{LARGE_DISTANCE,SMALL_DURATION+1,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,0,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,LARGE_DURATION,0},
			{LARGE_DISTANCE,LARGE_DURATION,SMALL_EXHALATION+1},
			{MEDIUM_DISTANCE-1,SMALL_DURATION,MEDIUM_EXHALATION}, //single extreme change
			
			{LARGE_DISTANCE-1,SMALL_DURATION+1,SMALL_EXHALATION+1}, //5
			{MEDIUM_DISTANCE-1,SMALL_DURATION+1,0},
			{500,SMALL_DURATION+1,MEDIUM_EXHALATION+1},
			{LARGE_DISTANCE-1,0,MEDIUM_EXHALATION+1},
			{LARGE_DISTANCE-1,MEDIUM_DURATION+1,0},
			{500,MEDIUM_DURATION+1,SMALL_EXHALATION+1},
			{MEDIUM_DISTANCE-1,0,SMALL_EXHALATION+1}, //multi extreme change
			
			//6-8 are all possible combinations not on the chart
			{SMALL_DISTANCE,SMALL_DURATION,SMALL_EXHALATION}, //6
			{SMALL_DISTANCE,SMALL_DURATION,LARGE_EXHALATION},
			{SMALL_DISTANCE,MEDIUM_DURATION,MEDIUM_EXHALATION},
			{SMALL_DISTANCE,MEDIUM_DURATION,LARGE_EXHALATION},
			{SMALL_DISTANCE,LARGE_DURATION,SMALL_EXHALATION},
			{SMALL_DISTANCE,LARGE_DURATION,MEDIUM_EXHALATION},
			{SMALL_DISTANCE,LARGE_DURATION,LARGE_EXHALATION}, //false values
			
			{MEDIUM_DISTANCE,SMALL_DURATION,SMALL_EXHALATION}, //7
			{MEDIUM_DISTANCE,SMALL_DURATION,MEDIUM_EXHALATION},
			{MEDIUM_DISTANCE,MEDIUM_DURATION,SMALL_EXHALATION},
			{MEDIUM_DISTANCE,MEDIUM_DURATION,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,LARGE_DURATION,MEDIUM_EXHALATION},
			{MEDIUM_DISTANCE,LARGE_DURATION,LARGE_EXHALATION}, //more false
			
			{LARGE_DISTANCE,SMALL_DURATION,SMALL_EXHALATION}, //8
			{LARGE_DISTANCE,SMALL_DURATION,MEDIUM_EXHALATION},
			{LARGE_DISTANCE,SMALL_DURATION,LARGE_EXHALATION},
			{LARGE_DISTANCE,MEDIUM_DURATION,SMALL_EXHALATION},
			{LARGE_DISTANCE,MEDIUM_DURATION,MEDIUM_EXHALATION},
			{LARGE_DISTANCE,LARGE_DURATION,SMALL_EXHALATION},
			{LARGE_DISTANCE,LARGE_DURATION,LARGE_EXHALATION}, //more false
			
			{LARGE_DISTANCE,500,LARGE_EXHALATION}, //9
			{LARGE_DISTANCE,LARGE_DURATION,500},
			{SMALL_DISTANCE-1,SMALL_DURATION,MEDIUM_EXHALATION},
			{MEDIUM_DISTANCE,LARGE_DURATION+1,SMALL_EXHALATION},
			{LARGE_DISTANCE,LARGE_DURATION,MEDIUM_EXHALATION+1},
			{0,SMALL_DURATION,SMALL_EXHALATION},
			{SMALL_DISTANCE,SMALL_DURATION,500}, //all false single change
			
			{500,500,500},
			{128,128,128},
			{0,0,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,0,LARGE_EXHALATION+1},
			{0,0,0},
			{(LARGE_DISTANCE+MEDIUM_DISTANCE)/2,(MEDIUM_DURATION+SMALL_DURATION)/2,LARGE_EXHALATION},
			{LARGE_DISTANCE-1,LARGE_DURATION+1,LARGE_EXHALATION+1}
		};
		return temp;
	}
	
}
