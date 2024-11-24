package gradingTools.comp524f19.assignment4.requiredClasses;

import java.io.File;
import java.util.Arrays;

import grader.basics.junit.NotAutomatableException;
import grader.basics.junit.TestCaseResult;
import grader.basics.project.NotGradableException;
import grader.basics.project.Project;
import grader.basics.testcase.PassFailJUnitTestCase;

public class TestLispFileProvided extends PassFailJUnitTestCase{
	protected String lispFileName = null;
	public String getLispFileName() {
		return lispFileName;
	}
//	@Override
//	public TestCaseResult test(Project project, boolean autoGrade)
//			throws NotAutomatableException, NotGradableException {
//		try {
//			File aProjectFolder = project.getProjectFolder();
//			if (aProjectFolder.isDirectory()) {
//				File[] aFiles = aProjectFolder.listFiles();
//				for (File aFile:aFiles) {
//					if (aFile.getName().endsWith("test.lisp")) {
//							lispFileName = aFile.getCanonicalPath();
//							return pass();
//					}
//				}
//				for (File aFile:aFiles) {
//					if (aFile.getName().endsWith(".lisp")) {
//							lispFileName = aFile.getCanonicalPath();
//							return pass();
//					}
//				}
//			}
//			return fail("No file ending with .lisp found in " + aProjectFolder.getCanonicalPath());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return fail(e.getMessage());
//		}
//	}
	public TestCaseResult test(Project project, boolean autoGrade)
			throws NotAutomatableException, NotGradableException {
		try {
			File aProjectFolder = project.getProjectFolder();
			File[] aFiles = null;			

			if (aProjectFolder.isDirectory()) {
//				File[] aFiles = aProjectFolder.listFiles();	
				aFiles = aProjectFolder.listFiles();
				for (File aFile:aFiles) {
//					System.out.println("Processing file:" + aFile);
					if (aFile.getName().endsWith("test.lisp")) {
							lispFileName = aFile.getCanonicalPath();
							return pass();
					}
				}
				for (File aFile:aFiles) {
					if (aFile.getName().endsWith(".lisp")) {
							lispFileName = aFile.getCanonicalPath();
							return pass();
					}
				}
			}
			String aFileListing = "not a directory";
			if (aFiles !=  null) {
				aFileListing = Arrays.toString(aFiles);
			}
			return fail("No file ending with .lisp found in " + aProjectFolder.getCanonicalPath() + " " + aFileListing);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return fail(e.getMessage());
		}
	}

}
