package java.util;

public interface Spliterator<E> {
	int DISTINCT = 1, 
			SORTED =4,
			ORDERED = 16,
			SIZED = 64,
			NONNULL = 256,
			IMMUTABLE = 1024,
			CONCURRENT = 4096,
			SUBSIZED = 16384;
}
