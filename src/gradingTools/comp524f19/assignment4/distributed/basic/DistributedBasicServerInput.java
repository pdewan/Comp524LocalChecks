package gradingTools.comp524f19.assignment4.distributed.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.execution.BasicRunningProject;
import grader.basics.junit.JUnitTestsEnvironment;
import gradingTools.comp524f19.assignment4.Assignment4Suite;
import gradingTools.comp524f19.assignment4.requiredClasses.ClassRegistryA4Provided;
import gradingTools.shared.testcases.MainMethodForkerTest;
import gradingTools.utils.RunningProjectUtils;
import main.ClassRegistryA4;
import util.annotations.MaxValue;
@MaxValue(40)
public class DistributedBasicServerInput extends DistributedBasicClientInput {
	public  void setupServer() {
		super.setupServer();
		processInputs.put(SERVER, CLIENT_INPUT);

	}
	public  void setupClients() {
		setupClient(CLIENT, classRegistry.getClientMain().getName());
//		processInputs.put(CLIENT, CLIENT_INPUT);
	}

}
