package gradingTools.comp524f20.assignment6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LispLambdaChecker;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LispLambdaChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LispLambdaChecker3;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LoadLambdaChecker;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LoadLambdaChecker2;
import gradingTools.comp524f19.assignment2.testcases.LispLambdaCheckers.LoadLambdaChecker3;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	LispLambdaChecker.class,
	LispLambdaChecker2.class,
	LispLambdaChecker3.class,
	LoadLambdaChecker.class,
	LoadLambdaChecker2.class,
	LoadLambdaChecker3.class
	
	
})
	

public class LispLambdaSuite {
	
}
