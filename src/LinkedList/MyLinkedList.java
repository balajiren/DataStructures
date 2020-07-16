package LinkedList;

public class MyLinkedList<T> {

	Node<T> head;
	public MyLinkedList() {
		// TODO Auto-generated constructor stub
	}
	
	  // Print list elements
    public void printList() {
        Node<T> tmp = head;
        while(tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    
    // Add a new node to the front of the linked list
    public void addToFront(int data) {
        Node<T>  n = new Node(data);
        n.next = head;
        head = n;
    }

}
