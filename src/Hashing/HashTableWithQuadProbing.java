package Hashing;

import java.lang.reflect.Array;

public class HashTableWithQuadProbing<T> {

	public Object[] keys;
	public Object[] values;
	public int maxSize, currentSize;
	
	
	public HashTableWithQuadProbing(int capacity)
	{
		currentSize = 0;
		maxSize = capacity;
		keys = new Object[capacity];
		values = new Object[capacity];
		
	}
	
	public <E> E[] getArray(Class<E> clazz, int size) {
	    @SuppressWarnings("unchecked")
	    E[] arr = (E[]) Array.newInstance(clazz, size);

	    return arr;
	}
	
	public void Insert(T key, T value)
	{
		int tmp = key.hashCode();
		int i = tmp, h =1 ;
		do
		{
			if(keys[i] == null)
			{
				 keys[i] = key;
				 values[i] = value;
				 currentSize ++;
				 return;
			}
			else if(keys[i].equals(key))
			{
				 values[i] = value;
				 return;
			}
			i = (i + h * h++)% maxSize;
			
		}
		while(i!=tmp);
		
	}
	
	public T Get(T key)
	{
		int currentHash  = key.hashCode();
		int h = 1;

		while(keys[currentHash] !=null)
		{
			if(keys[currentHash].equals(key))
			{
				return (T)values[currentHash];
			}
			currentHash = (currentHash + h * h++) % maxSize;
		}
		return null;
	}
	 public boolean contains(T key) 
	    {
	        return Get(key) !=  null;
	    }
	 
	
	public void Delete(T key)
	{
		  if (!contains(key)) 
	            return;
	 
	        /** find position key and delete **/
	        int i = key.hashCode(), h = 1;
	        while (!key.equals(keys[i])) 
	            i = (i + h * h++) % maxSize;        
	        keys[i] = values[i] = null;
	 
	        /** rehash all keys **/        
	        for (i = (i + h * h++) % maxSize; keys[i] != null; i = (i + h * h++) % maxSize)
	        {
	            T tmp1 = (T) keys[i], tmp2 = (T) values[i];
	            keys[i] = values[i] = null;
	            currentSize--;  
	            Insert(tmp1, tmp2);            
	        }
	        currentSize--;        
	}
	

	public int GetSize()
	{
		return currentSize;
	}
	
	
	
}
