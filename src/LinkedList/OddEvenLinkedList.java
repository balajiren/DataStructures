package LinkedList;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode oddEvenList(ListNode head) {
	      
        ListNode temp = new ListNode(0);
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;
        
        while(even !=null && even.next!=null) {
           odd.next = even.next;
           odd = odd.next;
           even.next = odd.next;
           even = even.next;
            
        }
        
        odd.next = evenhead;
        return head;
    }
}
