package main.lisp.parser.terms;

public class IntegerAtomicExpressionFactory {

	private static final IntegerAtomExpressionSingleton singleton;
	
	static {
		singleton = new IntegerAtomExpressionSingleton(IntegerAtomicExpressionFactory.class);
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
		singleton.setClass(newClazz);
	}
	
	/**
	 * This method returns the class currently registered for
	 * representing integer atoms.
	 * 
	 * @return the s-expression class
	 */
	public static Class<? extends IntegerAtom> getIntegerAtomClass() {
		return singleton.getAtomClass();
	}
	
	/**
	 * Construct or finds a singleton integer atom of the given value.
	 * 
	 * @param number, the amount the atom should be
	 * @return the new Integer atom
	 */
	public static IntegerAtom newInstance(long number){
		return singleton.newInstance(number);
	}
}
