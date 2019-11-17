package java.util;

import java.util.function.Consumer;

public interface Iterator<E> {
	public E next();
	public boolean hasNext();
	public default E remove() {
		throw new UnsupportedOperationException("remove(): Unsupported Operation");
	}
	
	public default void forEachRemaining(Consumer<? super E> action) {
		while(hasNext())
			action.accept(next());
	}
	
}
