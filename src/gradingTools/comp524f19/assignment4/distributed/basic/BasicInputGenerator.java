package gradingTools.comp524f19.assignment4.distributed.basic;

import gradingTools.shared.testcases.utils.ABufferingTestInputGenerator;

import java.util.regex.Pattern;

import util.pipe.AnAbstractInputGenerator;
import util.trace.Tracer;

public class BasicInputGenerator extends ABufferingTestInputGenerator {
	String numThreads;
	String[] clientInputLines;
	public BasicInputGenerator (String[] anInputLines) {
//		numThreads = Integer.toString(aNumThreads);
		clientInputLines = anInputLines;		
	}
	
	
	
	
	@Override
	public void newOutputLine(String aProcessName, String anOutputLine) {
		super.newOutputLine(aProcessName, anOutputLine);		
		
	}
	
	
}
