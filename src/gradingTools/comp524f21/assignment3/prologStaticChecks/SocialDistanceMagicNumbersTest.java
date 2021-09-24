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

@MaxValue(20)
@IsExtra(true)
public class SocialDistanceMagicNumbersTest extends PassFailJUnitTestCase{

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException, NotGradableException {
		try {
			APrologProgramGenerator generator = (APrologProgramGenerator) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(APrologProgramGenerator.class);	
			Program program = generator.getProgram();
			if(program == null) 
				return fail("APrologProgramGenerator did not pass successfully");
			
			 boolean magicNumbers = program.noMagicNumbers();
			 
			 if(magicNumbers)
				 return pass();
			 else
				 return fail("magic numbers found");
		}catch(Exception e) {
			return fail(e.getMessage());
		}
	}
}
