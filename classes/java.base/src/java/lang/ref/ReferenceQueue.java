package java.lang.ref;

public class ReferenceQueue<T> {

	public ReferenceQueue() {
		// TODO Auto-generated constructor stub
	}
	synchronized void push(Reference<? extends T> ref) {
		
		this.notifyAll();
	}
	
	public synchronized Reference<? extends T> poll(){
		return null;
	}
	
	public synchronized Reference<? extends T> remove() throws InterruptedException{
		Reference<? extends T> val;
		while((val=poll())==null)
			wait();
		return val;
	}
	
	public synchronized Reference<? extends T> remove(long timeout) throws InterruptedException{
		Reference<? extends T> val;
		if((val=poll())==null) {
			wait(timeout);
			val = poll();
		}
		return val;
	}

}
