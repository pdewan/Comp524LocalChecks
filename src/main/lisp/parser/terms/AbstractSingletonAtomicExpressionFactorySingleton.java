package main.lisp.parser.terms;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import util.trace.Tracer;

abstract class AbstractSingletonAtomicExpressionFactorySingleton<AtomType> {

	private final Class<? extends AtomType> INITIAL_CLASS;
	private Class<? extends AtomType> clazz;
	private AtomType singleton;
	
	public AbstractSingletonAtomicExpressionFactorySingleton() {
		INITIAL_CLASS=getInitialAtomTypeClass();
		clazz=INITIAL_CLASS;
		singleton=getInitalSingleton();
	}

	public void setClass(Class<? extends AtomType> newClazz) {
		try {
			Constructor<? extends AtomType> c = newClazz.getDeclaredConstructor();
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
				throw new IllegalArgumentException(getAtomTypeName()+" class' constructor is not accessible by the factory (is it private?)");
			}
		} catch (NoSuchMethodException e) {
			throw new IllegalArgumentException(getAtomTypeName()+" class must have a contructor with arguments ()", e);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			singleton = (AtomType) newClazz.getDeclaredConstructor().newInstance();
			Tracer.info(IdentifierAtomFactory.class, "New "+getAtomTypeName()+": " + singleton);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		clazz=newClazz;
	}
	
	public Class<? extends AtomType> getAtomClass() {
		return clazz;
	}
	
	public AtomType newInstance(){
		Tracer.info(TAtomicExpressionFactory.class, "Returning existing "+getAtomTypeName()+": " + singleton);
		return singleton;
	}
	
	protected abstract String getAtomTypeName();
	protected abstract Class<? extends AtomType> getInitialAtomTypeClass();
	protected abstract AtomType getInitalSingleton();
	protected abstract Class getFactoryTypeClass();
}
