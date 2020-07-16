package Heap;

import java.util.*;

class ListNode {

		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
}

public class MergeKSortedLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ListNode mergeKLists(ListNode[] lists) {
		 
		 ListNode head = null;
		 PriorityQueue<ListNode> pq = new  PriorityQueue<ListNode>((a,b) -> (a.val - b.val));
		 for(ListNode node : lists) {
			pq.offer(node);
			 
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
