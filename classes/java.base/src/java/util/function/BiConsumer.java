package java.util.function;

//I know this doesn't compile since it needs certain classes, but that will be fixed at some point
@FunctionalInterface
public interface BiConsumer<T, U> {
	public void accept(T t,U u);
	
	public default BiConsumer<T,U> andThen(BiConsumer<? super T,? super U> other){
		return (t,u)->{
			this.accept(t, u);
			other.accept(t, u);
		};
	}
}
