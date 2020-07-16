package LinkedList;

import java.util.HashMap;
import java.util.Hashtable;

public class DeleteDuplicateNodes {

	public DeleteDuplicateNodes() {
		// TODO Auto-generated constructor stub
	}
	
	public static void DeleteDups(Node n)
	{
		Hashtable map = new Hashtable();
		Node previous = null;
		
		while(n!=null)
		{
			
			if(map.contains(n))
			{
				previous.next = n.next;	
			}
			else
			{
				map.put(n.data,true);
				previous = n;
			}
			n = n.next;
		}
		
		
	}

}
