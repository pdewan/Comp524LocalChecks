package main.lisp.parser.terms;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;

import main.lisp.scanner.tokens.Token;
import util.trace.Tracer;

abstract class AbstractMappingAtomicExpressionFactorySingleton<AtomType, MappingType> {

	private final Class<? extends AtomType> INITIAL_CLASS;
	private Class<? extends AtomType> clazz;
	private HashMap<MappingType,AtomType> mapping;
	
	public AbstractMappingAtomicExpressionFactorySingleton() {
		INITIAL_CLASS = getInitialAtomTypeClass();
		clazz = INITIAL_CLASS;
		mapping = new HashMap<>();
	}

	public void setClass(Class<? extends AtomType> newClazz) {
		try {
			Constructor<? extends AtomType> c = newClazz.getDeclaredConstructor(usePrimative()?getPrimitiveTypeClass():getMappingTypeClass());
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
				throw new IllegalArgumentException(getAtomTypeName()+" Atom class' constructor is not accessible by the factory (is it private?)");
			}
		} catch (NoSuchMethodException e) {
			throw new IllegalArgumentException(getAtomTypeName()+" Atom class must have a contructor with arguments", e);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		mapping=new HashMap<>();
		clazz=newClazz;
	}
	
	public Class<? extends AtomType> getAtomClass() {
		return clazz;
	}
	
	public AtomType newInstance(MappingType number){
		if(mapping.containsKey(number)) {
			AtomType retval = mapping.get(number);
			Tracer.info(getFactoryTypeClass(), "Returning existing "+getAtomTypeName()+" atom: " + retval);
			return retval;
		}
		AtomType retval=null;
		try {
			retval = (AtomType) clazz.getDeclaredConstructor(usePrimative()?getPrimitiveTypeClass():getMappingTypeClass()).newInstance(number);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			try {
				retval = (AtomType) INITIAL_CLASS.getDeclaredConstructor(usePrimative()?getPrimitiveTypeClass():getMappingTypeClass()).newInstance(number);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e1) {
				e1.printStackTrace();
			}
		}
		Tracer.info(getFactoryTypeClass(), "New "+getAtomTypeName()+" atom: " + retval);
		return retval;
	}
	
	protected abstract String getAtomTypeName();
	protected abstract Class<? extends AtomType> getInitialAtomTypeClass();
	protected abstract boolean usePrimative();
	protected abstract Class getMappingTypeClass();
	protected abstract Class getPrimitiveTypeClass();
	protected abstract Class getFactoryTypeClass();
}
