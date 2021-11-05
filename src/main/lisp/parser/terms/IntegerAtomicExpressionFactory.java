package main.lisp.parser.terms;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;

import util.trace.Tracer;

public class IntegerAtomicExpressionFactory {

	private static final Class<? extends IntegerAtom> INITIAL_CLASS;
	private static Class<? extends IntegerAtom> clazz;
	private static HashMap<Long,IntegerAtom> mapping;
	
	static {
		INITIAL_CLASS = IntegerAtom.class;
		clazz = INITIAL_CLASS;
		mapping = new HashMap<>();
	}
	
	/**
	 * This method sets the class to use for representing identifier atoms.
	 * The class must contain a constructor taking a {@link long}.
	 * 
	 * @param clazz new integer atom class
	 * @throws IllegalArgumentException if the specified class does not have a constructor
	 *                                  taking an instance of {@link long}
	 */
	public static void setClass(Class<? extends IntegerAtom> newClazz) {
		try {
			Constructor<? extends IntegerAtom> c = newClazz.getDeclaredConstructor(long.class);
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
				throw new IllegalArgumentException("Integer Atom class' constructor is not accessible by the factory (is it private?)");
			}
		} catch (NoSuchMethodException e) {
			throw new IllegalArgumentException("Integer Atom class must have a contructor with arguments (Token)", e);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		mapping=new HashMap<>();
		clazz=newClazz;
	}
	
	/**
	 * This method returns the class currently registered for
	 * representing integer atoms.
	 * 
	 * @return the s-expression class
	 */
	public static Class<? extends IntegerAtom> getIntegerAtomClass() {
		return clazz;
	}
	
	/**
	 * Construct or finds a singleton integer atom of the given value.
	 * 
	 * @param number, the amount the atom should be
	 * @return the new Integer atom
	 */
	public static IntegerAtom newInstance(long number){
		if(mapping.containsKey(number)) {
			IntegerAtom retval = mapping.get(number);
			Tracer.info(IntegerAtomicExpressionFactory.class, "Returning existing integer atom: " + retval);
			return retval;
		}
		IntegerAtom retval=null;
		try {
			retval = (IntegerAtom) clazz.getDeclaredConstructor(long.class).newInstance(number);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			try {
				retval = (IntegerAtom) INITIAL_CLASS.getDeclaredConstructor(long.class).newInstance(number);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e1) {
				e1.printStackTrace();
			}
		}
		Tracer.info(IdentifierAtomFactory.class, "New integer atom: " + retval);
		return retval;
	}
	
	
}
