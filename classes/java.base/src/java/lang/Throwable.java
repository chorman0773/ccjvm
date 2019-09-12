package java.lang;

public class Throwable {
	private String message;
	private Throwable cause;
	private boolean suppressionEnabled;
	private boolean writeableStackTrace;
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

}
