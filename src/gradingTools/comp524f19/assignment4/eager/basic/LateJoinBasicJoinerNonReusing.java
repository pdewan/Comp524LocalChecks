package gradingTools.comp524f19.assignment4.eager.basic;

import util.annotations.MaxValue;
@MaxValue(20)
public class LateJoinBasicJoinerNonReusing extends EarlyJoinBasicJoiner {
	
	

	protected void setTimeouts() {
		slaveTimeout = 0;
		masterTimeout = 300;
	}
	
	

}
