package gradingTools.comp524f22.assignment4.concisePrintSafety;

import java.util.ArrayList;
import java.util.List;

import gradingTools.comp524f20.assignment1.SocialDistanceInputOutputFactory;
import gradingTools.comp524f20.assignment3.functionParamaters.ConcisePrintSafety;
import util.annotations.MaxValue;
@MaxValue(15)
public class ConcisePrintSafetyTest extends ConcisePrintSafety {
	public static final int TIME_OUT_SECS = 1; // secs	
	private static List<Integer> allowed;
	
	//Using all values caused a tracing issue. In hindsight it was an excessive number of testing
	//So I've decreased the number of tests by 33%
	static {
		allowed = new ArrayList<>();
		int totalTests = SocialDistanceInputOutputFactory.getInputs().length;
		for(int i=0;i<totalTests;i++)
			if(i%3!=0) allowed.add(i);
	}
	
	@Override
	protected String [] generateFunctionCalls(String functionName) {
		int [][] inputList = getInputList();
		setInputNewLine(8);
		
		List<String> vals = new ArrayList<String>();
		vals.add(getReadabilityCommand());
		
		for(Integer i:allowed) {
			vals.add("val testFeatures=("+inputList[i][0]+","+inputList[i][1]+","+inputList[i][2]+");");
			for(int j=0;j<functions.length;j++) 
				vals.add(functionName+"("+functions[j]+",testFeatures);");
		}		
		return vals.toArray(new String[vals.size()]);
	}
	
	@Override
	protected String[] generateRegexs(boolean[]... expectedValues ) {
		
		int [][] inputList = this.getInputList();
		if(inputList.length!=expectedValues[0].length)
			return null;
		
//		String [] retVal=new String[(expectedValues.length*allowed.size())];
		List<String> retval = new ArrayList<>();
		
		for(Integer i:allowed)
			for(int j=0;j<expectedValues.length;j++)
				retval.add(
					".*("+inputList[i][0]+
					", *"+inputList[i][1]+
					", *"+inputList[i][2]+
					", *"+expectedValues[j][i]+").*"
					);
				
		return retval.toArray(new String[retval.size()]);
	}
	
}
