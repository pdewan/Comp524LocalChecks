package main.lisp.parser.terms;

class StringAtomExpressionSingleton extends AbstractMappingAtomicExpressionFactorySingleton<StringAtom,String>{

	private final Class factoryClass;
	public StringAtomExpressionSingleton(Class factoryClass) {
		super();
		this.factoryClass=factoryClass;
	}
	
	@Override
	protected String getAtomTypeName() {
		return "String";
	}

	@Override
	protected Class<? extends StringAtom> getInitialAtomTypeClass() {
		return StringAtom.class;
	}

	@Override
	protected boolean usePrimative() {
		return false;
	}

	@Override
	protected Class getMappingTypeClass() {
		return String.class;
	}

	@Override
	protected Class getPrimitiveTypeClass() {
		return null;
	}

	@Override
	protected Class getFactoryTypeClass() {
		return factoryClass;
	}

}
