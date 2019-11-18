package java.lang.ref;

public abstract class Reference<T> {
	private @PotentiallyUnreachable T referent;
	private final @PotentiallyUnreachable Object enqueueKey;
	Reference(@PotentiallyUnreachable T obj,ReferenceQueue<? extends T> queue) {
		this.enqueueKey = queue==null?null:subscribe(obj,queue);
		this.referent = obj;
	}
	
	private static native @PotentiallyUnreachable Object subscribe(@PotentiallyUnreachable Object referent,ReferenceQueue<?> queue);
	private static native boolean enqueued(@PotentiallyUnreachable Object obj);
	private static native boolean enque0(@PotentiallyUnreachable Object o);
	
	/**
	 * Ensures that, until the call to reachabilityFence, obj is not reclaimed by the garbage collector. 
	 * @param obj
	 */
	public static native void reachabilityFence(Object obj); 
	
	/**
	 * Converts the given strongly reachable Object into a {@literal @}PotentiallyReachable object with week semantics.
	 * At any given time, the reference may either exist, or not exist. 
	 * If it does not exist, then a call to {@link #strong(Object)} will return null. 
	 * @param o
	 * @return
	 */
	static native @PotentiallyUnreachable Object week(Object o);
	/**
	 * Converts the given {@literal @}PotentiallyUnreachable object into a strongly reachable object. 
	 * If o has been collected, then returns null. It is then the responsibility the caller to adjust its reference to the referent as such.
	 * If o is already Strongly reachable, or is null, returns o. 
	 * Otherwise, if o was obtained from a call to {@link #week(Object)} or {@link #soft(Object)} with a given object p,
	 *  returns p. 
	 * Otherwise, the result is unspecified. In particular, if the garbage collector is not aware of the potentially reachable object o, the behavior is undefined. 
	 * This method synchronizes with the garbage collector. In particular, an attempt to clean o, will either preempt this method, or follow this method (in which case, until the return value is passed, o will not be cleaned). 
	 */
	static native Object strong(@PotentiallyUnreachable Object o);
	/**
	 * Converts the given strongly reachable Object into a {@literal @}PotentiallyReachable object with soft semantics.
	 * At any given time, the reference may either exist, or not exist. 
	 * If it does not exist, then a call to {@link #strong(Object)} will return null. 
	 * 
	 * @implNote On the ccjvm implementation of this method, as garbage collection is delegated to lua, soft semantics are the same as week semantics.
	 * @param o
	 * @return
	 */
	static native @PotentiallyUnreachable Object soft(Object o);
	
	
	@SuppressWarnings("unchecked")
	public T get() {
		if(referent==null)
			return null;//Null is valid to have return here
		T value = (T)strong(referent);
		if(value==null)
			referent = null;//Referent has been reclaimed, kill it here
		return value;
	}
	
	public void clear() {
		referent = null;
	}
	
	public boolean enqueue() {
		clear();
		return enque0(enqueueKey);
	}
	
	public boolean isEnqueued() {
		return enqueued(enqueueKey);
	}
	
	protected Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
}
