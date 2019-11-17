package java.lang;

import java.util.Iterator;
import java.util.function.Consumer;

public interface Iterable<E> {
	public Iterator<E> iterator();
	
	public default void forEach(Consumer<? super E> action) {
		iterator().forEachRemaining(action);
	}
}
