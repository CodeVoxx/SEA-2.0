package de.telekom.sea2.together;

public class Together<T, U> { // T & U sind generische Datentypen-Platzhalter

	private T t;
	private U u;

	public boolean join(T t, U u) {

		this.t = t;
		this.u = u;

		return true;
	}
	
		
	public T getT() {
		return t;
	}


	public U getU() {
		return u;
	}


	public Together() {
	}

	public Together(T t, U u) {
		this.t = t;
		this.u = u;
	}

//	public void test() {
//
//		Together<String, String> together = new Together<String, String>();
//		together.join("Erika", "Hans");
//	}

	@Override
	public String toString() {
		return String.format("%s, %s", t.toString(), u.toString());

	}

	@Override
	public int hashCode() {
		return (t.hashCode() + u.hashCode());

	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Together)) {
			return false;
		}
		return hashCode()==obj.hashCode();
	}
	
	public void split(Object obj) {
		this.t=null;
		this.u=null;
	}

	
}

/*
 * class - name -> Together
 * 
 * methods -> join() und split()
 * 
 * weitere Methoden: equals(), hashCode(), toString()
 * 
 * join(T t, U u)
 * 
 * boolean join(T t, U u)
 * 
 * Konstruktor: Together(T t, U u)
 * 
 * Defaultkonstruktor Together()
 * 
 * getter, setter
 */
