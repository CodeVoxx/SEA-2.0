package de.telekom.sea2.pair;

import java.util.Iterator;

import de.telekom.sea2.together.Together;

public class Pair<T> extends Together<T,T> implements Iterable<T> {

	@Override
	public Iterator iterator() {
	
		return new PairIterator<T>();
	} 
	
	

}
