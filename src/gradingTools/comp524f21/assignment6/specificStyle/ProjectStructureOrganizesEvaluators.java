package gradingTools.comp524f21.assignment6.specificStyle;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import gradingTools.fileTree.Template;
import gradingTools.shared.testcases.packageStructure.AbstractFolderMatchesTemplateTest;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(7)
@IsExtra(true)
public class ProjectStructureOrganizesEvaluators extends AbstractFolderMatchesTemplateTest {

	private final String [] rawTemplate= {
		"|- .*",
		" |- [a-z]?.*[Ll]ogical.*",
		"  |~ AndEval.*.java",
		"  |~ OrEval.*.java",
		"  |~ NotEval.*.java",
		" |- [a-z]?.*[Rr]elational.*",
		"  |~ G.*T.*Eval.*.java",
		"  |~ L.*T.*Eval.*.java",
		"  |~ G.*T.*E.*Eval.*.java",
		"  |~ L.*T.*E.*Eval.*.java",
		" |- [a-z]?.*[Ee]xpression.*",
		"  |~ QuoteEval.*.java",
		"  |~ EvalEval.*.java",
		"  |~ CondEval.*.java",
		"  |~ LoadEval.*.java",
		"  |~ ListEval.*.java",
		" |- [a-z]?.*[Ff]unctional.*",
		"  |~ FuncallEval.*.java",
		"  |~ LambdaEval.*.java",
		"  |~ SetqEval.*.java",
	};
	
	private final Template template = new Template(rawTemplate, "Organized Evaluators");
	
	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException, NotGradableException {
		TestCaseResult retval = super.test(project, autoGrade);
		if(!retval.isPass()) {
			System.out.println("Expected format:");
			System.out.println(template.getTemplateFileTree());
		}
		return retval;
	}
	
	@Override
	protected Template getTemplate() {
		return template;
	}

	@Override
	protected double getAcceptabilityCutoff() {
		return 0.95;
	}

}
