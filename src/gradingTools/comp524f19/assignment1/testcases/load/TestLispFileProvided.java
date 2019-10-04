package gradingTools.comp524f19.assignment1.testcases.load;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;

public class TestLispFileProvided extends PassFailJUnitTestCase{
//	protected String lispFileName = null;
//	public String getLispFileName() {
//		return lispFileName;
//	}
	protected ArrayList<String> lispFileName= new ArrayList<String>();
	public ArrayList<String> getLispFileName() {
		return lispFileName;
	}
	@Override
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		try {
			File aProjectFolder = project.getProjectFolder();
			if (aProjectFolder.isDirectory()) {
				File[] aFiles = aProjectFolder.listFiles();
				for (File aFile:aFiles) {
					if (aFile.getName().endsWith(".lisp")) {
							lispFileName.add(aFile.getCanonicalPath());
							//lispFileName = aFile.getCanonicalPath();
					}
				}
			}
			if(!lispFileName.isEmpty())
			{
				return pass();
			}
			return fail("No file ending with .lisp found in " + aProjectFolder.getCanonicalPath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return fail(e.getMessage());
		}
	}

}
