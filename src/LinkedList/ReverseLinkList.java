package LinkedList;

import java.util.LinkedList;

import Common.Utils;

public class ReverseLinkList {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Node> list = new LinkedList<Node>();
		Node<Integer> n1= new Node<Integer>(3);
		Node<Integer> n2= new Node<Integer>(4);
		Node<Integer> n3= new Node<Integer>(5);
		Node<Integer> n4= new Node<Integer>(7);
		Node<Integer> n5= new Node<Integer>(8);

		n1.next = n2;
		n1.next.next = n3;
		list.addFirst(n1);
		list.add(n2);
		list.add(n3);
		//PrintLinkedList(n1);
		PrintLinkedList(ReverseLinkedListInPlace(n1,2,3));

	}
	
	
	
	
	public static Node ReverseLinkedListInPlace(Node head, int m, int n) {
	    if(m==n) return head;
	 
	    Node prev = null;//track (m-1)th node
	    Node first = new Node(0);//first's next points to mth
	    Node second = new Node(0);//second's next points to (n+1)th
	 
	    int i=0;
	    Node p = head;
	    while(p!=null){
	        i++;
	        if(i==m-1){
	            prev = p;
	        }
	 
	        if(i==m){
	            first.next = p;
	        }
	 
	        if(i==n){
	            second.next = p.next;
	            p.next = null;
	        }
	 
	        p= p.next;
	    }
	    if(first.next == null)
	        return head;
	 
	    // reverse list [m, n]    
	    Node p1 = first.next;
	    Node p2 = p1.next;
	    p1.next = second.next;
	 
	    while(p1!=null && p2!=null){
	    	Node t = p2.next;
	        p2.next = p1;
	        p1 = p2;
	        p2 = t;
	    }
	 
	    //connect to previous part
	    if(prev!=null)
	        prev.next = p1;
	    else
	        return p1;
	 
	    return head;
	}
	
	
	
	public static  Node<Integer> reverse(Node<Integer> node1, Node<Integer> node2)
	{
		//Node<Integer> 
		return null;
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
	
	private void ReverseLinkedList(Node<Integer> node) {
		
		if(node == null) {
			return;
			
		}
		if(node.next == null) {
			node.head = node;
			return;
		}
		ReverseLinkedList(node.next);
		node.next.next=node;
		node.next=null;
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

}
