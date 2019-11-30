package gradingTools.comp524f19.assignment4.distributed.collaborative;

import java.util.Arrays;

import grader.basics.config.BasicExecutionSpecificationSelector;
import gradingTools.comp524f19.assignment4.distributed.basic.DistributedBasicClientInput;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@IsExtra(true)
@MaxValue(40)
public class DistributedCollaborativeClient2Input extends DistributedBasicClientInput{
	public static final String CLIENT_2 = CLIENT + " 2";
	protected void setupProcessTeam() {
		
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setProcessTeams(Arrays.asList(PROCESS_TEAM));
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setTerminatingProcesses(PROCESS_TEAM, 
				Arrays.asList(SERVER));
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setProcesses(PROCESS_TEAM, 
				Arrays.asList(SERVER, CLIENT_1, CLIENT_2));
		
	}
	@Override
	protected  void setupClients() {
		setupClient(CLIENT_1, classRegistry.getClientMain().getName());
		setupClient(CLIENT_2, classRegistry.getClientMain().getName());
//		initialProcessInputs.put(CLIENT_2, FIRST_PROCESS_INPUT + END_INPUT);
	}
	protected void setupInitialInputs() {
		initialProcessInputs.put(CLIENT_2, FIRST_PROCESS_INPUT + END_INPUT);

	}
	protected void checkBroadcast(String anOutput) {
		super.checkBroadcast(anOutput);		
		if (!output.contains(CLIENT_2 +":"+anOutput)) {
			assertTrue(CLIENT_2 + " does not have output:" + anOutput, false);

		}
	}
	
}
