package main.lisp.parser.terms;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import util.trace.Tracer;

public class TAtomicExpressionFactory {

	private static final Class<? extends TAtom> INITIAL_CLASS;
	private static Class<? extends TAtom> clazz;
	private static TAtom singleton;
	
	static {
		INITIAL_CLASS = TAtom.class;
		clazz = INITIAL_CLASS;
		singleton = new TAtom();
	}
	
	/**
	 * This method sets the class to use for representing T atoms.
	 * The class must contain a constructor taking a no args.
	 * 
	 * @param clazz new T atom class
	 * @throws IllegalArgumentException if the specified class does not have a constructor
	 *                                  taking an instance of no args
	 */
	public static void setClass(Class<? extends TAtom> newClazz) {
		try {
			Constructor<? extends TAtom> c = newClazz.getDeclaredConstructor();
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
				throw new IllegalArgumentException("T Atom class' constructor is not accessible by the factory (is it private?)");
			}
		} catch (NoSuchMethodException e) {
			throw new IllegalArgumentException("T Atom class must have a contructor with arguments ()", e);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			singleton = (TAtom) newClazz.getDeclaredConstructor().newInstance();
			Tracer.info(IdentifierAtomFactory.class, "New T atom: " + singleton);
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
	public static Class<? extends TAtom> getTAtomClass() {
		return clazz;
	}
	
	/**
	 * returns the singleton nil atom
	 * 
	 * @return nil atom
	 */
	public static TAtom newInstance(){
		Tracer.info(TAtomicExpressionFactory.class, "Returning existing T atom: " + singleton);
		return singleton;
	}
}
