package gradingTools.comp524f19.assignment4.distributed.collaborative;

import grader.basics.execution.ThreeProcessInputGenerator;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
import util.pipe.InputGenerator;
@IsExtra(true)
@MaxValue(30)
public class DistributedCollaborativeClient2AndServerInput extends DistributedCollaborativeClient2Input {
	public static final String[] SECOND_PROCESS_INPUT = {
									"(+ 2 3)", 
									"(- 3 1)"
									};

	public static final String[] SECOND_PROCESS_OUTPUTS = {
									"5", 
									"2"
									};
	public static final String SECOND_PROCESS_LAST_OUTPUT = SECOND_PROCESS_OUTPUTS[SECOND_PROCESS_OUTPUTS.length - 1];
	
	
	protected InputGenerator createInputGenerator() {
		
		return new ThreeProcessInputGenerator(CLIENT_2, FIRST_PROCESS_LAST_OUTPUT, SERVER, 
				ThreeProcessInputGenerator.append(SECOND_PROCESS_INPUT, END_INPUT));
	}

	protected void setupInitialInputs() {
		initialProcessInputs.put(CLIENT_2, FIRST_PROCESS_INPUT ); // no quit

	}
	protected boolean isValidOutput() {
		if (!super.isValidOutput()) {
			return false;
		}
		for (String anOutput:SECOND_PROCESS_OUTPUTS) {
			checkBroadcast(anOutput);
			
		}
		return true;
	}
}
