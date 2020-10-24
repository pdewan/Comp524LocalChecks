package gradingTools.comp524f20.assignment1.testcases.socialDistance.mains;

import grader.basics.testcase.PassFailJUnitTestCase;
import util.trace.Tracer;

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
	
	protected boolean regexOutputChecksTrace(String [] outputLines, String [] regexList, String [] inputList, String testName) {
		Tracer.info(this,"\nTesting "+testName+" with the following inputs:");
		for(int i=0;i<inputList.length;i++)
			if(i%inputNewLine==inputNewLine-1)
				Tracer.info(this,"\""+inputList[i]+"\" ");
			else
				Tracer.info(this,"\""+inputList[i]+"\" ");
		Tracer.info(this,"\n");
		return regexOutputChecks(outputLines,regexList);
	}
	
	protected boolean regexOutputChecksTrace(String [] outputLines, String [] regexList, String [] inputList) {
		return regexOutputChecksTrace(outputLines,regexList,inputList,this.getClass().getSimpleName());
	}
	
	protected boolean regexOutputChecksTrace(String [] outputLines, String [] regexList) {
		Tracer.info(this,"Collected output:");
		for(int i=0;i<outputLines.length;i++)
			Tracer.info(this,i+" "+outputLines[i]);
		Tracer.info(this,"");
		
		int numRegexFound=0;
		for(int i=0;i<outputLines.length;i++) {
			if(outputLines[i].matches(regexList[numRegexFound])){
				Tracer.info(this,"Output line: \""+i+"\" matches regex: "+regexList[numRegexFound]);
				numRegexFound++;
				if(numRegexFound==regexList.length)
					return true;
			}
		}
		
		Tracer.info(this,"Regex: \""+regexList[numRegexFound]+"\" not found, all following regexs not checked");
		Tracer.info(this,"Note: All regex's are assumed to be in sequential order");
		return false;
	}
	
	
}
