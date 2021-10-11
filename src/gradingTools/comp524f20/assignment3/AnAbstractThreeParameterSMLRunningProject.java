package gradingTools.comp524f20.assignment3;

import gradingTools.comp524f20.assignment1.SocialDistanceInputOutputFactory;

public abstract class AnAbstractThreeParameterSMLRunningProject extends AnAbstractSMLRunningProject {


	protected int[][] getInputList() {
		return SocialDistanceInputOutputFactory.getInputs();
	}
	
	protected String [] generateFunctionCalls(String functionName) {
		setInputNewLine(8);
		int [][] inputList = getInputList();
		String [] retVal = new String[inputList.length+1];
		retVal[0]=getReadabilityCommand();
		for(int i=0;i<inputList.length;i++) 
			retVal[i+1]=functionName+"("+inputList[i][0]+","+inputList[i][1]+","+inputList[i][2]+");";
		return retVal;
	}
	
	protected String [] stringToRegex(String [] list) {
		String [] retVal =new String[list.length];
		for(int i=0;i<list.length;i++)
			retVal[i]=".*"+list[i]+".*";
		return retVal;
	}
	
}
