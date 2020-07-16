package LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

import Common.Utils;

public class LinkListProblems {

	static LinkedList<Node> l1 = new LinkedList<Node>();
	public LinkListProblems() {
		// TODO Auto-generated constructor stub
	}
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node<Integer> node = BuildLinkedList();
		 Node<Integer> result = ReverseLinkedList(node, 2);
		 System.out.println(l1.toString());


	}
	
	
	public static Node<Integer> ReverseLinkedList(Node<Integer> head, int endPosition)
	{
		
		if(head == null)
		{
			
			return null;
		}
		Node<Integer> front = null;
		Node<Integer> middle = head;
		Node<Integer> end = null;
		int i=0;
		while(i<endPosition && i < endPosition)
		{
			end = middle.next;
			middle.next = front;
			front = middle;
			middle = end;
			i++;
			
			
		}
		 head.next = ReverseLinkedList(middle,endPosition);
	     return front;		
		
	}
	
	
	public static Node<Integer> BuildLinkedList()
	{

		Node<Integer> node1 = new Node<Integer>(1);
		l1.addFirst(node1);
		 Node<Integer> node2 = new Node<Integer>(5);
	
		l1.add(node2);
		 Node<Integer> node3 = new Node<Integer>(2);
		l1.add(node3);
		Node<Integer> node4 = new Node<Integer>(40);
		l1.add(node4);
		 node1.next = node2;
		 node1.next.next=node3;
		 node1.next.next.next = node4;
		 
		return l1.getFirst();
		
	}
	
	public Node<Integer> MergeLists(Node<Integer>  n1, Node<Integer>  n2)
	{
		Node<Integer> result = new Node<Integer>(0);
		Node<Integer> root = result.head;
		while (n1!=null || n2!=null)
		{
			if(n1!=null && n2!=null)
			{
				if(n1.data < n2.data)
				{
					root.next = n1;
					n1 = n1.next;
				}
				else
				{
					root.next = n2;
					n2=n2.next;
				}
				root = root.next;
			}
			else if(n1==null)
			{
				root.next = n2;
				break;
			}
			else if(n2==null)
			{
				root.next = n1;
				break;
			}
		}
		
		
		return root.next;
		
	}

}
