package gradingTools.comp524f21.assignment3.prologStaticChecks;

import java.util.List;

import edu.unc.cs.comp524.parsers.prolog.Program;
import edu.unc.cs.comp524.parsers.prolog.Relation;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;

public abstract class AbstractSocialDistanceCommentsPrologTest extends PassFailJUnitTestCase{
	
	public abstract String [] getMethodName();
	public abstract String [] getCommentRegex();
	
	@Override
	protected boolean failedTestVetoes() {
		return false;
	}
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException, NotGradableException {
		try {
			APrologProgramGenerator generator = (APrologProgramGenerator) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(APrologProgramGenerator.class);	
			Program program = generator.getProgram();
			if(program == null) 
				return fail("APrologProgramGenerator did not pass successfully");
			
			List<Relation> list = program.relationsWithComments();
								//.stream().map(Relation::name).collect(Collectors.toList());

			int found=0;
			String [] methodNames = getMethodName();
			String [] commentRegex = getCommentRegex();
			for(int i=0;i<methodNames.length;i++) {
				for(Relation rel:list) {
//					String comment = rel.comment().get().text().replaceAll("[\n\r]", ""); 
					if(rel.name().matches(methodNames[i]) &&
						rel.comment().get().text().replaceAll("[\n\r]", "").matches(commentRegex[i])) {
						found++;
						break;
					}
				}
			}
			TestCaseResult result;
			if(found==methodNames.length)
				result=pass();
			else
				result=fail("Expected documentation was not found, check method names and documentation text");
			return scaleResult(result);
		}catch(Exception e) {
			return fail(e.getMessage());
		}
	}
}
