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
public class DistributedBasicTest extends MainMethodForkerTest {
	public DistributedBasicTest() {
//		BasicProjectExecution.setProcessTimeOut(Assignment0Suite.getProcessTimeOut());
	}
	public static final String PROCESS_TEAM = "Lisp Interpreter Team";
	public static final String SERVER = "Lisp Interpreter Server";
	public static final String CLIENT = "Lisp Interpreter Client";

	public static final String CLIENT_1 = CLIENT + " 1";
	public static final String CLIENT_2 = CLIENT + " 2";
	public static final List<String> CLIENT_ARGS = Arrays.asList(new String[] {"localhost", "9100"});
	public static final List<String> SERVER_ARGS = Arrays.asList(new String[] {"9100"});
	public static final String CLIENT_INPUT = "(+ 1 2)\n (- 2 1)\n(quit)";
	public static final String[] OUTPUTS = {"3", "1"};
	public static final Map<String, String> processInputs = new HashMap(); 

	 ClassRegistryA4 classRegistry;
//	public static void setupProcesses(String aServerClassName, String aClientClassName, boolean isTwoClients) {
//		BasicRunningProject.setProcessTeamOutputSleepTime(15000);
//
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setGraderWaitForResort(false);
//		BasicStaticConfigurationUtils.setBasicCommandToDefaultEntryPointCommand();
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setProcessTeams(Arrays.asList(PROCESS_TEAM));
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setTerminatingProcesses(PROCESS_TEAM, 
//				Arrays.asList(SERVER));
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setProcesses(PROCESS_TEAM, 
//				Arrays.asList(SERVER, CLIENT_1, CLIENT_2));
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setEntryPoint(
//				SERVER , aServerClassName);
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setEntryPoint(
//				CLIENT_1 , aClientClassName);
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setEntryPoint(
//				CLIENT_2 , aClientClassName);
////		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setEntryTags(
////				CLIENT_1_NAME, Arrays.asList(client1TaggedTestCase.getTags()));
////		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setEntryTags(
////				CLIENT_2_NAME, Arrays.asList(client2TaggedTestCase.getTags()));
////		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setSleepTime(SERVER_NAME, 5000);
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
//			setGraderResourceReleaseTime(CLIENT_1, 7000);
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
//			setGraderResourceReleaseTime(CLIENT_2, 7000);
////		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().getProcessTeams().forEach(team -> System.out.println("### " + team));
//	}
	public void setupProcesses() {
		setDefaults();
		setupServer();
		setupClients();
		setupProcessTeam();
//		resetDefaults();
	}
	public void setupProcessTeam() {
		
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setProcessTeams(Arrays.asList(PROCESS_TEAM));
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setTerminatingProcesses(PROCESS_TEAM, 
				Arrays.asList(SERVER));
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setProcesses(PROCESS_TEAM, 
				Arrays.asList(SERVER, CLIENT));
		
	}
	public static void setDefaults() {
		BasicRunningProject.setProcessTeamOutputSleepTime(15000);

		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setGraderWaitForResort(false);
		BasicStaticConfigurationUtils.setBasicCommandToDefaultEntryPointCommand();
	}
	public  void resetDefaults() {
		BasicStaticConfigurationUtils.setBasicCommandToDefaultEntryTagCommand();
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().resetProcessTeams();

	}
	public  void setupProcess(String aProcessName, String aProcessClass) {
	
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setEntryPoint(
				aProcessName , aProcessClass);		
	}
	public  void setupServer() {
		Class aServerMain = classRegistry.getServerMain();
		setupServer(SERVER, aServerMain.getName());
	}
	public  void setupClients() {
		setupClient(CLIENT, classRegistry.getClientMain().getName());
		processInputs.put(CLIENT, CLIENT_INPUT);
	}
	public  void setupServer(String aServerName, String aServerClassName) {
		setupProcess(aServerName, aServerClassName);
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setTerminatingProcesses(PROCESS_TEAM, 
				Arrays.asList(aServerName));
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
		setArgs(aServerName, SERVER_ARGS);
		processInputs.put(SERVER, "");

		
	}
	public  void setupClient(String aClientName, String aClientClassName) {
		setupProcess(aClientName, aClientClassName);
	
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
			setGraderResourceReleaseTime(aClientName, 7000);
		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
		setArgs(aClientName, CLIENT_ARGS);
		
	}
//	protected String processName() {
//		return MAP_REDUCE_SERVER;
//	}
	protected String processName() {
		return SERVER;
	}
	@Override
	protected void callOrForkMain(boolean aFork) throws Throwable {
		BasicRunningProject.setProcessTeamOutputSleepTime(10000);
		ClassRegistryA4Provided aConfigurationProvided = (ClassRegistryA4Provided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(ClassRegistryA4Provided.class);

//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setWaitForResort(false);
//		BasicStaticConfigurationUtils.setBasicCommandToDefaultEntryPointCommand();
		classRegistry = aConfigurationProvided.getTimingOutClassRegistryProxy();
		setupProcesses();
//		setupProcesses(	classRegistry.getServerMain().getName(),
//				classRegistry.getClientMain().getName());


//		BasicStaticConfigurationUtils.setBasicCommandToDefaultEntryPointCommand();
//		BasicStaticConfigurationUtils.setBasicCommandToDefaultEntryPointCommand();


		interactiveInputProject = RunningProjectUtils.
				
				runProject(project, 
				Assignment4Suite.getProcessTimeOut(),
				new BasicInputGenerator(null),
				processInputs);
		interactiveInputProject.await();
		resetDefaults();


	}
	protected boolean isValidOutput() {
		for (String anOutput:OUTPUTS) {
			if (!output.contains(SERVER +":"+anOutput)) {
				assertTrue(SERVER + " does not have output:" + anOutput, false);
			}
			if (!output.contains(CLIENT +":"+anOutput)) {
				assertTrue(CLIENT + " does not havve output:" + anOutput, false);

			}

			
		}
		return true;
	}
//	//need to put in superclass
//	protected void callOrForkInteractiveMain(boolean aFork) throws Throwable {
//		ConfigurationProvided aConfigurationProvided = (ConfigurationProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(ConfigurationProvided.class);
//
//		BasicStaticConfigurationUtils.setBasicCommandToDefaultEntryPointCommand();
//		testMapReduceConfiguration = aConfigurationProvided.getTestConfiguration();
//		setupProcesses();
//		Map<String, String> aProcessToInput = new HashMap<>();
//		interactiveInputProject = RunningProjectUtils.runProject(project, 
//				Assignment0Suite.getProcessTimeOut(), new MapReduceInputGenerator(3, getInputLines()));
//		error = interactiveInputProject.getErrorOutput();
//		output = interactiveInputProject.getOutput();
//		resultingOutError = new ResultingOutErr(output, error);
////		interactiveInputProject = resultingOutError.getRunningProject();		
//		BasicStaticConfigurationUtils.setBasicCommandToDefaultCommand();
//
//
//	}
	
//	protected Class mainClass;
//
//	
//	protected String mainClassName;
//	protected String[] emptyStringArgs = {};
//    
//    public String getMainClassName() {
//    	if (mainClassName == null) {
//    		mainClassName = mainClassName();
//    	}
//		return mainClassName;
//	}
//	public void setMainClassName(String mainClassName) {
//		this.mainClassName = mainClassName;
//	}
//	protected Class mainClass() {
//    	return null;
//    }
//    protected Class getMainClass() {
//    	if (mainClass == null) {
//    		mainClass = mainClass();
//    	}
//		return mainClass;
//	}
//	public void setMainClass(Class mainClass) {
//		this.mainClass = mainClass;
//	}
//	protected String mainClassName() {
//    	return getMainClass().getName();
//    }	
//	protected void setMainClass() {
//		ConfigurationProvided aConfigurationProvided = (ConfigurationProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(ConfigurationProvided.class);
//		mainClass = aConfigurationProvided.getTestConfiguration().getStandAloneTokenCounter();
//	}
//	protected String[] getInputLines() {
//		return  new String[]{"3", "a an the a an the a a a an an an the the the"};
//	}
//	@Override
//	public String[] getStudentArgs() {
//		return new String[]{"3", "a an the a an the a a a an an an the the the"};
//	}
	
	
//	protected boolean forkMain() {
//		return true;
//	}
	
//	protected void callOrForkMain(boolean aFork) throws Throwable {
//		
//		resultingOutError = BasicProjectExecution.callOrForkMain(
//			true, getMainClassName(), emptyStringArgs, "3", "a an the a an the a a a an an an the the the");
//		error = resultingOutError.getErr();
//		output = resultingOutError.getOut();
//		interactiveInputProject = resultingOutError.getRunningProject();
//		
//
//	}
//	protected SubstringSequenceChecker checker() {
//		return new AStandAloneBasicTokenCounterResultChecker();
//	}
//	@Override
//	protected boolean isValidOutput() {
//		return checkWithChecker();
//	}

	@Override 
	public String[] getInputLines() {
		return new String[] {
				"(+ 2 3)", 
				"(quit)"
		};
	}


	public void defaultTest() {
    	passfailDefaultTest();
    }

}
