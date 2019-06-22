package gradingTools.comp524f19.assignment1;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicStaticConfigurationUtils;
import grader.basics.junit.BasicJUnitUtils;
import grader.basics.project.BasicProjectIntrospection;
import gradingTools.comp524f19.assignment1.testcases.CustomCommandIncrementalPromptTestCase;
import gradingTools.comp524f19.assignment1.testcases.CustomCommandPromptTestCase;
import gradingTools.comp524f19.assignment1.testcases.IncrementalInputPromptTestCase;
import gradingTools.comp524f19.assignment1.testcases.PledgeTestCase;
import gradingTools.comp524f19.assignment1.testcases.PromptTestCase;
import gradingTools.comp524f19.assignment1.testcases.ProperHeaderTestCase;
import util.tags.DistributedTags;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	PromptTestCase.class,
	IncrementalInputPromptTestCase.class,
	CustomCommandPromptTestCase.class,
	CustomCommandIncrementalPromptTestCase.class,
	PledgeTestCase.class
})
	

	
public class Assignment1Suite {

	public static void main (String[] args) {
		try {
//			setProcessTimeOut(25);
//			BasicStaticConfigurationUtils.setUseProjectConfiguration(true);
//			BasicStaticConfigurationUtils.setModule("Comp524");
//			BasicStaticConfigurationUtils.setProblem("Assignment1");
//			BasicStaticConfigurationUtils.setModuleProblemAndTest(Assignment1Suite.class);

			BasicJUnitUtils.interactiveTest(Assignment1Suite.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static {
		BasicProjectIntrospection.setCheckAllSpecifiedTags(true);
		BasicStaticConfigurationUtils.setUseProjectConfiguration(true);



	}
}
