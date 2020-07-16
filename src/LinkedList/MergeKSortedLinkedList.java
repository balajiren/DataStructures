package LinkedList;
import java.util.*;

public class MergeKSortedLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ListNode mergeKLists(ListNode[] lists) {
         
		 PriorityQueue<ListNode> pq = new  PriorityQueue<ListNode>((a,b) -> (a.val - b.val));
		 for(ListNode node : lists) {
            if(node!=null) {
			    pq.offer(node);
            }
			 
		 }
		 ListNode dummy = new ListNode(-1), curr = dummy;
		 while(!pq.isEmpty()) {
			curr.next = pq.poll();
			curr= curr.next;
			if (curr.next!=null) {
				pq.offer(curr.next);
			}
			 
		 }
	    return dummy.next ;    
    }

}
