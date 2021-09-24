package gradingTools.comp524f21.assignment3.prologStaticChecks;

import java.io.File;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import edu.unc.cs.comp524.parsers.prolog.Program;
import edu.unc.cs.comp524.parsers.prolog.PrologLexer;
import edu.unc.cs.comp524.parsers.prolog.PrologParser;
import edu.unc.cs.comp524.parsers.prolog.PrologParser.P_textContext;
import edu.unc.cs.comp524.parsers.prolog.RelationCollectorListener;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import gradingTools.comp524f20.assignment2.requiredFiles.SocialDistancePlProvided;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(0)
@IsExtra(true)
public class APrologProgramGenerator extends PassFailJUnitTestCase {

	private Program prog;
	public Program getProgram() {
		return prog;
	}
	
	
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {	
		 
		 try {
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
			 prog = collector.program();
			 
			 return pass();
			 
		 }catch (Exception e) {
			 return fail (e.getMessage());
		 } catch (Throwable e) {
			 return fail(e.getMessage());
		}
	}
	
}
