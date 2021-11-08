package main.lisp.parser.terms;

class TAtomAtomicExpressionSingleton extends AbstractSingletonAtomicExpressionFactorySingleton<TAtom>{

	private Class factoryClass;
	public TAtomAtomicExpressionSingleton(Class factoryClass) {
		super();
		this.factoryClass=factoryClass;
	}
	
	@Override
	protected String getAtomTypeName() {
		return "TAtom";
	}

	@Override
	protected Class<? extends TAtom> getInitialAtomTypeClass() {
		return TAtom.class;
	}

	@Override
	protected TAtom getInitalSingleton() {
		return new TAtom();
	}

	@Override
	protected Class getFactoryTypeClass() {
		return factoryClass;
	}

}
