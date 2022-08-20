package gradingTools.comp524f21.assignment1.testcases.sociatDistance.style;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.A1AccessModifiersMatched;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.A1InterfaceAsType;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.A1MnemonicNames;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.A1NamedConstants;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.A1NoCheckstyleWarnings;
import gradingTools.comp524f20.assignment1.testcases.socialDistance.style.A1PublicMethodsOverride;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	A1NoCheckstyleWarnings.class,
	A1NamedConstants.class,
	A1MnemonicNames.class,
})
public class A1GeneralStyleSuite {

}
