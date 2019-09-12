package java.lang;

public final class Class<T> { 
	private final String sourceName;
	private final String binaryName;
	private final int modifiers;
	private Class(String sourceName,String binaryName,int modifiers) {
		this.sourceName = sourceName;
		this.binaryName = binaryName;
		this.modifiers = modifiers;
	}
	
	public String toString() {
		return sourceName;
	}
	
	public native T cast(Object o);
}
