package LinkedList;

public class IntersectionOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Find the length 2. Iterate to the difference of longer - smaller 3. iterate to find diff
	
	public Node FindIntersection(Node headA, Node headB)
	{
		
		Node h1 = headA;
		Node h2 = headB;
		
		int l1 = 0;
		int l2 = 0;
		
		while(h1!=null)
		{
			h1 = h1.next;
			l1++;
		}
		while(h2!=null)
		{
			h2 = h2.next;
			l2++;
		}
		h1 =  headA;
		h2 = headB;
		if( l1 > l2)
		{
			int diff = l1 - l2;
			int i =0;
			while(i < diff)
			{
				h1 = h1.next;
				i++;
			}
			
			
		}
		if( l2 > l1)
		{
			int diff = l2 - l1;
			int i =0;
			while(i < diff)
			{
				h2 = h2.next;
				i++;
			}
			
			
		}
		while(h1!=null && h2!=null)
		{
			if(h1.data == h2.data)
			{
				return h1;
			} 
			h1 = h1.next;
			h2 = h2.next;
		}
		
		
		return null;
		
		
	}

}
