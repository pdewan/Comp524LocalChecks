package gradingTools.comp524f20.assignment1.testcases.socialDistance.mains;

import java.util.ArrayList;
import java.util.List;

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
				if(numRegexFound==regexList.length)
					return true;
			}
		}
		
		System.out.println("Regex: \""+regexList[numRegexFound]+"\" not found, all following regexs not checked");
		System.out.println("Note: All regex's are assumed to be in sequential order");
		return false;
	}
	
	protected boolean regexOutputChecks(String [] outputLines, String [] regexList, String [] inputList) {
		return regexOutputChecks(outputLines,regexList,inputList,this.getClass().getSimpleName());
	}
	
	private int inputNewLine=25;
	protected boolean regexOutputChecks(String [] outputLines, String [] regexList, String [] inputList, String testName) {
		System.out.println("\nTesting "+testName+" with the following inputs:");
		for(int i=0;i<inputList.length;i++)
			if(i%inputNewLine==inputNewLine-1)
				System.out.println("\""+inputList[i]+"\" ");
			else
				System.out.print("\""+inputList[i]+"\" ");
		System.out.println("\n");
		return regexOutputChecks(outputLines,regexList);
	}

	protected void setInputNewLine(int nl) {
		inputNewLine=nl;
	}
	
	protected boolean regexOutputChecksFailurePrint(String [] outputLines, String [] regexList, String [] inputList, String testName) {
		List<String> printLines = new ArrayList<String>();
		
		printLines.add("\nTesting "+testName+" with the following inputs:");
		String singleLine="";
		for(int i=0;i<inputList.length;i++)
			if(i%inputNewLine!=inputNewLine-1)
				singleLine=singleLine.concat("\""+inputList[i]+"\" ");
			else {
				printLines.add(singleLine+"\""+inputList[i]+"\" ");
				singleLine="";
			}
				
		printLines.add(singleLine+"\n");
		return regexOutputChecksFailurePrint(outputLines,regexList,printLines);
	}
	
	protected boolean regexOutputChecksFailurePrint(String [] outputLines, String [] regexList, String [] inputList) {
		return regexOutputChecksFailurePrint(outputLines,regexList,inputList,this.getClass().getSimpleName());
	}
	
	protected boolean regexOutputChecksFailurePrint(String [] outputLines, String [] regexList) {
		List<String> printLines = new ArrayList<String>();
		printLines.add("Collected output:");
		for(int i=0;i<outputLines.length;i++)
			printLines.add(i+" "+outputLines[i]);
		printLines.add("");
		
		int numRegexFound=0;
		for(int i=0;i<outputLines.length;i++) {
			if(outputLines[i].matches(regexList[numRegexFound])){
				printLines.add("Output line: \""+i+"\" matches regex: "+regexList[numRegexFound]);
				numRegexFound++;
				if(numRegexFound==regexList.length)
					return true;
			}
		}
		
		for(String line:printLines)
			System.out.println(line);
		System.out.println("Regex: \""+regexList[numRegexFound]+"\" not found, all following regexs not checked");
		System.out.println("Note: All regex's are assumed to be in sequential order");
		return false;
	}
	
	protected boolean regexOutputChecksFailurePrint(String [] outputLines, String [] regexList,List<String> printLines) {
		printLines.add("Collected output:");
		for(int i=0;i<outputLines.length;i++)
			printLines.add(i+" "+outputLines[i]);
		printLines.add("");
		
		int numRegexFound=0;
		for(int i=0;i<outputLines.length;i++) {
			if(outputLines[i].matches(regexList[numRegexFound])){
				printLines.add("Output line: \""+i+"\" matches regex: "+regexList[numRegexFound]);
				numRegexFound++;
				if(numRegexFound==regexList.length)
					return true;
			}
		}
		
		for(String line:printLines)
			System.out.println(line);
		System.out.println("Regex: \""+regexList[numRegexFound]+"\" not found, all following regexs not checked");
		System.out.println("Note: All regex's are assumed to be in sequential order");
		return false;
	}
	
}
