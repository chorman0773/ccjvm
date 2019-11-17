package jdk.internel.misc;

public abstract class Unsafe {

	private Unsafe() {
		// TODO Auto-generated constructor stub
	}
	
	private static native Unsafe getUnsafe0();
	
	private static final Unsafe the_Unsafe;
	
	static {
		the_Unsafe = getUnsafe0();
	}
	
	public static Unsafe getUnsafe() {
		return the_Unsafe;
	}
	
	
	
	
	
}
