package java.lang;

public abstract class Enum<E extends Enum<E>> {
	private final String __name;
	private final int __ordinal;
	protected Enum(String name,int ordinal) {
		this.__name = name;
		this.__ordinal = ordinal;
	}
	
	protected final Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
	public final boolean equals(Object other) {
		return this==other;
	}
	
	public final int hashCode()
	{
		return __name.hashCode();
	}
	
	protected final void finalize() {}
}
