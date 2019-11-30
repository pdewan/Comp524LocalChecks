package gradingTools.comp524f19.assignment4.distributed.basic;

import gradingTools.shared.testcases.utils.ABufferingTestInputGenerator;

import java.util.Map;
import java.util.regex.Pattern;

import util.pipe.AnAbstractInputGenerator;
import util.trace.Tracer;

public class BasicInputGenerator extends ABufferingTestInputGenerator {
	String numThreads;
	String[] process1InputLines;
	String[] process2InputLines;
	String initiatingProcessName;
	String process1Name;
	String process2Name;
	String lastOutputInitiatingProcess;
	String lastOutputProcess1;
	public BasicInputGenerator (String anInitiatingProcess, 
			String aLastOutputLineFromInitiatingProcess, 
			String aProcess1,  String[] aProcess1InputLines, String aLastOutputProcess1,
            String aProcess2, String[] aProcess2InputLines) {
//		numThreads = Integer.toString(aNumThreads);
		
		initiatingProcessName = anInitiatingProcess;
		lastOutputInitiatingProcess = aLastOutputLineFromInitiatingProcess;
		process1Name = aProcess1;
		process2Name = aProcess2;
		process1InputLines = aProcess2InputLines;	
		process2InputLines = aProcess1InputLines;
		lastOutputProcess1 = aLastOutputProcess1;
	}
	
//	@Override
//	public void newOutputLine(String aProcessName, String anOutputLine) {
//		super.newOutputLine(aProcessName, anOutputLine);
//		if (aProcessName.equals(Assignment0Suite.MAP_REDUCE_CLIENT_2)) { // can give input to server
////			notifyNewInputLine(Assignment0Suite.MAP_REDUCE_SERVER, numThreads);
////			for (int i = 0; i < inputLines.length - 1; i++) {
////				String aLine = inputLines[i];
//
//			for (String aLine:inputLines) {
//				notifyNewInputLine(Assignment0Suite.MAP_REDUCE_SERVER, aLine);
//
////			notifyNewInputLine(GetConfiguration.MAP_REDUCE_SERVER, "aaa jjj sss zzzz aaa aaa jjj zzz aaa jjj");
////			notifyNewInputLine(GetConfiguration.MAP_REDUCE_SERVER, "bbb iii ttt yyy bbb bbb iii yyy bbb iii");
//			}
////			notifyNewInputLine(Assignment0Suite.MAP_REDUCE_SERVER, "quit");
//		}
////		if (anOutputLine.contains("Processing line:" )) {
////			notifyNewInputLine(Assignment0Suite.MAP_REDUCE_SERVER, inputLines[inputLines.length -1]);
////		}
//		
//	}
	
	
	@Override
	public void newOutputLine(String aProcessName, String anOutputLine) {
		super.newOutputLine(aProcessName, anOutputLine);
		if (process1InputLines == null || process1Name == null ) {
			return;
		}
		
		Tracer.info(this, "aProcessName:" + anOutputLine);
		if (aProcessName.equals(initiatingProcessName) && anOutputLine.equals(lastOutputInitiatingProcess)) {
			for (String anInput:process1InputLines) {
				notifyNewInputLine(process1Name, anInput);

			}
		}
		if (process2InputLines == null || process2Name == null ) {
			return;
		}
		if (aProcessName.equals(process1Name) && anOutputLine.equals(lastOutputProcess1)) {
			for (String anInput:process2InputLines) {
				notifyNewInputLine(process2Name, anInput);

			}
		}
		
		
	}
	
	
}
