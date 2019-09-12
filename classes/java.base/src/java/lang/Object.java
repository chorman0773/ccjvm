package java.lang;

public class Object {
	
	private static native void registerNatives();
	
	static {
		registerNatives();
	}
	
	public native int hashCode();
	
	public Object() {}
	
	protected native Object clone() throws CloneNotSupportedException;
	
	public final native Class<?> getClass();
	
	public String toString() {
		return getClass()+"@"+hashCode();
	}
	
	public boolean equals(Object o) {
		return this==o;
	}
}
