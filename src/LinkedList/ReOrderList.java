package LinkedList;

public class ReOrderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public void reorderList(ListNode head) {
	        if (head == null || head.next == null) return;
	        
	    //find middle
	      ListNode slow = head;
	      ListNode fast = head;
	      while(fast.next!=null && fast.next.next!=null) {
	    	  slow = slow.next;
	    	  fast = fast.next.next;
	      }
	      
	      //Reverse after the middle
	      ListNode head2 = ReverseList(slow.next);
	      slow.next = null;
	      
	      //Reorder head and head2
	      ListNode curr = head;
	      while(head2!=null) {
	    	  curr = curr.next;
	    	  head.next = head2;
	    	  head2 = head2.next;
	    	  head = head.next;

	    	  head.next = curr;
	    	  head = head.next;
	    	  
	    	  
	      }
	        
	        
	        
	        
	 }
	 
	 public ListNode ReverseList(ListNode curr) {
		 
		 ListNode temp,head = null;
		 while(curr!=null) {
			  //store current node in temp
			  temp = curr;
			  //move curr to next;
			  curr = curr.next;
			  temp.next = head;
			  //put temp node as a new head i.e swapped node
			  head = temp;

			 
		 }
				 
				 
		 return head;
		 
	 }
			 
			 

}
