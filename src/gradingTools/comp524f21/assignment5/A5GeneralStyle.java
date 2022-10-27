package gradingTools.comp524f21.assignment5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.config.BasicExecutionSpecificationSelector;
import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f21.assignment5.style.A5CommonPropertiesInherited;
import gradingTools.comp524f21.assignment5.style.A5CommonSignaturesAreInherited;
import gradingTools.comp524f21.assignment5.style.A5Encapsulation;
import gradingTools.comp524f21.assignment5.style.A5InterfaceAsType;
import gradingTools.comp524f21.assignment5.style.A5NoHiddenFields;
import gradingTools.comp524f21.assignment5.style.A5NoStarImports;
import gradingTools.comp524f21.assignment5.style.A5NonPublicAccessModifiersMatched;
import gradingTools.comp524f21.assignment5.style.A5PackageDeclarations;
import gradingTools.comp524f21.assignment5.style.A5PublicMethodsOverride;
import gradingTools.comp524f21.assignment5.style.F21A5NoCheckstyleWarnings;
import gradingTools.comp524f21.assignment5.style.fileStructureTests.ProjectMatchesTemplate;
import gradingTools.comp524f21.assignment6.specificStyle.ProjectStructureOrganizesEvaluators;
import util.annotations.IsExtra;


@RunWith(Suite.class)
@Suite.SuiteClasses({
A5CommonPropertiesInherited.class,
A5CommonSignaturesAreInherited.class,
A5Encapsulation.class,
//A5InterfaceAsType.class,
A5NoHiddenFields.class,
A5NonPublicAccessModifiersMatched.class,
A5PublicMethodsOverride.class,
A5NoStarImports.class,
A5PackageDeclarations.class,
//ProjectStructureOrganizesEvaluators.class,
F21A5NoCheckstyleWarnings.class,
//ProjectMatchesTemplate.class,
	
})
	

//@MaxValue(50)
@IsExtra(true)
public class A5GeneralStyle {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(A5GeneralStyle.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	static {
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
//		setCheckStyleConfiguration("unc_checks_524_A5.xml");
//	}
}

	

