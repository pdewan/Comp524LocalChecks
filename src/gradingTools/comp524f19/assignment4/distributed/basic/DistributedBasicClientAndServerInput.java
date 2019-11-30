package gradingTools.comp524f19.assignment4.distributed.basic;

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
import util.annotations.MaxValue;
import util.pipe.InputGenerator;
@MaxValue(40)
public class DistributedBasicClientAndServerInput extends DistributedBasicClientInput {
	public static final String[] SECOND_PROCESS_INPUT = {
									"(+ 2 3)", 
									"(- 3 1)"
									};

	public static final String[] SECOND_PROCESS_OUTPUTS = {
									"5", 
									"2"
									};
	public static final String SECOND_PROCESS_LAST_OUTPUT = SECOND_PROCESS_OUTPUTS[SECOND_PROCESS_OUTPUTS.length - 1];
	
//	public static String[] append(String[] anOriginalArray, String aLastItem) {
//		String[] result = new String[ anOriginalArray.length + 1];
//		for (int i = 0; i < anOriginalArray.length; i++) {
//			result[i] = anOriginalArray[i];
//		}
//		result[anOriginalArray.length] = aLastItem;
//		return result;
//	}
	protected InputGenerator createInputGenerator() {
		
		return new ThreeProcessInputGenerator(CLIENT_1, FIRST_PROCESS_LAST_OUTPUT, SERVER, 
				ThreeProcessInputGenerator.append(SECOND_PROCESS_INPUT, END_INPUT));
	}
	
	@Override
	protected  void setupInitialInputs() {
//		setupClient(CLIENT_1, classRegistry.getClientMain().getName());
		initialProcessInputs.put(CLIENT_1, FIRST_PROCESS_INPUT); // no quit
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
