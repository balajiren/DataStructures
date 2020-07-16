package LinkedList;
import java.util.*;

import Common.Utils;

public class FindNthElement {

	public FindNthElement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> node = Common.BuildLinkedListNode();
		PrintLinkedList(node);
		System.out.print(ReturnNthElement(node, 1));

	}
	
	public static void PrintLinkedList(Node<Integer> _node)
	{

		StringBuffer buffer = new StringBuffer();
		while(_node!=null)
		{
			
			buffer.append(_node.data + "-->");
			_node = _node.next;
		}
		System.out.print(buffer.substring(0, buffer.length()-3));
		
	}
	
	public Node removeNthFromEnd(Node head, int n) {
	    if(head == null)
	        return null;
	 
	    Node fast = head;
	    Node slow = head;
	 
	    for(int i=0; i<n; i++){
	        fast = fast.next;
	    }
	 
	    //if remove the first node
	    if(fast == null){
	        head = head.next;
	        return head;
	    }
	 
	    while(fast.next != null){
	        fast = fast.next;
	        slow = slow.next;
	    }
	 
	    slow.next = slow.next.next;
	 
	    return head;
	}

	
	public static int ReturnNthElement(Node<Integer> head, int position)
	{
		Node<Integer> pointer1 = head;
		Node<Integer> pointer2 = head;
		int count = 0;
		while(pointer1!=null)
		{
			if(count == position+1)
			{
				break;
			}
			count+=1;
			pointer1 = pointer1.next;
			
		}
		
		if(count == position+1)
		{
			while(pointer1!=null)
			{
				pointer1 = pointer1.next;
				pointer2 = pointer2.next;
			}
			return pointer2.data;
		}
		
		return -1;
	}
	
	

}
