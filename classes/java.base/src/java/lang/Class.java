package java.lang;

import jdk.internel.invoke.Stable;

public final class Class<T> { 
	private final String sourceName;
	private final String binaryName;
	private final int modifiers;
	@Stable
	private Class<?> superclass;
	@Stable
	private Class<?>[] interfaces;
	private Class() {
		throw new NoSuchMethodError("Cannot construct an instance of class, VM support is required");
	}
	
	
	public String toString() {
		return sourceName;
	}
	
	public native T cast(Object o);
}
