package java.lang.invoke;

import java.io.Serializable;

import jdk.internel.invoke.Stable;

public final class MethodType implements Serializable {
	private final Class<?> returnType;
	@Stable
	private final Class<?>[] parameterTypes; 
	
	@Stable
	private transient Boolean __cached_isPrimitive;
	@Stable
	private transient MethodType __cached_generic;
	@Stable
	private transient MethodType __cached__erased;
	
	//()V
	private static final MethodType returnsVoid = new MethodType(void.class);
	
	
	
	private MethodType(Class<?> returnType) {
		this(returnType,(Class<?>[])new Class[0]);
	}
	
	private MethodType(Class<?> returnType,Class<?>[] paramTypes) {
		this.returnType = returnType;
		this.parameterTypes = paramTypes;
	}
	
	public static MethodType methodType(Class<?> returnType,MethodType original) {
		if(original.returnType==returnType)
			return original;
		else
			return new MethodType(returnType,original.parameterTypes);
	}
	
	public static MethodType methodType(Class<?> returnType) {
		if(returnType==void.class)
			return returnsVoid;
		else 
			return new MethodType(returnType);
	}
	
	public static MethodType methodType(Class<?> returnType,Class<?>[] ptypes) {
		for(Class<?> cl:ptypes)
			if(cl==void.class)
				throw new IllegalArgumentException("Cannot have void as a parameter type");
		return new MethodType(returnType,ptypes);
	}

}
