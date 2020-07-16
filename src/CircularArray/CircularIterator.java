package CircularArray;

import java.util.Iterator;


public class CircularIterator<T> implements Iterator<T>{


	private int _current=-1;
	private T[] items;
	CircularArray arr1;
	
	public CircularIterator(CircularArray<T> arr)
	{
		items = arr.items;
		arr1= new CircularArray<T>(arr.length);
	}
	
	@Override
	public T next()
	{
		_current++;
		return (T)items[arr1.Convert(_current)];
	}
	

	@Override
	public boolean hasNext()
	{
		return items.length - 1 > _current;
	}
	
	@Override
	public void remove()
	{
		
	}

}
