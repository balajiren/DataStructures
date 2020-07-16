package LinkedList;

public class CheckIsPalindrome {

	public CheckIsPalindrome() {
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean isPalindromeNSpace(Node head)
	{
		
		if(head == null) { return true;}
		
		Node p = head;
		Node prev = new Node(head.data);
		while(p.next!=null)
		{
			Node temp = new Node(p.next.data);
			temp.next = prev;
			prev = temp;
			p = p.next;
			
			
			
		}
		
		Node p1  = head;
		Node p2 = prev;
		
		while(p!=null)
		{
			if(p1.data != p2.data)
			{
				return false;
			}
			p1 = p1.next;
			p2 = p2.next;
			
		}
		return true;
		
	}
	
	
	
	public boolean isPalindrome1Space(Node head) {
		 
	    if(head == null || head.next==null)
	        return true;
	 
	    //find list center
	    Node fast = head;
	    Node slow = head;
	 
	    while(fast.next!=null && fast.next.next!=null){
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	 
	    Node secondHead = slow.next;
	    slow.next = null;
	 
	    //reverse second part of the list
	    Node p1 = secondHead;
	    Node p2 = p1.next;
	 
	    while(p1!=null && p2!=null){
	        Node temp = p2.next;
	        p2.next = p1;
	        p1 = p2;
	        p2 = temp;
	    }
	 
	    secondHead.next = null;
	 
	    //compare two sublists now
	    Node p = (p2==null?p1:p2);
	    Node q = head;
	    while(p!=null){
	        if(p.data != q.data)
	            return false;
	 
	        p = p.next;
	        q = q.next;
	 
	    }
	 
	    return true;
	}

}
