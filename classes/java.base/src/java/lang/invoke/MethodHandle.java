package java.lang.invoke;

import jdk.internel.invoke.Stable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class MethodHandle {
	private final MethodType type;
	private final Class<?> target;
	private final String linkTarget;

	@VMRead
	abstract void __resolve();

	@Stable
	@VMRead
	private ResolvedObject resolved;

	static abstract class ResolvedObject{
		private ResolvedObject(){}
		abstract boolean __is_valid();
	}



	static native ResolvedObject __link_virtual(Class<?> target,String linkTarget,MethodType type);
	static native ResolvedObject __link_static(Class<?> target,String linkTarget,MethodType type);
	static native ResolvedObject __link_special(Class<?> target,String linkTarget,MethodType type);
	static native ResolvedObject __link_static_field(Class<?> target,String linkTarget,MethodType type);
	static native ResolvedObject __link_object_field(Class<?> target,String linkTarget,MethodType type);
	static native ResolvedObject __link_signature_polymorphic(Class<?> cl,String linkTarget);
	static native ResolvedObject __link_array_accessor(Class<?> cl);

	static native ResolvedObject __bind(ResolvedObject linked,Object obj);


	
	
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


	static @interface VMRead{}
	
	@SignaturePolymorphic
	public final native Object invoke(Object...params) throws Throwable;
	
	@SignaturePolymorphic
	public final native Object invokeExact(Object...params) throws Throwable;

	public MethodType getType() {
		// TODO Auto-generated method stub
		return this.type;
	}
}
