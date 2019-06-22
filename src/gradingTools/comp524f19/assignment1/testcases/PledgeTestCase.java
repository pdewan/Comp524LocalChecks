package gradingTools.comp524f19.assignment1.testcases;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.ClassDescription;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;
import util.misc.Common;

public class PledgeTestCase extends PassFailJUnitTestCase {

	String className;
	
	public PledgeTestCase() {
//		super("Proper header test case");
		this.className = "COMP110-002, Spring 2014";
	}


	static final String PLEDGE = "Pledge: I have neither given nor received unauthorized aid";
	

	@Override
	public TestCaseResult test(Project project, boolean autoGrade) throws NotAutomatableException,
			NotGradableException {
		if (project.getClassesManager().isEmpty())
			throw new NotGradableException();

		
		for (ClassDescription description : project.getClassesManager().get()
				.getClassDescriptions()) {
			try {
				// Get the comment free code
				String code = Common.toText(description.getSource());
//						FileUtils.readFileToString(description.getSource());
				
				while (true) {
					String newCode = code.replaceAll("\\s+", " ");
					if (!newCode.equals(code)) {
						code = newCode;
						code = code.replaceAll("\u00A0", " ");
						continue;
					}
					break;
				}

				if (code.contains(PLEDGE)) {
					return pass();
				} else {
//					return fail("Could not automatically find header");
					continue;
				}

			} catch (Exception e) {
				throw new NotGradableException();
			}
		}
		return fail("Could not automatically find header");

//		throw new NotAutomatableException();
	}
}
