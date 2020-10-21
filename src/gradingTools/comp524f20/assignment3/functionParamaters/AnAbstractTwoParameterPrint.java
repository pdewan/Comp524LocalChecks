package gradingTools.comp524f20.assignment3.functionParamaters;

import java.util.ArrayList;
import java.util.List;

import gradingTools.comp524f20.assignment3.AnAbstractThreeParameterSMLRunningProject;

public abstract class AnAbstractTwoParameterPrint extends AnAbstractThreeParameterSMLRunningProject {

	private String [] functions= {"givenSafe", "interpolatedSafe", "listDerivedSafe"};
	
	@Override
	protected String [] generateFunctionCalls(String functionName) {
		int [][] inputList = getInputList();
		setInputNewLine(8);
		
		List<String> vals = new ArrayList<String>();
		vals.add(getReadabilityCommand());
		
		for(int i=0;i<inputList.length;i++) {
			vals.add("val testFeatures=("+inputList[i][0]+","+inputList[i][1]+","+inputList[i][2]+");");
			for(int j=0;j<functions.length;j++) 
				vals.add(functionName+"("+functions[j]+",testFeatures);");
		}
		
		String [] retVal = new String[vals.size()];
		vals.toArray(retVal);
		return retVal;
	}
	
}
