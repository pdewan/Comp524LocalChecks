package main.lisp.parser.terms;

public class IntegerAtomExpressionSingleton extends AbstractMappingAtomicExpressionFactorySingleton<IntegerAtom,Long>{

	private final Class factoryClass;
	public IntegerAtomExpressionSingleton(Class factoryClass) {
		super();
		this.factoryClass=factoryClass;
	}
	
	@Override
	protected String getAtomTypeName() {
		return "Integer";
	}

	@Override
	protected Class<? extends IntegerAtom> getInitialAtomTypeClass() {
		return IntegerAtom.class;
	}

	@Override
	protected boolean usePrimative() {
		return true;
	}

	@Override
	protected Class getMappingTypeClass() {
		return Long.class;
	}

	@Override
	protected Class getPrimitiveTypeClass() {
		return long.class;
	}

	@Override
	protected Class getFactoryTypeClass() {
		return factoryClass;
	}

}
