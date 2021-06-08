package de.telekom.sea2.pair;

import java.util.Iterator;

public class PairIterator<T> implements Iterator<T> {

	private Pair<T> pair;
	private boolean t = true;
	private boolean hasNext = true;
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return hasNext;
	}

	@Override
	public T next() {
		if (t) {
			t = false;
			return pair.getT();
		} else {
			hasNext = false;
			return pair.getU();
		}

	}
	
	public PairIterator(Pair<T> pair) {
		this.pair = pair;
	}

}
