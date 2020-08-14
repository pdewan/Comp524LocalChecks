package gradingTools.comp524f20.assignment0_1.testcases.socialDistance;

import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class ADistanceDurationChecker extends ASubstringSequenceChecker{
	//make sure receives from both clients take place, need to ensure alternatibg, cannot with regular expressions
	public static final String[] INPUT = {
			"15.0", "6.0", "1.0", "1.0", "0",
			"14.0", "6.0", "1.0", "1.0", "0",
			"16.0", "6.0", "1.0", "1.0", "0",
			
			"15.0", "5.0", "1.0", "1.0", "0",
			"15.0", "7.0", "1.0", "1.0", "0",
			
			"15.0", "12.0", "0.5", "1.0", "0",			
			"15.0", "13.0", "0.5", "1.0", "0",
			"15.0", "14.0", "0.5", "1.0", "0",

			
			"15.0", "12.0", "1.0", "0.5", "0",
			"15.0", "13.0", "1.0", "0.5",  "0",
			"15.0", "14.0", "1.0", "0.5",  "0",
			
			"15.0", "24.0",  "0.5", "0.5", "0",
			"15.0", "23.0",  "0.5", "0.5", "0",
			"15.0", "25.0",  "0.5", "0.5", "0",
			
			"15.0", "52.0",  "0.5", "0.5", "1",
			"15.0", "51.0",  "0.5", "0.5", "1",
			"15.0", "53.0",  "0.5", "0.5", "1",
			
			"15.0", "108.0",  "0.5", "0.5", "1",
			"15.0", "107.0",  "0.5", "0.5", "1",
			"15.0", "109.0",  "0.5", "0.5", "1",
			
			



			"-5.0"

			
	};
	public  final String[] MY_SUBSTRINGS = {
			
			

		
	};
	public ADistanceDurationChecker() {
		init( MY_SUBSTRINGS);
	}
	

}
