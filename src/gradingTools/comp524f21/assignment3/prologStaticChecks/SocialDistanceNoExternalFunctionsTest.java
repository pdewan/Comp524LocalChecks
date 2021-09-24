package gradingTools.comp524f21.assignment3.prologStaticChecks;

import java.util.Set;
import java.util.stream.Collectors;

import edu.unc.cs.comp524.parsers.prolog.Program;
import edu.unc.cs.comp524.parsers.prolog.RuleInvocation;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f20.assignment2.requiredFiles.SocialDiststancePlNoExternalFunctionsTest;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(0)
public class SocialDistanceNoExternalFunctionsTest extends SocialDiststancePlNoExternalFunctionsTest{
	boolean hasPassed=false;
	@Override
	public boolean hasPassed() {
		return hasPassed;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException, NotGradableException {
		try {
			APrologProgramGenerator generator = (APrologProgramGenerator) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(APrologProgramGenerator.class);	
			Program program = generator.getProgram();
			if(program == null) 
				return fail("APrologProgramGenerator did not pass successfully");
			
			Set<String> allowed = Set.of(
			        "write",
			        ";",
			        ",",
			        "is",
			        ">",
			        "<",
			        ">=",
			        "=<",
			        "-",
			        "=",
			        "*",
			        "/",
			        "\\=",
			        "not",
			        "\\+",
			        "|"
			        );
			boolean noExternalFunctions=allowed.containsAll(
		          program.undefined().stream()
		          .map(RuleInvocation::name)
		          .collect(Collectors.toSet()));
		 
			if(noExternalFunctions) {
				this.hasPassed=true;
				return pass();
			}
		 
			System.out.println("Found external function(s):");
			program.undefined().stream().map(RuleInvocation::name).filter(n -> !allowed.contains(n)).forEach(System.out::println);
		 
			return fail("external functions found (see console)");
		}catch(Exception e) {
			return fail(e.getMessage());
		}
	}
}
