package gradingTools.comp524f20.assignment4;

import gradingTools.comp524f20.assignment1.SocialDistanceInputOutputFactory;

public abstract class AnAbstractThreeParameterLispRunningProject extends AnAbstractLispRunningProject {
	
	protected int[][] getInputList() {
		return inputList;
	}
	
	protected int [][] inputList = SocialDistanceInputOutputFactory.getInputs();
	

	protected String [] generateFunctionCalls(String functionName) {
		setInputNewLine(8);
		String [] retVal = new String[inputList.length+2];
		retVal[0] = getReadabilityCommand();
		for(int i=0;i<inputList.length;i++) 
			retVal[i+1]="(funcall "+functionName+" "+inputList[i][0]+" "+inputList[i][1]+" "+inputList[i][2]+")";
		retVal[retVal.length-1] = "(exit)";
		return retVal;
	}
	
	protected String [] stringToRegex(String [] list) {
		String [] retVal =new String[list.length];
		for(int i=0;i<list.length;i++)
			retVal[i]=".*"+list[i]+".*";
		return retVal;
	}
	
}
