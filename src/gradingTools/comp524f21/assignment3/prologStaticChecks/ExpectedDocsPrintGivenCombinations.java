package gradingTools.comp524f21.assignment3.prologStaticChecks;

import gradingTools.comp524f20.assignment2.ruleTests.printGivenCombinations.PrintGivenCombinatations_NonTableSizedInputs;
import gradingTools.comp524f20.assignment2.ruleTests.printGivenCombinations.PrintGivenCombinations_OutputGeneration;
import gradingTools.comp524f20.assignment2.ruleTests.printGivenCombinations.PrintGivenCombinations_TableSizedInputs;
import util.annotations.IsExtra;
import util.annotations.MaxValue;

@MaxValue(5)
@IsExtra(true)
public class ExpectedDocsPrintGivenCombinations extends AbstractSocialDistanceCommentsPrologTest {

	private Class [] PRECEDING_TESTS = {
			PrintGivenCombinations_OutputGeneration.class,
			PrintGivenCombinations_TableSizedInputs.class,
			PrintGivenCombinatations_NonTableSizedInputs.class,
	};
	
	@Override
	protected Class [] precedingTests() {
		return PRECEDING_TESTS;
	}
	
	private final String [] regex = {".*You will need to recursively reduce both the safety table and N.*"};
	
	private final String [] methodName = {".*[Pp]rintGivenCombinations.*"};
	
	@Override
	public String [] getCommentRegex() {
		return regex;
	}

	@Override
	public String [] getMethodName() {
		return methodName;
	}


}
