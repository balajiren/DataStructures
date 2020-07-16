package InMemoryCache;

public class Node<T> {
	
	T data;
	Node<T> next;
	Node<T> pre;
	Node<T> head;
	Node<T> random;
	T key;
	T value;
	Node(T _data)
	{
		 data = _data;
		 next = null;
	}
	Node(T _key, T _value)
	{
		 key = _key;
		 value = _value;
	}
	
    private long expiryTime;
	
    boolean isExpired() {
         return System.currentTimeMillis() > expiryTime;
     }
	
	
     

}
