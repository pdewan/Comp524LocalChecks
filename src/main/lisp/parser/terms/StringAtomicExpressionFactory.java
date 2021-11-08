package main.lisp.parser.terms;

public class StringAtomicExpressionFactory {

	private static final StringAtomExpressionSingleton singleton;
	
	static {
		singleton=new StringAtomExpressionSingleton(StringAtomicExpressionFactory.class);
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
		singleton.setClass(newClazz);
	}
	
	/**
	 * This method returns the class currently registered for
	 * representing string atoms.
	 * 
	 * @return the s-expression class
	 */
	public static Class<? extends StringAtom> getStringAtomClass() {
		return singleton.getAtomClass();
	}
	
	/**
	 * Construct or finds a singleton string atom of the given value.
	 * 
	 * @param string, the amount the atom should be
	 * @return the new string atom
	 */
	public static StringAtom newInstance(String str){
		return singleton.newInstance(str);
	}
	
	
}
