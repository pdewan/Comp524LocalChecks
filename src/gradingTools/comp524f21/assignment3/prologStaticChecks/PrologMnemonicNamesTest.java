package gradingTools.comp524f21.assignment3.prologStaticChecks;

import java.util.ArrayList;
import java.util.List;

import edu.unc.cs.comp524.parsers.prolog.Program;
import edu.unc.cs.comp524.parsers.prolog.Relation;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import unc.checks.ComprehensiveVisitCheck;
import unc.checks.NameComponentMetrics;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(15)
@IsExtra(true)
public class PrologMnemonicNamesTest extends PassFailJUnitTestCase{

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException, NotGradableException {
		try {
			APrologProgramGenerator generator = (APrologProgramGenerator) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(APrologProgramGenerator.class);	
			Program program = generator.getProgram();
			if(program == null) 
				return fail("APrologProgramGenerator did not pass successfully");
			
			
			List<String> names = program.names();
								//.stream().map(Relation::name).collect(Collectors.toList());

			int count=0;
			for(String name:names) {
				if(name==null)
					continue;
				String [] subNames = ComprehensiveVisitCheck.splitCamelCaseHyphenDash(name);
				int subCount=0;
				for(String subName:subNames) {
					NameComponentMetrics matric = NameComponentMetrics.computeComponentMetrics(subName);
					if((matric.isDictionaryWord==null&&matric.numChars==matric.numDigits) || matric.isDictionaryWord) {
						subCount++;
					}else {
						System.err.println(subName+" was not found in the dictionary");
					}
				}
				if(subCount==subNames.length) {
					count++;
				}
			}
			
			if(count==names.size())
				return pass();
			
			return fail("Expected documentation was not found, check method names and documentation text");
		}catch(Exception e) {
			return fail(e.getMessage());
		}
	}
		

}
