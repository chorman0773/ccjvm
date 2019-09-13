package java.util;

public interface Iterator<E> {
	public E next();
	public boolean hasNext();
	public default E remove() {
		throw new UnsupportedOperationException("remove(): Unsupported Operation");
	}
	
}
