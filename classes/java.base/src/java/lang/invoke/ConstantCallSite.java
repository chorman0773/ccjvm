package java.lang.invoke;

import jdk.internel.invoke.Stable;

public class ConstantCallSite extends CallSite {

	private final MethodHandle target;
	@Stable
	private boolean hasInitialized;
	
	public ConstantCallSite(MethodHandle target) {
		super(target.getType());
		this.target = target;
		this.hasInitialized = true;
	}

	@Override
	public MethodHandle getTarget() {
		if(!hasInitialized)
			throw new IllegalStateException("Callsite has not been initialized yet");
		return target;
	}

	@Override
	public void setTarget(MethodHandle target) {
		throw new UnsupportedOperationException("setTarget");
	}

	@Override
	public MethodHandle dynamicInvoker() {
		// TODO Auto-generated method stub
		return null;
	}

}
