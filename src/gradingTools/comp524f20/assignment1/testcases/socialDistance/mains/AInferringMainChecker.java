package gradingTools.comp524f20.assignment1.testcases.socialDistance.mains;

import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class AInferringMainChecker extends ASubstringSequenceChecker{
	//make sure receives from both clients take place, need to ensure alternatibg, cannot with regular expressions
	public  final String[] MY_SUBSTRINGS = {
			"^[Pp]lease enter.*",
			"^[Dd]istance.*",
			"^[Dd]uration.*",
			"^[Ee]xhalation [Ll]evel.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=404.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=404.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=404.*",
			
			"^[Nn]ot [Ss]afe.*",
			
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=27.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=15.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=10.*",
			
			"^[Ss]afe.*", //1
			
			"^[Qq]uitting.*"
	};
	public AInferringMainChecker() {
		init( MY_SUBSTRINGS);
	}
	

}
