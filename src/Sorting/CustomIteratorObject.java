package Sorting;

import java.util.Iterator;

public class CustomIteratorObject<T> implements Iterable<T> {

	CustomIterator iterator;
	 private int start, end;
	 public CustomIteratorObject(int start, int end) {
	        this.start = start;
	        this.end = end;
	    }
	public Iterator<T> iterator()
	{
		return new CustomIterator();
	}
	private class CustomIterator<T> implements Iterator<T>
	{
		int cursor;
		CustomIterator()
		{
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			  return this.cursor < CustomIteratorObject.this.end;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}


}
