package main.lisp.parser.terms;

public class NilAtomicExpressionFactory {

	private static NilAtomAtomicExpressionSingleton singleton;
	static {
		singleton = new NilAtomAtomicExpressionSingleton(NilAtomicExpressionFactory.class);
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
		singleton.setClass(newClazz);
	}
	
	/**
	 * This method returns the class currently registered for
	 * representing nil atoms.
	 * 
	 * @return the s-expression class
	 */
	public static Class<? extends NilAtom> getNilAtomClass() {
		return singleton.getAtomClass();
	}
	
	/**
	 * returns the singleton nil atom
	 * 
	 * @return nil atom
	 */
	public static NilAtom newInstance(){
		return singleton.newInstance();
	}
}
