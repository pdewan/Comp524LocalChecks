package gradingTools.comp524f21.assignment6.specificStyle;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import grader.basics.junit.BasicJUnitUtils;
import util.annotations.IsExtra;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	ProjectStructureOrganizesEvaluators.class,
	EnvironmentCallsGetParent.class,
	EnvironmentCallsPut.class,
	FuncallCallsExpressionFactory.class,
	IdentifierCallsEnvironmentLookup.class,
	IdentifierCallsOptionalGet.class,
	LambdaCallsLambdaFactory.class,
	
})
	

//@MaxValue(50)
@IsExtra(true)
public class F21A6SpecificStyle {

	public static void main (String[] args) {
		try {
			BasicJUnitUtils.interactiveTest(F21A6SpecificStyle.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

	

