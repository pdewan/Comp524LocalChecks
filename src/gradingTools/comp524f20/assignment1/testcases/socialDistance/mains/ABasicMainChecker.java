package gradingTools.comp524f20.assignment1.testcases.socialDistance.mains;

import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class ABasicMainChecker extends ASubstringSequenceChecker{
	//make sure receives from both clients take place, need to ensure alternatibg, cannot with regular expressions
	public  final String[] MY_SUBSTRINGS = {
			"^[Ss]afe.*",
			"^[Nn]ot [Ss]afe.*",
			
			

		
	};
	public ABasicMainChecker() {
		init( MY_SUBSTRINGS);
	}
	

}
