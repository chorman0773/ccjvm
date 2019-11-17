package java.lang;

public class Object {
	
	private static native void registerNatives();
	
	static {
		registerNatives();
	}
	
	@Deprecated(since="9")
	protected void finalized() throws Throwable{}
	
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
	
	public final native void notify();
	public final native void notifyAll();
	public final native void wait(long milis) throws InterruptedException;
	public final void wait() throws InterruptedException {
		wait(0);
	}
	public final void wait(long milis,int nanos) throws InterruptedException {
		if(nanos>0)
			wait(milis+1);
		else
			wait(milis);
	}
	
	
}
