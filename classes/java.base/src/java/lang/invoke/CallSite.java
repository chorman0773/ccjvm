package java.lang.invoke;

public abstract class CallSite {
	final MethodType type;
	
	CallSite(MethodType type) {
		this.type = type;
	}
	
	public abstract MethodHandle getTarget();
	public abstract void setTarget(MethodHandle target);
	public abstract MethodHandle dynamicInvoker();
	public MethodType type() {
		return type;
	}
	
}
