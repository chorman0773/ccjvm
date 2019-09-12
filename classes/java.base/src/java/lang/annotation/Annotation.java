package java.lang.annotation;

public interface Annotation {
	Class<? extends Annotation> getAnnotation();
	boolean equals(Object o);
	int hashCode();
	String toString();
}
