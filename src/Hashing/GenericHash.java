package Hashing;
import java.util.*;


class HashEntry<String,T>
{
	String key;
	T value; 
	HashEntry next;
	HashEntry prev;
	
	HashEntry(String key, T value)
	{
		this.key = key;
		this.value = value;
	}
	
}
public class GenericHash<T> {
	
	
	private int TABLE_SIZE = 0;
	private HashEntry[] hashEntry;
	private int current_size = 0;
	
	GenericHash(int size)
	{
		TABLE_SIZE = size;
		hashEntry = new HashEntry[size];
		for(int i=0; i < size; i ++){
			hashEntry[i] = null;
		}
		
	}
	
	private int MyHash(String key)
	{
		int hashVal = key.hashCode() % TABLE_SIZE;
		if(hashVal == 0)
		{
			hashVal += TABLE_SIZE;
			
		}
		return hashVal;
	}
	public void Put(String key, T value)
	{
		if(key == null)
		{
			return;
		}
		int hash = MyHash(key) % TABLE_SIZE;
		if(hashEntry[hash] ==  null)
		{
			HashEntry entry = new HashEntry(key, value);
			hashEntry[hash] = entry;
		}
		else
		{
			HashEntry entry = hashEntry[hash];
			while(entry.next!=null)
			{
				entry = entry.next;
			}
			if(entry.key == key)
			{
				entry.value = value;
			}
			else
			{
				entry.next = new HashEntry(key, value);
			}
			
		}
		current_size++;
	}
	
	public T Get(String key)
	{
		T value = null;
		
		int hash = (MyHash( key ) % TABLE_SIZE);
        if (hashEntry[hash] == null)
            return null;
        else 
        {
        	HashEntry entry = hashEntry[hash];
            while (entry != null && !entry.key.equals(key))
                entry = entry.next;
            if (entry == null)
                return null;
            else
                value =  (T) entry.value;
        }
		
		
		return value;
		
	}

}
	

