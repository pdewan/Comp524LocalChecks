package gradingTools.comp524f20.assignment3.styleParsing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import grader.basics.BasicLanguageDependencyManager;
import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.execution.GradingMode;
import grader.basics.execution.NotRunnableException;
import grader.basics.execution.RunningProject;
import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.comp524f20.assignment3.AnAbstractSMLRunningProject;
import gradingTools.comp524f20.assignment3.requiredFiles.SocialDistanceSMLProvided;

import gradingTools.utils.RunningProjectUtils;
import util.annotations.IsExtra;
import util.annotations.MaxValue;
@MaxValue(10)
@IsExtra(true)
public class StyleTest extends AnAbstractSMLRunningProject {
	public static final int TIME_OUT_SECS = 1; // secs	

	public StyleTest() {
	}
	
//	private final String [] inputs = {
//			"CM.make \"../config/smlnj-parser-style/524-f20-a3.cm\";",
//			getReadabilityCommand(),
//			"A3Grader.runall \"SocialDistance.sml\";",
//	};
	
	
//	 getReadabilityCommand(),
//	 "OS.FileSys.getDir();", 
//	 "OS.Process.exit(OS.Process.success);"
	
	private final String [] results= {
			"no disallowed functions: pass",
			"matching derived safe calls matching safe with matcher: pass",
			"matching given safe calls matching safe with matcher: pass",
			"curryable interpolated safe calls interpolated safe: pass",
			"curried once interpolated safe calls curryable interpolated safe: pass",
			"curried twice interpolated safe calls curried once interpolated safe: pass",
			"curried matching given safe calls curryable matching safe with given safe matcher: pass",
			"curried matching derived safe calls curryable matching safe with derived safe matcher: pass",
			"no magic numbers in functions: pass",
	};
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		try {
			SocialDistanceSMLProvided aSocialDistanceFileProvided = (SocialDistanceSMLProvided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(SocialDistanceSMLProvided.class);			
			if (aSocialDistanceFileProvided.getRequiredFile() == null) 
				return fail ("A Social Distance File not Found");
			
			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.SML_LANGUAGE);

//			GradingMode.getGraderRun();
//			File test = Paths.get(StyleTest.class.getResource("smlnj-parser/524-f20-a3.cm").toURI()).toFile();

//			File test = new File("config/524-f20-a3.cm");
//			String unixifiedPath = test.getAbsolutePath().replaceFirst(".*Users\\\\", "/Users/").replaceAll("\\\\", "/");
//			
//			String [] paths= {
//					test.getAbsolutePath(),
//					test.getCanonicalPath(),
//					test.getPath()
//			};
			
//			String [] inputs = {
//					"CM.make \""+ test.getCanonicalPath().replaceAll("\\\\", "\\\\\\\\").replaceFirst("C:","") +"\";",
//	//				"CM.make \"C:"+ unixifiedPath +"\";",
//					getReadabilityCommand(),
//					"A3Grader.runall \"SocialDistance.sml\";",
//			};
			
//			RunningProject aRunningProject = RunningProjectUtils.runProject(project, TIME_OUT_SECS, inputs);
			
			String [] inputs = {
					"CM.make \"config/smlnj-parser-style/524-f20-a3.cm\";",
					getReadabilityCommand(),
					"A3Grader.runall \""+ aSocialDistanceFileProvided.getRequiredFile().getAbsolutePath().replaceAll("\\\\", "\\\\\\\\")+"\";",
					"OS.Process.exit(OS.Process.success);"
			};
			
			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setForkInProjectFolder(false);
//			RunningProject aRunningProject = RunningProjectUtils.runProjectandWithMainFile (project, "SocialDistance.sml",  TIME_OUT_SECS, inputs);
			RunningProject aRunningProject = RunningProjectUtils.runProject(project, TIME_OUT_SECS, inputs);
			
			if (aRunningProject == null) 
				return fail ("Could not create project. See console messages.");
			

			aRunningProject.await();
			String output = aRunningProject.getOutput();
			if (output == null || output.length()==0) 
				return fail ("Could not generate output. See console messages.");
			
			double aRetval = regexOutputCheckPassPercent(parseToReadable(output.split("\n")),results);
			
			if (aRetval!=1) 
				return partialPass(aRetval,"View console for more detail");
			return pass();
		

		} catch (NotRunnableException e) {
			throw new NotGradableException();
		}
	}
	
	private double regexOutputCheckPassPercent(String [] outputLines, String [] regexList) {
		List<String> eachTest = new ArrayList<String>();
		Collections.addAll(eachTest, regexList);
		for(String line:outputLines) 
			for(int i=0;i<eachTest.size();i++) 
				if(line.matches(eachTest.get(i))) {
					eachTest.remove(i);
					if(eachTest.size()==0)
						return 1;
					break;
				}
		
		System.err.println("The following tests were not passed:");
		for(String failedTest:eachTest) 
			System.err.println(failedTest);
		return ((double)regexList.length-eachTest.size())/regexList.length;
	}
}
