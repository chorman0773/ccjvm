package java.lang.invoke;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class MethodHandle {
	private final MethodType type;
	private final Class<?> target;
	private final String linkTarget;
	
	static final class Virtual extends MethodHandle{
		//invokevirtual [target].[linkTarget][type]
		Virtual(MethodType type, Class<?> target, String linkTarget) {
			super(type, target, linkTarget);
			// TODO Auto-generated constructor stub
		}
	}
	
	
	
	static final class Zero extends MethodHandle{
		//Zero constant for the return type of type.
		//Undefined behavior occurs if type has parameters.
		Zero(MethodType type) {
			super(type, MethodHandle.class, "invoke");
		}
	}
	
	
	MethodHandle(MethodType type,Class<?> target,String linkTarget) {
		this.type = type;
		this.target = target;
		this.linkTarget = linkTarget;
	}
	
	private static native void registerNatives();
	
	static {
		registerNatives();
	}
	
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	static @interface SignaturePolymorphic{}
	
	@SignaturePolymorphic
	public final native Object invoke(Object...params) throws Throwable;
	
	@SignaturePolymorphic
	public final native Object invokeExact(Object...params) throws Throwable;
}
