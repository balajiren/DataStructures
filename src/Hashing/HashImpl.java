package Hashing;

public class HashImpl<T,V> {
	
	private int TABLE_SIZE;
	private int size;
	private LinkedHashEntry[] items;
	private class LinkedHashEntry<T,V>
	{
		T _key;
		V _value;
		LinkedHashEntry next;
	
		LinkedHashEntry(T key, V value)
		{
			this._key = key;
			this._value = value;
			this.next = null;
		}
		
		
	}
	
	HashImpl(int ts)
	{
		TABLE_SIZE = ts;
		items = new LinkedHashEntry[ts];
		for(int i = 0;i<ts;i++)
		{
			items[i] = null;
		}
		
	}
	
	private int myHash(T key)
	{
	   int hashCode = key.hashCode();
	   int hashVal = 0;
	   if(hashCode < 0)
	   {
		   hashVal +=TABLE_SIZE;
	   }
	   else
	   {
		   hashVal =  hashCode % TABLE_SIZE;
	   }
	   return hashVal;
	}
	
	public V get(T key)
	{
		int hash = myHash(key) % TABLE_SIZE;
		LinkedHashEntry entry = items[hash];
		while(entry._key ==key)
		{
			entry = entry.next;
		}
		return (V) entry._value;
	}
	
	 

}
