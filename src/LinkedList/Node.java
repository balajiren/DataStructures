package LinkedList;

public class Node<T> {
	
	T data;
	Node<T> next;
	Node<T> pre;
	Node<T> head;	Node<T> child;
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
	Node(T val, T prev, T next, T child)
	{

	}
	
	
     

}


