package gradingTools.comp524f19.assignment4.eager.pool;

import util.annotations.MaxValue;

@MaxValue(5)
public class LateJoinMutableJoinerNonReusing extends EarlyJoinMutableJoinerNonReusing {
	protected void setTimeouts() {
		slaveTimeout = 0;
		masterTimeout = 300;
	}
}
