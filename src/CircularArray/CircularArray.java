package CircularArray;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {

	public T[] items;
	int length;
	int head=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Iterator<T> iterator()
	{
		return new CircularIterator<T>(this);
	}
	
	public CircularArray(int size)
	{
			items = (T[]) new Object[size];
	}
	
	
	public int Convert(int index)
	{
		
		if(index < 0)
		{
			return items.length;
		}
		
		return  (head + index) % items.length;
		
	}
	
	public void Rotate(int shift)
	{
		
		head = Convert(shift);
	}
	
	
	public T Get(int i)
	{
		return items[Convert(i)];
	}
	
	
	public void Set(int pos,T value)
	{
		
		items[Convert(pos)] = value;
		
	}
	

}
