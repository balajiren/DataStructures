package Hashing;

public class CacheNode<T> {
	
	T data;
	CacheNode<T> next;
	CacheNode<T> pre;
	CacheNode<T> head;
	CacheNode<T> random;
	T key;
	T value;
	CacheNode(T _data)
	{
		 data = _data;
		 next = null;
	}
	CacheNode(T _key, T _value)
	{
		 key = _key;
		 value = _value;
	}
	
    private long expiryTime;
	
    boolean isExpired() {
         return System.currentTimeMillis() > expiryTime;
     }
	
	
     

}
