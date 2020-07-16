package KeyValueStore;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class KeyValueStore<K,V> {
	
	NodeListHelper helper = new NodeListHelper();
	Node _currentNode = null;
	
	KeyValueStore() throws Exception
	{
		_currentNode = helper.GetHashNode("UserIpAddress");
	}

	public void Put(K key, V value) throws Exception
	{
		_currentNode.entry.Put(key, value);
		
	}
	
	public synchronized V Get(K key)
	{
		return (V) _currentNode.entry.Get(key);
		
	}
	
	

}
