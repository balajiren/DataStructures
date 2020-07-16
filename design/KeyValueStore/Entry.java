package KeyValueStore;

import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;

public class Entry<K,V> {
	
	Map<K,V> map = new ConcurrentHashMap<K,V>();
	public void Put(K key, V value)
	{
		map.put(key, value);
		
	}
	
	public synchronized V Get(K key)
	{
		return map.get(key);
		
	}
	
	public void delete(K key, V value)
	{
		map.remove(key);
	}

	
}