package java.lang;

import java.io.Serializable;

public final class Boolean implements Comparable<Boolean>,Serializable {
	private boolean __value;
	
	public static final Boolean TRUE = new Boolean(true);
	public static final Boolean FALSE = new Boolean(false);
	public static final Class<Boolean> TYPE = boolean.class;
	@Deprecated
	public Boolean(boolean val) {
		this.__value = val;
	}

	@Override
	public int compareTo(Boolean other) {
		if(__value==other.__value)
			return 0;
		else
			return __value?1:-1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (__value ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boolean other = (Boolean) obj;
		if (__value != other.__value)
			return false;
		return true;
	}
	
	public String toString() {
		return __value?"true":"false";
	}

}
