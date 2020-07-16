package Hashing;


class LinkedEntry<T>
{
	public String key;
	public T value;
	LinkedEntry<T> next; 
	
	public LinkedEntry(String key, T value)
	{
		this.key = key;
		this.value = value;
		this.next = next;
	}
}

public class MyHashTable<T> {

	LinkedEntry[] table;
	int size=0;
	int HTSIZE = 0;
	
	MyHashTable(int size)
	{
		this.HTSIZE = size;
		table = new LinkedEntry[HTSIZE];
        for (int i = 0; i < HTSIZE; i++)
            table[i] = null;
	}
	
	
	
	public static void main(String[] args) {
	
	  MyHashTable<Integer> t = new MyHashTable<Integer>(10);
      for(int i=0;i<5;i++)
      {
    	  t.put("A"+i,1+i);
    	 
      }

      for(int i=0;i<5;i++)
      {
    	 System.out.write(t.get("A"+i));
    	 
      }
		
	}
	
	public int CalculateHash(String key)
	{
		int code = key.hashCode();
		if(code > 0)
		{
			return code % HTSIZE;
		}
	
		else return HTSIZE;
		
	}
	
    public  void put(String key, T value)
    {
    	LinkedEntry entry = new LinkedEntry(key, value);
    	int hash = CalculateHash(key);
    	table[hash] = entry;
    	size++;
    }
    
    public T get(String key)
    {
        int hash = CalculateHash(key);
        if(table[hash] == null)
        {
        	return null;
        }
        LinkedEntry entry = table[hash];
        return (T)entry.value;
        
    	
    }
	
	
	

}
