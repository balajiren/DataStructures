package LinkedList;

import java.util.LinkedList;

public class ReOrderLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Node> list = new LinkedList<Node>();
		Node<Integer> n1= new Node<Integer>(3);
		Node<Integer> n2= new Node<Integer>(4);
		Node<Integer> n3= new Node<Integer>(5);

		n1.next = n2;
		n1.next.next = n3;
		list.addFirst(n1);
		list.add(n2);
		list.add(n3);

	}
	
	public static Node<Integer> recursiveReverse(Node<Integer> node)
	{
		    Node prev = null;
	        Node current = node;
	        Node next = null;
	        while (current != null) {
	
	            next = current.next;
	            current.next = prev;
	        	prev = current;
	        	current = next;
	        }
	        node = prev;
	        return node;
		
	}
	
	public static void ReOrderList(Node<Integer> head)
	{
		
		if(head!=null && head.next!=null)
		{
			
			Node<Integer> slow = head;
			Node<Integer> fast = head;
			
			while(fast!=null && fast.next.next!=null && fast.next!=null)
			{
				slow = slow.next;
				fast = fast.next.next;
				
				
			}
			
			//second linked list
			Node<Integer> second = slow.next;
			second.next = null;
			
			second = recursiveReverse(second);
			
			Node<Integer>  p1 = head;
			Node<Integer>  p2 = second;
			
			//merge linked list
			while(p2!=null)
			{
				Node<Integer> temp1 = p1.next;
				Node<Integer> temp2 = p2.next;
				p1.next = p2;
				p2.next = temp1;
				p1 = temp1;
				p2 = temp2;
				
				
			}
				
			
			
		}
		
		
		
		
		
	}

}
