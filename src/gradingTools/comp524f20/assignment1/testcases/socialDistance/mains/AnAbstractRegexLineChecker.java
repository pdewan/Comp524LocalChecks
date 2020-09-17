package gradingTools.comp524f20.assignment1.testcases.socialDistance.mains;

import grader.basics.testcase.PassFailJUnitTestCase;

public abstract class AnAbstractRegexLineChecker extends PassFailJUnitTestCase{

	protected boolean regexOutputChecks(String [] outputLines, String [] regexList) {
		
		System.out.println("Collected output:");
		for(int i=0;i<outputLines.length;i++)
			System.out.println(i+" "+outputLines[i]);
		System.out.println();
		
		int numRegexFound=0;
		
		for(int i=0;i<outputLines.length;i++) {
			if(outputLines[i].matches(regexList[numRegexFound])){
				System.out.println("Output line: \""+i+"\" matches regex: "+regexList[numRegexFound]);
				numRegexFound++;
				if(numRegexFound==regexList.length-1)
					return true;
			}
		}
		
		System.out.println("Regex: \""+regexList[numRegexFound]+"\" not found, all following regexs not checked");
		System.out.println("Note: All regex's are assumed to be in sequential order");
		return false;
	}
	
	protected boolean regexOutputChecks(String [] outputLines, String [] regexList, String [] inputList, String testName) {
		System.out.println("\nTesting "+testName+" with the following inputs:");
		for(int i=0;i<inputList.length;i++)
			System.out.print(inputList[i]+" ");
		System.out.println("\n");
		return regexOutputChecks(outputLines,regexList);
	}

}
