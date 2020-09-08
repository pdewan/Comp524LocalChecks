package gradingTools.comp524f20.assignment1.testcases.socialDistance.mains;

import gradingTools.shared.testcases.ASubstringSequenceChecker;

public class AInterpolatingMainChecker extends ASubstringSequenceChecker{
	//make sure receives from both clients take place, need to ensure alternatibg, cannot with regular expressions
	public  final String[] MY_SUBSTRINGS = {
			"^[Pp]lease enter.*",
			"^[Dd]istance.*",
			"^[Dd]uration.*",
			"^[Ee]xhalation [Ll]evel.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=1.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=1.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=1.*",
			
			"^[Nn]ot [Ss]afe.*",
			
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=13.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=15.*",
			"^java.beans.PropertyChangeEvent.*oldValue=null; newValue=50.*",
			
			"^[Ss]afe.*", //1
			"^[Ss]afe.*",
			"^[Ss]afe.*",
			
			"^[Nn]ot [Ss]afe.*", //2
			"^[Nn]ot [Ss]afe.*",
			"^[Nn]ot [Ss]afe.*",

			"^[Qq]uitting.*"
	};
	public AInterpolatingMainChecker() {
		init( MY_SUBSTRINGS);
	}
	

}
