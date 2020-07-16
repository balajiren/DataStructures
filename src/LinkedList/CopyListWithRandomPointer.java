package LinkedList;
import java.util.*;
public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//create new linked list and add current head as key and newhead as valuexA
	
	 public Node copyRandomList(Node head) {
         if(head == null) {
             return null;
         }
      	Node currenthead = head;
         Node nheadNode = new Node(head.data);
         Node newhead = nheadNode;
         HashMap<Node,Node> map = new HashMap<Node,Node>();
         map.put(currenthead,newhead);
         currenthead = currenthead.next;
         while(currenthead!=null) {
            Node newheadnext = new Node(currenthead.data);
             map.put(currenthead,newheadnext);
             newhead.next = newheadnext;
             newhead = newheadnext;
             currenthead = currenthead.next; 
         }
         currenthead = head;
         newhead = nheadNode;
         while(currenthead!=null) {
             if(currenthead.random!=null) {
                 newhead.random = map.get(currenthead.random);
             } else {
                 newhead.random = null;
             }
              currenthead = currenthead.next;
              newhead = newhead.next;
         }
	        return nheadNode;
     
 }
	
	

}
