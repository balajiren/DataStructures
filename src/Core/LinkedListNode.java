package Core;

public class LinkedListNode<T> {
	
	T _data;
	LinkedListNode<T> next;
	LinkedListNode<T> prev;
	LinkedListNode<T> head;
	LinkedListNode(T data)
	{
		_data = data;
		 prev = null;
		 head = null;
	}
	

}
