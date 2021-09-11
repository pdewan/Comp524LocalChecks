package gradingTools.comp524f21.assignment2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.ExpectedSubtleJavaDocs;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.InterpolatedReuse;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.MVCAndFactoryCalls;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.ModelReuse;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.PrintingCodeReuse;
import gradingTools.comp524f21.assignment2.source.SocialDistanceControllerFetchesModelSingleton;
import gradingTools.comp524f21.assignment2.style.A2CommonPropertiesInherited;
import gradingTools.comp524f21.assignment2.style.A2CommonSignaturesAreInherited;
import gradingTools.comp524f21.assignment2.style.A2Encapsulation;
import gradingTools.comp524f21.assignment2.style.A2InterfaceAsType;
import gradingTools.comp524f21.assignment2.style.A2NoHiddenFields;
import gradingTools.comp524f21.assignment2.style.A2NoStarImports;
import gradingTools.comp524f21.assignment2.style.A2NonPublicAccessModifiersMatched;
import gradingTools.comp524f21.assignment2.style.A2PackageDeclarations;
import gradingTools.comp524f21.assignment2.style.A2PublicMethodsOverride;
import gradingTools.comp524f21.assignment2.style.F21A2NoCheckstyleWarnings;
import util.annotations.IsExtra;


@RunWith(Suite.class)
@Suite.SuiteClasses({
A2CommonPropertiesInherited.class,
A2CommonSignaturesAreInherited.class,
A2Encapsulation.class,
A2InterfaceAsType.class,
A2NoHiddenFields.class,
A2NonPublicAccessModifiersMatched.class,
A2PublicMethodsOverride.class,
A2NoStarImports.class,
A2PackageDeclarations.class,
A2PublicMethodsOverride.class,
F21A2NoCheckstyleWarnings.class,

	
})
	

//@MaxValue(50)
@IsExtra(true)
public class F21A2GeneralStyle {

	public static void main (String[] args) {
		try {
//			BasicExecutionSpecificationSelector.getBasicExecutionSpecification().setLanguage(BasicLanguageDependencyManager.JAVA_LANGUAGE);

			BasicJUnitUtils.interactiveTest(F21A2GeneralStyle.class);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	static {
//		BasicExecutionSpecificationSelector.getBasicExecutionSpecification().
//		setCheckStyleConfiguration("unc_checks_524_A1.xml");
//	}
}

	

