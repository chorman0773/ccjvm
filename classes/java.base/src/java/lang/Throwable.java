package java.lang;

import jdk.internel.invoke.Stable;

public class Throwable {
	private String message;
	@Stable
	private Throwable cause;
	private final boolean suppressionEnabled;
	private final boolean writeableStackTrace;
	public Throwable() {
		this(null,null,true,true);
	}
	
	public Throwable(String message) {
		this(message,null,true,true);
	}
	
	public Throwable(Throwable cause) {
		this(cause==null?null:cause.message,cause,true,true);
	}
	
	public Throwable(String message,Throwable cause) {
		this(message,cause,true,true);
	}
	
	protected Throwable(String message,Throwable cause,boolean enableSuppression,boolean writeableStackTrace) {
		this.message = message;
		this.cause = cause;
		this.suppressionEnabled = enableSuppression;
		this.writeableStackTrace = writeableStackTrace;
	}
	
	public Throwable initCause(Throwable cause) {
		if(cause==this)
			throw new IllegalArgumentException("A Throwable cannot be its own cause");
		else if(this.cause!=null)
			throw new IllegalStateException("This throwable already has a cause");
		else
			this.cause = cause;
		return this;
	}

}
