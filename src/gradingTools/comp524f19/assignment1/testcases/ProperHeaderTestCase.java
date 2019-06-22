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

public class ProperHeaderTestCase extends PassFailJUnitTestCase {

	String className;
	
	public ProperHeaderTestCase() {
//		super("Proper header test case");
		this.className = "COMP110-002, Spring 2014";
	}


	static final String UNFILLED_PROGRAM_NAME = "Program or Assignment #: Insert assignment name";
	static final String UNFILLED_PROGRAMMER = "Programmer: Insert your name";
	static final String UNFILLED_DUE_DATE = "Due Date: Insert due date";
	static final String UNFILLED_PROGRAM_DESCRIPTION = "Description: Insert a brief paragraph describing the program";
	static final String UNFILLED_INPUT = "Input: Insert a brief description of user inputs, or \"None\" if * there is no user input";
	static final String UNFILLED_OUTPUT = "Output: Insert a brief description of the program output";

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

//				String headerRegex = "/[*]{1,} ([*]{1,} )*((Program or Assignment)|(Program)|(Assignment)) (#|(\\d+)): .+( [*]{1,})* Programmer: .+( [*]{1,})* Due Date: .+( [*]{1,})* "+className+" Instructor: ((Prof[.]|Professor) )?Jay Aikat( [*]{1,})* Pledge: I have neither given nor received unauthorized aid ([*]{1,} )?on this program.( [*]{1,})* Description: .+( [*]{1,})* Input: .+( [*]{1,})* Output: .+( [*]{1,})*/";
				String headerRegex = "/[*]{1,} ([*]{1,} )*((Program or Assignment)|(Program)|(Assignment)) (#|(\\d+)): .+( [*]{1,})* Programmer: .+( [*]{1,})* Due Date: .+( [*]{1,})* "+className+" Instructor: ((Prof[.]|Professor) )?Jay Aikat( [*]{1,})* Pledge: I have neither given nor received unauthorized aid ([*]{1,} )?on this program.( [*]{1,})* Description: .+( [*]{1,})* Input: .+( [*]{1,})* Output: .+( [*]{1,})*/";

				Matcher matcher = Pattern.compile(headerRegex).matcher(code);
				if (matcher.find()) {
					String header = matcher.group();

					// Half credit for not filling in header
					if (header.contains(UNFILLED_PROGRAM_NAME)
							|| header.contains(UNFILLED_DUE_DATE)
							|| header.contains(UNFILLED_PROGRAMMER)
							|| header.contains(UNFILLED_PROGRAM_DESCRIPTION)
							|| header.contains(UNFILLED_INPUT) || code.contains(UNFILLED_OUTPUT)) {

						return partialPass(0.5, "Did not fill in all parts of the header");

					} else {
						return pass();
					}
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
