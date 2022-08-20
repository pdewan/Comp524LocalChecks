# Comp524LocalChecks
Checks for UNC Course on Programming Language Concepts.
Export localchecks jar by creating arunnable jar around any of the suites in the project
Export gradescope jar by exporting ExportComp524Grader which has the following .project file
<projectDescription>
	<name>ExportComp524Grader</name>
	<comment></comment>
	<projects>
	</projects>
	<buildSpec>
		<buildCommand>
			<name>org.eclipse.jdt.core.javabuilder</name>
			<arguments>
			</arguments>
		</buildCommand>
	</buildSpec>
	<natures>
		<nature>org.eclipse.jdt.core.javanature</nature>
	</natures>
</projectDescription>

and the following classpath
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry kind="src" path="src"/>
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-10">
		<attributes>
			<attribute name="module" value="true"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="lib" path="/GraderBasics/lib/weka3_6.jar"/>
	<classpathentry kind="lib" path="/GraderBasics/lib/prolog-with-dependencies.jar"/>
	<classpathentry combineaccessrules="false" kind="src" path="/LispInterpreterRelease"/>
	<classpathentry combineaccessrules="false" kind="src" path="/comp110-grader"/>
	<classpathentry combineaccessrules="false" kind="src" path="/Comp524AllChecks"/>
	<classpathentry combineaccessrules="false" kind="src" path="/GraderBasics"/>
	<classpathentry combineaccessrules="false" kind="src" path="/PlaigarismCoupler"/>
	<classpathentry combineaccessrules="false" kind="src" path="/PlayingwPlaggie"/>
	<classpathentry combineaccessrules="false" kind="src" path="/diff-match-patch"/>
	<classpathentry kind="output" path="bin"/>
</classpath>

and the following runnable main:
package test;

import gradingTools.Comp524Driver;
import main.*;

public class ExportMain {
	public static void main (String[] args) {
//		Main.main(args);
		Comp524Driver.main(args);
		
	}
}