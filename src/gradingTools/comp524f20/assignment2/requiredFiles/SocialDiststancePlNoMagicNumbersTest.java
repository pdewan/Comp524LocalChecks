package gradingTools.comp524f20.assignment2.requiredFiles;

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
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(40)
@IsExtra(true)
public class SocialDiststancePlNoMagicNumbersTest extends PassFailJUnitTestCase {
	
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
//			    var input = CharStreams.fromFileName(filePath);
//			    var lexer = new PrologLexer(input);
//			    var tokens = new CommonTokenStream(lexer);
//			    var parser = new PrologParser(tokens);
//			    var tree = parser.p_text();
//
//			    var collector = new RelationCollectorListener(tokens, parser);
//			    ParseTreeWalker.DEFAULT.walk(collector, tree);
//			    var program = collector.program();
			 
			 
			 CharStream input = new ANTLRFileStream(filePath);
//			 CharStream input = CharStreams.fromFileName(filePath);
			 PrologLexer lexer = new PrologLexer(input);
			 CommonTokenStream tokens = new CommonTokenStream(lexer);
			 PrologParser parser = new PrologParser(tokens);
			 P_textContext tree = parser.p_text();

			 RelationCollectorListener collector = new RelationCollectorListener(tokens, lexer, parser);
			 ParseTreeWalker.DEFAULT.walk(collector, tree);
			 Program program = collector.program();
			 
			 boolean magicNumbers = program.noMagicNumbers();
			 
			 if(magicNumbers)
				 return pass();
			 else
				 return fail("magic numbers found");
		 } 		 catch (Exception e) {
			 return fail (e.getMessage());
		 } catch (Throwable e) {
			 	return fail(e.getMessage());
		}
	}

}
