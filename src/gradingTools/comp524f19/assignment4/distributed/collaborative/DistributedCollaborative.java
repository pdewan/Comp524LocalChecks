package gradingTools.comp524f19.assignment4.distributed.collaborative;

import java.util.Arrays;

import grader.basics.config.BasicExecutionSpecificationSelector;
import gradingTools.comp524f19.assignment4.distributed.basic.DistributedBasicClientInput;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@IsExtra(true)
@MaxValue(50)
public class DistributedCollaborative extends DistributedBasicClientInput{
	public static final String CLIENT_1 = CLIENT + " 1";
	public static final String CLIENT_2 = CLIENT + " 2";
	public void setupProcessTeam() {
		
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setProcessTeams(Arrays.asList(PROCESS_TEAM));
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setTerminatingProcesses(PROCESS_TEAM, 
				Arrays.asList(SERVER));
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setProcesses(PROCESS_TEAM, 
				Arrays.asList(SERVER, CLIENT_1, CLIENT_2));
		
	}
	
	public  void setupClients() {
		setupClient(CLIENT_1, classRegistry.getClientMain().getName());
		setupClient(CLIENT_2, classRegistry.getClientMain().getName());
		processInputs.put(CLIENT_2, CLIENT_INPUT);
	}
	protected boolean isValidOutput() {
		for (String anOutput:OUTPUTS) {
			if (!output.contains(SERVER +":"+anOutput)) {
				assertTrue(SERVER + " does not have output:" + anOutput, false);
			}
			if (!output.contains(CLIENT_1 +":"+anOutput)) {
				assertTrue(CLIENT_1 + " does not have output:" + anOutput, false);

			}
			if (!output.contains(CLIENT_2 +":"+anOutput)) {
				assertTrue(CLIENT_2 + " does not have output:" + anOutput, false);

			}			
		}
		return true;
	}

}
