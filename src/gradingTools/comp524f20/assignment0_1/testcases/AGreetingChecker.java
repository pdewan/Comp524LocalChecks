package gradingTools.comp524f20.assignment0_1.testcases;

import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class AGreetingChecker extends ASubstringSequenceChecker{
	//make sure receives from both clients take place, need to ensure alternatibg, cannot with regular expressions
	public  final String[] MY_SUBSTRINGS = {
			toRegex("ello"),
			toRegex("oodbye"),
			

		
	};
	public AGreetingChecker() {
		init( MY_SUBSTRINGS);
	}
	

}
