package gradingTools.comp524f19.assignment4.eager.pool;

import util.annotations.MaxValue;

@MaxValue(5)
public class LateJoinMutableJoiner extends EarlyJoinMutableJoiner {
	protected void setTimeouts() {
		slaveTimeout = 0;
		masterTimeout = 300;
	}
}
