package gradingTools.comp524f21.assignment3.prologStaticChecks;

import edu.unc.cs.comp524.parsers.prolog.Program;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(10)
@IsExtra(true)
public class SocialDistanceRecursiveTest extends PassFailJUnitTestCase{

	private final String [] recursiveFunctionNames = {
		"listGenerateSafeDistancesAndDurations",
		"printGivenCombinations",
		"listGivenSafe",
	};
	
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException, NotGradableException {
		try {
			APrologProgramGenerator generator = (APrologProgramGenerator) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(APrologProgramGenerator.class);	
			Program program = generator.getProgram();
			if(program == null) 
				return fail("APrologProgramGenerator did not pass successfully");
			
			int count = 0;
			for(String function:recursiveFunctionNames) 
				if(program.containsRecursive(function))
					count++;
				else
					System.out.println("The function: \""+function+"\" is expected to contain recursion");
			
			if(count == recursiveFunctionNames.length)
				 return pass();
			return partialPass(count/((double)recursiveFunctionNames.length),"See console for info");
		} catch (Exception e) {
			return fail(e.getMessage());
		}
	}
}
