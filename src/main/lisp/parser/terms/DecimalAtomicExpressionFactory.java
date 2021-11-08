package main.lisp.parser.terms;

import main.lisp.scanner.tokens.Token;

public class DecimalAtomicExpressionFactory {

	private static final DecimalAtomExpressionSingleton singleton;
	
	static {
		singleton = new DecimalAtomExpressionSingleton(DecimalAtomicExpressionFactory.class);
	}

	/**
	 * This method sets the class to use for representing identifier atoms.
	 * The class must contain a constructor taking a {@link Token}.
	 * 
	 * @param clazz new decimal atom class
	 * @throws IllegalArgumentException if the specified class does not have a constructor
	 *                                  taking an instance of {@link Token}
	 */
	public static void setClass(Class<? extends DecimalAtom> newClazz) {
		singleton.setClass(newClazz);
	}
	
	/**
	 * This method returns the class currently registered for
	 * representing decimal atoms.
	 * 
	 * @return the s-expression class
	 */
	public static Class<? extends DecimalAtom> getDecimalAtomClass() {
		return singleton.getAtomClass();
	}
	
	/**
	 * Construct or finds a singleton Decimal atom of the given value.
	 * 
	 * @param double number, the amount the atom should be
	 * @return the new decimal atom
	 */
	public static DecimalAtom newInstance(double number){
		return singleton.newInstance(number);
	}
}
