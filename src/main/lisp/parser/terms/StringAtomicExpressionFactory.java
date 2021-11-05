package main.lisp.parser.terms;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;

import util.trace.Tracer;

public class StringAtomicExpressionFactory {

	private static final Class<? extends StringAtom> INITIAL_CLASS;
	private static Class<? extends StringAtom> clazz;
	private static HashMap<String,StringAtom> mapping;
	
	static {
		INITIAL_CLASS = StringAtom.class;
		clazz = INITIAL_CLASS;
		mapping = new HashMap<>();
	}
	
	/**
	 * This method sets the class to use for representing identifier atoms.
	 * The class must contain a constructor taking a {@link String}.
	 * 
	 * @param clazz new string atom class
	 * @throws IllegalArgumentException if the specified class does not have a constructor
	 *                                  taking an instance of {@link String}
	 */
	public static void setClass(Class<? extends StringAtom> newClazz) {
		try {
			Constructor<? extends StringAtom> c = newClazz.getDeclaredConstructor(String.class);
			int modifiers = c.getModifiers();
			boolean canAccess = false;
			if ((modifiers & Modifier.PUBLIC) != 0) {
				canAccess = true;
			} else if ((modifiers & Modifier.PROTECTED) != 0) {
				if (c.getDeclaringClass().getPackage().equals(IdentifierAtomFactory.class.getPackage())) {
					canAccess = true;
				}
			}
			if (!canAccess) {
				throw new IllegalArgumentException("String Atom class' constructor is not accessible by the factory (is it private?)");
			}
		} catch (NoSuchMethodException e) {
			throw new IllegalArgumentException("String Atom class must have a contructor with arguments (Token)", e);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		mapping=new HashMap<>();
		clazz=newClazz;
	}
	
	/**
	 * This method returns the class currently registered for
	 * representing string atoms.
	 * 
	 * @return the s-expression class
	 */
	public static Class<? extends StringAtom> getStringAtomClass() {
		return clazz;
	}
	
	/**
	 * Construct or finds a singleton string atom of the given value.
	 * 
	 * @param string, the amount the atom should be
	 * @return the new string atom
	 */
	public static StringAtom newInstance(String str){
		if(mapping.containsKey(str)) {
			StringAtom retval = mapping.get(str);
			Tracer.info(StringAtomicExpressionFactory.class, "Returning existing decimal atom: " + retval);
			return retval;
		}
		StringAtom retval=null;
		try {
			retval = (StringAtom) clazz.getDeclaredConstructor(String.class).newInstance(str);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			try {
				retval = (StringAtom) INITIAL_CLASS.getDeclaredConstructor(String.class).newInstance(str);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e1) {
				e1.printStackTrace();
			}
		}
		Tracer.info(IdentifierAtomFactory.class, "New decimal atom: " + retval);
		return retval;
	}
	
	
}
