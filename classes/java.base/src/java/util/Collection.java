package java.util;

import java.util.function.IntFunction;
import java.util.function.Predicate;

public interface Collection<E> extends Iterable<E> {
	public boolean add(E e);
	public boolean addAll(Collection<? extends E> c);
	public void clear();
	public boolean contains(Object o);
	public boolean containsAll(Collection<?> c);
	public boolean equals(Object o);
	public int hashCode();
	public boolean isEmpty();
	public Iterator<E> iterator();
	public boolean remove(Object o);
	public boolean removeAll(Collection<?> c);
	public default boolean removeIf(Predicate<? super E> predicate) {
		boolean ret = false;
		for(Iterator<E> itr = iterator();itr.hasNext();) {
			E e = itr.next();
			if(predicate.test(e))
				itr.remove();
		}
		return ret;
	}
	public boolean retainAll(Collection<?> c);
	public int size();
	public Object[] toArray();
	public <T> T[] toArray(T[] arr);
	public default <T> T[] toArray(IntFunction<T[]> arr) {
		return toArray(arr.applyAsInt(0));
	}
}
