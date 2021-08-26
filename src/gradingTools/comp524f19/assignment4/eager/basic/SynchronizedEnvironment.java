package gradingTools.comp524f19.assignment4.eager.basic;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import grader.basics.junit.JUnitTestsEnvironment;
import grader.basics.junit.NotAutomatableException;
import grader.basics.project.NotGradableException;
import gradingTools.comp524f19.assignment4.requiredClasses.ClassRegistryA4Provided;
import gradingTools.shared.testcases.MethodExecutionTest;
import main.ClassRegistryA4;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;
import util.annotations.MaxValue;
@MaxValue(10)
public class SynchronizedEnvironment extends MethodExecutionTest{
	
	public static boolean isSynchronized(Method aMethod) {
		return Modifier.isSynchronized(aMethod.getModifiers());
	}

	@Override
	public boolean doTest()
			throws NotAutomatableException, NotGradableException {
		ClassRegistryA4Provided aConfigurationProvided = (ClassRegistryA4Provided) JUnitTestsEnvironment.getAndPossiblyRunGradableJUnitTest(ClassRegistryA4Provided.class);
		ClassRegistryA4 classRegistry = aConfigurationProvided.getTimingOutClassRegistryProxy();
		if (classRegistry == null) {
			assertTrue("No class registry", false);
		}
		Class anEnvironmentClass = classRegistry.getNestedDynamicEnvironment();
		if (anEnvironmentClass == null) {
			anEnvironmentClass = classRegistry.getNestedLexicalEnvironment();
		}
		if (anEnvironmentClass == null) {
			assertTrue("No environment class registered with A4ClassRegistry", false);
		}
		Class[] aLookupArgs = {IdentifierAtom.class};
		Class[] anAssignArgs = {IdentifierAtom.class, SExpression.class};
		try {
			Method aLookupMethod = anEnvironmentClass.getMethod("lookup", aLookupArgs);
			Method anAssignMethod = anEnvironmentClass.getMethod("assign", anAssignArgs);
			if (!isSynchronized(aLookupMethod)) {
				 assertTrue (anEnvironmentClass.getName() + "." + aLookupMethod.getName() + " is not synchronized", false);
			}
			if (!isSynchronized(anAssignMethod)) {
				 assertTrue (anEnvironmentClass.getName() + "." + anAssignMethod.getName() + " is not synchronized", false);
			}
			
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}
