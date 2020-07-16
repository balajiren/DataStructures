 package LinkedList;

import java.util.HashMap;

public class CloneLinkedList {

	public CloneLinkedList() {
		// TODO Auto-generated constructor stub
	}

	  public static void main(String args[])
	    {
	    
	     SetUpLinkedList();
	      
	    
	    }
	  
	  class NNode {
		    int val;
		    NNode next;
		    NNode random;
		    
		    public NNode(int _val,NNode _next,NNode _random) {
		        val = _val;
		        next = _next;
		        random = _random;
		    }

		    public NNode(int val) {
		        this.val = val;
		        this.next = null;
		        this.random = null;
		    }
		}
	    
	    private static void SetUpLinkedList()
	    {
	              
	       	Node<Integer> n1= new Node<Integer>(3);
	    	Node<Integer> n2= new Node<Integer>(4);
	    	Node<Integer> n3= new Node<Integer>(5);
	    	Node<Integer> head = new Node<Integer>(0);
	        head.next = n1;
	        n1.next = n2;
	    	n1.next.next = n3;
	    	n1.random = new Node<Integer>(13);
	    	
	       /*	while(n1!=null)
	    	{
	    	    System.out.print(n1.data);
	    	    n1 = n1.next;
	    	} */
	    	Node<Integer> result = CloneLinkedList1(head);
	    	while(result!=null)
	    	{
	    	    System.out.print(result.data);
	    	    result = result.next;
	    	}
	    	
	    }
	    
	    private static Node<Integer> CloneLinkedList1(Node head)
	    {
	       	Node currenthead = head;
	       	Node nhead = new Node(head.data);
	       	Node newhead = nhead;
	       	HashMap<Node,Node> map = new HashMap<Node,Node>();
	        map.put(currenthead,newhead);
	        currenthead = currenthead.next;
	        while(currenthead!=null)
	        {
	            Node<Integer> newheadnext = new Node(currenthead.data);
	            map.put(currenthead, newheadnext);
	            newhead.next = newheadnext;
	            newhead = newheadnext;
	            currenthead = currenthead.next;
	
	        }
	        currenthead = head;
	        newhead = nhead;
	        
	         while(currenthead!=null)
	        {
	            if(currenthead.random!=null)
	            {
	                newhead.random = map.get(currenthead.random);
	        
	            
	            }
	            else
	            {
	             
	                newhead.random = null;
	            }
	            
	               currenthead = currenthead.next;
	               newhead = newhead.next;
	            
	        }
	       	
	        return nhead;
	    }

	
	    HashMap<NNode, NNode> visited = new HashMap<NNode, NNode>();

	    public NNode getClonedNode(NNode node) {
	      // If the node exists then
	      if (node != null) {
	        // Check if the node is in the visited dictionary
	        if (this.visited.containsKey(node)) {
	          // If its in the visited dictionary then return the new node reference from the dictionary
	          return visited.get(node);
	        } else {
	          // Otherwise create a new node, add to the dictionary and return it
	          visited.put(node, new NNode(node.val, null, null));
	          return visited.get(node);
	        }
	      }
	      return null;
	    }

	    public NNode copyRandomList(NNode head) {

	      if (head == null) {
	        return null;
	      }

	      NNode oldNode = head;

	      // Creating the new head node.
	      NNode newNode = new NNode(oldNode.val);
	      this.visited.put(oldNode, newNode);

	      // Iterate on the linked list until all nodes are cloned.
	      while (oldNode != null) {
	        // Get the clones of the nodes referenced by random and next pointers.
	        newNode.random = this.getClonedNode(oldNode.random);
	        newNode.next = this.getClonedNode(oldNode.next);

	        // Move one step ahead in the linked list.
	        oldNode = oldNode.next;
	        newNode = newNode.next;
	      }
	      return this.visited.get(head);
	    }
	    
	   


}
