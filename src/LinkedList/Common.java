package LinkedList;

public class Common {


	public static Node<Integer> BuildLinkedListNode()
	{
		Node<Integer> node1 = new Node<Integer>(1);
    	Node<Integer> node2 = new Node<Integer>(5);
		Node<Integer> node3 = new Node<Integer>(2);
		Node<Integer> node4 = new Node<Integer>(40);
		 node1.next = node2;
		 node1.next.next=node3;
		 node1.next.next.next = node4;
		 
		return node1;
		
	}

}
