package gradingTools.comp524f19.assignment4.distributed.collaborative;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.execution.BasicRunningProject;
import grader.basics.execution.ThreeProcessInputGenerator;
import grader.basics.junit.JUnitTestsEnvironment;
import gradingTools.comp524f19.assignment4.Assignment4Suite;
import gradingTools.comp524f19.assignment4.requiredClasses.ClassRegistryA4Provided;
import gradingTools.shared.testcases.MainMethodForkerTest;
import gradingTools.utils.RunningProjectUtils;
import main.ClassRegistryA4;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
import util.pipe.InputGenerator;
@IsExtra(true)
@MaxValue(20)
public class DistributedCollaborativeClient2ServerAndClient1Input extends DistributedCollaborativeClient2AndServerInput {
	public static final String[] THIRD_PROCESS_INPUT = {
									"(+ 3 4)", 
									"(- 5 1)"
									};

	public static final String[] THIRD_PROCESS_OUTPUTS = {
									"7", 
									"4"
									};
	public static final String THIRD_PROCESS_LAST_OUTPUT = THIRD_PROCESS_OUTPUTS[SECOND_PROCESS_OUTPUTS.length - 1];
	
	
	protected InputGenerator createInputGenerator() {
		
		return new ThreeProcessInputGenerator(CLIENT_2, FIRST_PROCESS_LAST_OUTPUT, SERVER, 
				SECOND_PROCESS_INPUT, SECOND_PROCESS_LAST_OUTPUT, 
				CLIENT_1,
				ThreeProcessInputGenerator.append(THIRD_PROCESS_INPUT, END_INPUT));
	}

//	protected void setupInitialInputs() {
//		initialProcessInputs.put(CLIENT_2, FIRST_PROCESS_INPUT ); // no quit
//
//	}
	protected boolean isValidOutput() {
		if (!super.isValidOutput()) {
			return false;
		}
		for (String anOutput:THIRD_PROCESS_OUTPUTS) {
			checkBroadcast(anOutput);
			
		}
		return true;
	}
}
