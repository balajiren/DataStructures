package LinkedList;

public class ReverseKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Node reverse(Node pre, Node next){
		Node last = pre.next;
		Node curr = last.next;
	 
	    while(curr != next){
	        last.next = curr.next;
	        curr.next = pre.next;
	        pre.next = curr;
	        curr = last.next;
	    }
	 
	    return last; 
	}
	

	public static Node<Integer> ReverseKGroup(Node<Integer> head, int k)
	{
		Node<Integer> fake = new Node<Integer>(0);
		fake.next = head;
		Node<Integer> pre = fake;
		Node<Integer> p = head;
		int i=0;
		while(p !=null)
		{
			i++;
			if(i % k == 0)
			{
				pre=  reverse(pre,p.next);
				p = pre.next;
			}
			else
			{
				p = p.next;
			}
					
			
		}
		
		return fake.next;
		
	}

}
