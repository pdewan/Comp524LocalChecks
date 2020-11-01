package gradingTools.comp524f20.assignment4;

public abstract class AnAbstractThreeParameterLispRunningProject extends AnAbstractLispRunningProject {

	private static final int SMALL_DISTANCE=6,MEDIUM_DISTANCE=13,LARGE_DISTANCE=27;
	private static final int SMALL_DURATION=15,MEDIUM_DURATION=30,LARGE_DURATION=120;
	private static final int SMALL_EXHALATION=10,MEDIUM_EXHALATION=30,LARGE_EXHALATION=50;
	
	protected int[][] getInputList() {
		return inputList;
	}
	
	private int [][] inputList = {

			{LARGE_DISTANCE,LARGE_DURATION,MEDIUM_EXHALATION},
			{SMALL_DISTANCE,SMALL_DURATION,MEDIUM_EXHALATION}, //all after here false for given
			
			{MEDIUM_DISTANCE+1,MEDIUM_DURATION,MEDIUM_EXHALATION}, //2
			{SMALL_DISTANCE+1,MEDIUM_DURATION,SMALL_EXHALATION},

			{LARGE_DISTANCE+1,LARGE_DURATION-1,MEDIUM_EXHALATION-1},
			{SMALL_DISTANCE+1,SMALL_DURATION-1,MEDIUM_EXHALATION-1}, //multi change right above
			
			{LARGE_DISTANCE-1,MEDIUM_DURATION,MEDIUM_EXHALATION}, //4
			{MEDIUM_DISTANCE-1,MEDIUM_DURATION,SMALL_EXHALATION},
			
			{LARGE_DISTANCE-1,SMALL_DURATION+1,SMALL_EXHALATION+1}, //5
			{MEDIUM_DISTANCE-1,SMALL_DURATION+1,0},
			{500,SMALL_DURATION+1,MEDIUM_EXHALATION+1},
			
			//6-8 are all possible combinations not on the chart
			{SMALL_DISTANCE,SMALL_DURATION,SMALL_EXHALATION}, //6
			{SMALL_DISTANCE,SMALL_DURATION,LARGE_EXHALATION},
			{SMALL_DISTANCE,MEDIUM_DURATION,MEDIUM_EXHALATION},
			{SMALL_DISTANCE,MEDIUM_DURATION,LARGE_EXHALATION},
			
			{MEDIUM_DISTANCE,SMALL_DURATION,SMALL_EXHALATION}, //7
			{MEDIUM_DISTANCE,SMALL_DURATION,MEDIUM_EXHALATION},
			{MEDIUM_DISTANCE,MEDIUM_DURATION,SMALL_EXHALATION},
			{MEDIUM_DISTANCE,MEDIUM_DURATION,LARGE_EXHALATION},
			{MEDIUM_DISTANCE,LARGE_DURATION,MEDIUM_EXHALATION},
			{MEDIUM_DISTANCE,LARGE_DURATION,LARGE_EXHALATION}, //more false
			
			{LARGE_DISTANCE,SMALL_DURATION,SMALL_EXHALATION}, //8
			{LARGE_DISTANCE,MEDIUM_DURATION,MEDIUM_EXHALATION},
			{LARGE_DISTANCE,LARGE_DURATION,SMALL_EXHALATION},
			{LARGE_DISTANCE,LARGE_DURATION,LARGE_EXHALATION}, //more false
			
			{LARGE_DISTANCE,500,LARGE_EXHALATION}, //9
			{LARGE_DISTANCE,LARGE_DURATION,MEDIUM_EXHALATION+1},
			{0,SMALL_DURATION,SMALL_EXHALATION},
			{SMALL_DISTANCE,SMALL_DURATION,500},
	};
	
	protected boolean [] getChecks() {
		return checks;
	}
	private static boolean [] checks= {
		
			true,
			true,
			
			true, //2
			true,
			
			true,
			true,
			
			true, //4
			true,
			
			true, //5
			true,
			true,
			
			true, //6
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
			false,
			
			false, //9
			false,
			false,
			false,
			
	};
	
	protected String [] generateFunctionCalls(String functionName) {
		setInputNewLine(8);
		String [] retVal = new String[inputList.length+2];
		retVal[0] = getReadabilityCommand();
		for(int i=0;i<inputList.length;i++) 
			retVal[i+1]="(funcall "+functionName+" "+inputList[i][0]+" "+inputList[i][1]+" "+inputList[i][2]+")";
		retVal[retVal.length-1] = "(exit)";
		return retVal;
	}
	
	protected String [] stringToRegex(String [] list) {
		String [] retVal =new String[list.length];
		for(int i=0;i<list.length;i++)
			retVal[i]=".*"+list[i]+".*";
		return retVal;
	}
	
}
