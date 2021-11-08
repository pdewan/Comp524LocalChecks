package gradingTools.comp524f21.assignment5.style.fileStructureTests;

import gradingTools.fileTree.Template;
import gradingTools.shared.testcases.packageStructure.AbstractFolderMatchesTemplateTest;

public class ProjectMatchesTemplate extends AbstractFolderMatchesTemplateTest {

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
	};
	
	private final Template template = new Template(rawTemplate, "Organized Evaluators");
	
	@Override
	protected Template getTemplate() {
		System.out.println(template.getTemplateFileTree());
		return template;
	}

	@Override
	protected double getAcceptabilityCutoff() {
		return 0.75;
	}

}
