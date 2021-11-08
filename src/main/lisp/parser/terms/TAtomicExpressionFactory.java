package main.lisp.parser.terms;

public class TAtomicExpressionFactory {

	private static TAtomAtomicExpressionSingleton singleton;
	
	static {
		singleton = new TAtomAtomicExpressionSingleton(TAtomicExpressionFactory.class);
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
		singleton.setClass(newClazz);
	}
	
	/**
	 * This method returns the class currently registered for
	 * representing nil atoms.
	 * 
	 * @return the s-expression class
	 */
	public static Class<? extends TAtom> getTAtomClass() {
		return singleton.getAtomClass();
	}
	
	/**
	 * returns the singleton nil atom
	 * 
	 * @return nil atom
	 */
	public static TAtom newInstance(){
		return singleton.newInstance();
	}
}
