package main.lisp.parser.terms;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;

import main.lisp.scanner.tokens.Token;
import util.trace.Tracer;

public class DecimalAtomicExpressionFactory {

	private static final Class<? extends DecimalAtom> INITIAL_CLASS;
	private static Class<? extends DecimalAtom> clazz;
	private static HashMap<Double,DecimalAtom> mapping;
	
	static {
		INITIAL_CLASS = DecimalAtom.class;
		clazz = INITIAL_CLASS;
		mapping = new HashMap<>();
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
		try {
			Constructor<? extends DecimalAtom> c = newClazz.getDeclaredConstructor(double.class);
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
				throw new IllegalArgumentException("Decimal Atom class' constructor is not accessible by the factory (is it private?)");
			}
		} catch (NoSuchMethodException e) {
			throw new IllegalArgumentException("Decimal Atom class must have a contructor with arguments (Token)", e);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		mapping=new HashMap<>();
		clazz=newClazz;
	}
	
	/**
	 * This method returns the class currently registered for
	 * representing decimal atoms.
	 * 
	 * @return the s-expression class
	 */
	public static Class<? extends DecimalAtom> getDecimalAtomClass() {
		return clazz;
	}
	
	/**
	 * Construct or finds a singleton Decimal atom of the given value.
	 * 
	 * @param double number, the amount the atom should be
	 * @return the new decimal atom
	 */
	public static DecimalAtom newInstance(double number){
		if(mapping.containsKey(number)) {
			DecimalAtom retval = mapping.get(number);
			Tracer.info(DecimalAtomicExpressionFactory.class, "Returning existing decimal atom: " + retval);
			return retval;
		}
		DecimalAtom retval=null;
		try {
			retval = (DecimalAtom) clazz.getDeclaredConstructor(double.class).newInstance(number);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			try {
				retval = (DecimalAtom) INITIAL_CLASS.getDeclaredConstructor(double.class).newInstance(number);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e1) {
				e1.printStackTrace();
			}
		}
		Tracer.info(IdentifierAtomFactory.class, "New decimal atom: " + retval);
		return retval;
	}
	
	
}
