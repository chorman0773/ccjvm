package java.util.function;

@FunctionalInterface
public interface Consumer<T> {
	public void accept(T val);
	
	public default Consumer<T> andThen(Consumer<? super T> consumer) {
		return val->{this.accept(val);consumer.accept(val);};
	}

}
