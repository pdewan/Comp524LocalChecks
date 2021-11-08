package main.lisp.parser.terms;

class DecimalAtomExpressionSingleton extends AbstractMappingAtomicExpressionFactorySingleton<DecimalAtom,Double>{

	private final Class factoryClass;
	public DecimalAtomExpressionSingleton(Class factoryClass) {
		super();
		this.factoryClass=factoryClass;
	}
	
	@Override
	protected String getAtomTypeName() {
		return "Decimal";
	}

	@Override
	protected Class<? extends DecimalAtom> getInitialAtomTypeClass() {
		return DecimalAtom.class;
	}

	@Override
	protected boolean usePrimative() {
		return true;
	}

	@Override
	protected Class getMappingTypeClass() {
		return Double.class;
	}

	@Override
	protected Class getPrimitiveTypeClass() {
		return double.class;
	}

	@Override
	protected Class getFactoryTypeClass() {
		return factoryClass;
	}

}
