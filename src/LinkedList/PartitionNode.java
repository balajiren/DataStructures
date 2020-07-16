package LinkedList;

public class PartitionNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Node<Integer> Partition(Node<Integer> node, int x)
	{
		Node before_head = new Node(0);
		Node before = before_head;
		Node after_head = new Node(0);
		Node after = after_head;

		while(node!=null) {
			if(node.data < x) {
				before.next = node;
				before = before.next;
			} else {

				after.next = node;
				after = after.next;
			}
			node = node.next;

		}
		after.next=null;
		before.next = after_head.next;
		return before_head.next;
		
		
	}

}
