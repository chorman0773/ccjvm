package java.lang.invoke;

public final class MethodHandles {
	
	public static final class Lookup{
			public static final int PUBLIC = 0x01,
					PRIVATE = 0x02,
					PROTECTED = 0x04,
					PACKAGE = 0x08,
					MODULE = 0x10,
					UNCONDITIONAL = 0x20;
			private int lookupModes;
			private Class<?> lookupClass;
			private Lookup(Class<?> cl,int lookupModes) {
				this.lookupClass = cl;
				this.lookupModes = lookupModes;
			}
			
			public Class<?> lookupClass(){
				return this.lookupClass;
			}
			
			public int lookupModes() {
				return this.lookupModes;
			}
			
			
	}
	
	private MethodHandles() {
		// TODO Auto-generated constructor stub
	}
	

}
