package main.lisp.parser.terms;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import util.trace.Tracer;

public class NilAtomicExpressionFactory {

	private static final Class<? extends NilAtom> INITIAL_CLASS;
	private static Class<? extends NilAtom> clazz;
	private static NilAtom singleton;
	
	static {
		INITIAL_CLASS = NilAtom.class;
		clazz = INITIAL_CLASS;
		singleton = new NilAtom();
	}
	
	/**
	 * This method sets the class to use for representing nil atoms.
	 * The class must contain a constructor taking a no args.
	 * 
	 * @param clazz new nil atom class
	 * @throws IllegalArgumentException if the specified class does not have a constructor
	 *                                  taking an instance of no args
	 */
	public static void setClass(Class<? extends NilAtom> newClazz) {
		try {
			Constructor<? extends NilAtom> c = newClazz.getDeclaredConstructor();
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
				throw new IllegalArgumentException("Nil Atom class' constructor is not accessible by the factory (is it private?)");
			}
		} catch (NoSuchMethodException e) {
			throw new IllegalArgumentException("Nil Atom class must have a contructor with arguments ()", e);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			singleton = (NilAtom) newClazz.getDeclaredConstructor().newInstance();
			Tracer.info(IdentifierAtomFactory.class, "New NIL atom: " + singleton);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		clazz=newClazz;
	}
	
	/**
	 * This method returns the class currently registered for
	 * representing nil atoms.
	 * 
	 * @return the s-expression class
	 */
	public static Class<? extends NilAtom> getNilAtomClass() {
		return clazz;
	}
	
	/**
	 * returns the singleton nil atom
	 * 
	 * @return nil atom
	 */
	public static NilAtom newInstance(){
		Tracer.info(NilAtomicExpressionFactory.class, "Returning existing NIL atom: " + singleton);
		return singleton;
	}
}
