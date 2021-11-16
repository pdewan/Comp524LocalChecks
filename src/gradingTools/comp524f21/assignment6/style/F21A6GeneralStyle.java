package gradingTools.comp524f21.assignment6.style;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import util.annotations.IsExtra;


@RunWith(Suite.class)
@Suite.SuiteClasses({
A6CommonPropertiesInherited.class,
A6CommonSignaturesAreInherited.class,
A6Encapsulation.class,
//A5InterfaceAsType.class,
A6NoHiddenFields.class,
A6NonPublicAccessModifiersMatched.class,
A6PublicMethodsOverride.class,
A6NoStarImports.class,
A6PackageDeclarations.class,
F21A6NoCheckstyleWarnings.class,
//ProjectMatchesTemplate.class,
	
})
	

//@MaxValue(50)
@IsExtra(true)
public class F21A6GeneralStyle {

	public static void main (String[] args) {
		try {
			BasicJUnitUtils.interactiveTest(F21A6GeneralStyle.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

	

