package gradingTools.comp524f20.assignment2.requiredFiles;

import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import edu.unc.cs.comp524.parsers.prolog.Program;
import edu.unc.cs.comp524.parsers.prolog.PrologLexer;
import edu.unc.cs.comp524.parsers.prolog.PrologParser;
import edu.unc.cs.comp524.parsers.prolog.PrologParser.P_textContext;
import edu.unc.cs.comp524.parsers.prolog.RelationCollectorListener;
import edu.unc.cs.comp524.parsers.prolog.RuleInvocation;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f21.assignment3.prologStaticChecks.APrologProgramGenerator;
import util.annotations.MaxValue;

@MaxValue(0)
public class SocialDiststancePlNoExternalFunctionsTest extends PassFailJUnitTestCase {
	
	boolean hasPassed=false;
	public boolean hasPassed() {
		return hasPassed;
	}
	
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {	
		 
		 try {
			 Program program;
			 try {
				APrologProgramGenerator generator = (APrologProgramGenerator) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(APrologProgramGenerator.class);	
				program = generator.getProgram();
				if(program == null) 
					return fail("APrologProgramGenerator did not pass successfully");
			 }catch(Exception e) {
				 SocialDistancePlProvided aSocialDistanceFileProvided = (SocialDistancePlProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistancePlProvided.class);			
				 File aSocialDistanceFile = aSocialDistanceFileProvided.getRequiredFile();
				 if(aSocialDistanceFile==null) {
					 return fail("a social distance file not found");
				 }
				 
				 String filePath=aSocialDistanceFile.getAbsolutePath();
				
				 
				 CharStream input = new ANTLRFileStream(filePath);
				 PrologLexer lexer = new PrologLexer(input);
				 CommonTokenStream tokens = new CommonTokenStream(lexer);
				 PrologParser parser = new PrologParser(tokens);
				 P_textContext tree = parser.p_text();

				 RelationCollectorListener collector = new RelationCollectorListener(tokens, lexer, parser);
				 ParseTreeWalker.DEFAULT.walk(collector, tree);
				 program = collector.program();
			 }
				
			 Set<String> allowed = Set.of(
				        "write",
				        ";",
				        ",",
				        "is",
				        ">",
				        "<",
				        ">=",
				        "*",
				        "/",
				        "=<",
				        "-",
				        "=",
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
			 
			 
			 
		 } 		 catch (Exception e) {
			 return fail (e.getMessage());
		 } catch (Throwable e) {
			 	return fail(e.getMessage());
		}
	}

}
