package gradingTools.comp524f20.assignment3;

public class CorrectValues {

	public static boolean[] getInterpolatedRegexChecks() {
		return INTERPOLATED_VALUES;
	}
	
	private final static boolean[] INTERPOLATED_VALUES = {
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
	
	public static boolean[] getGivenSafeRegexChecks() {
		return GIVENSAFE_VALUES;
	}
	
	private final static boolean[] GIVENSAFE_VALUES= {
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

	public static boolean[] getDerivedSafeRegexChecks() {
		return DERIVEDSAFE_VALUES;
	}
	
	private final static boolean[] DERIVEDSAFE_VALUES= {
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

}
