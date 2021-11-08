package main.lisp.parser.terms;

class NilAtomAtomicExpressionSingleton extends AbstractSingletonAtomicExpressionFactorySingleton<NilAtom>{

	private Class factoryClass;
	public NilAtomAtomicExpressionSingleton(Class factoryClass) {
		super();
		this.factoryClass=factoryClass;
	}
	
	@Override
	protected String getAtomTypeName() {
		return "NilAtom";
	}

	@Override
	protected Class<? extends NilAtom> getInitialAtomTypeClass() {
		return NilAtom.class;
	}

	@Override
	protected NilAtom getInitalSingleton() {
		return new NilAtom();
	}

	@Override
	protected Class getFactoryTypeClass() {
		return factoryClass;
	}

}
