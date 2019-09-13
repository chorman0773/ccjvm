package java.lang;

import jdk.internel.invoke.Stable;

public final class String implements CharSequence {
	@Stable
	private char[] array;
	
	public String() {
		array = new char[0];
	}
	
	public String(String s) {
		array = s.array;
	}
	
	public String(char[] c) {
		array = c.clone();
	}
	
	public String(byte[] b) {
		//TODO
	}
	
	public static String valueOf(Object o) {
		if(o==null)
			return "null";
		else if(o instanceof String)
			return (String)o;
		else
			return o.toString();
	}

	
	public char charAt(int idx) {
		if(idx>array.length)
			throw new IndexOutOfBoundsException();
		return array[idx];
	}

	
	public int length() {
		// TODO Auto-generated method stub
		return array.length;
	}

	
	public java.lang.CharSequence subsequence(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public char[] toCharArray() {
		return array.clone();
	}
	
	public String toString() {
		return this;
	}
	
	public String concat(String other) {
		if(other==null)
			return concat("null");
		char[] narray = new char[array.length+other.array.length];
		System.arraycopy(array, 0, narray, 0, array.length);
		System.arraycopy(other.array, 0, narray, array.length, other.array.length);
		return new String(narray);
	}

}
