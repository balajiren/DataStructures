package LinkedList;

public class DoubleLinkedList {
	
	class Node
	{
	    protected int data;
	    protected Node next, prev;
	 
	    /* Constructor */
	    public Node()
	    {
	        next = null;
	        prev = null;
	        data = 0;
	    }
	    /* Constructor */
	    public Node(int d, Node n, Node p)
	    {
	        data = d;
	        next = n;
	        prev = p;
	    }
	    /* Function to set link to next node */
	    public void setLinkNext(Node n)
	    {
	        next = n;
	    }
	    /* Function to set link to previous node */
	    public void setLinkPrev(Node p)
	    {
	        prev = p;
	    }    
	    /* Funtion to get link to next node */
	    public Node getLinkNext()
	    {
	        return next;
	    }
	    /* Function to get link to previous node */
	    public Node getLinkPrev()
	    {
	        return prev;
	    }
	    /* Function to set data to node */
	    public void setData(int d)
	    {
	        data = d;
	    }
	    /* Function to get data from node */
	    public int getData()
	    {
	        return data;
	    }
	}
	 
	/* Class linkedList */
	class linkedList
	{
	    protected Node start;
	    protected Node end ;
	    public int size;
	 
	    /* Constructor */
	    public linkedList()
	    {
	        start = null;
	        end = null;
	        size = 0;
	    }
	    /* Function to check if list is empty */
	    public boolean isEmpty()
	    {
	        return start == null;
	    }
	    /* Function to get size of list */
	    public int getSize()
	    {
	        return size;
	    }
	    /* Function to insert element at begining */
	    public void insertAtStart(int val)
	    {
	        Node nptr = new Node(val, null, null);        
	        if(start == null)
	        {
	            start = nptr;
	            end = start;
	        }
	        else
	        {
	            start.setLinkPrev(nptr);
	            nptr.setLinkNext(start);
	            start = nptr;
	        }
	        size++;
	    }
	    /* Function to insert element at end */
	    public void insertAtEnd(int val)
	    {
	        Node nptr = new Node(val, null, null);        
	        if(start == null)
	        {
	            start = nptr;
	            end = start;
	        }
	        else
	        {
	            nptr.setLinkPrev(end);
	            end.setLinkNext(nptr);
	            end = nptr;
	        }
	        size++;
	    }
	    /* Function to insert element at position */
	    public void insertAtPos(int val , int pos)
	    {
	        Node nptr = new Node(val, null, null);    
	        if (pos == 1)
	        {
	            insertAtStart(val);
	            return;
	        }            
	        Node ptr = start;
	        for (int i = 2; i <= size; i++)
	        {
	            if (i == pos)
	            {
	                Node tmp = ptr.getLinkNext();
	                ptr.setLinkNext(nptr);
	                nptr.setLinkPrev(ptr);
	                nptr.setLinkNext(tmp);
	                tmp.setLinkPrev(nptr);
	            }
	            ptr = ptr.getLinkNext();            
	        }
	        size++ ;
	    }
	    /* Function to delete node at position */
	    public void deleteAtPos(int pos)
	    {        
	        if (pos == 1) 
	        {
	            if (size == 1)
	            {
	                start = null;
	                end = null;
	                size = 0;
	                return; 
	            }
	            start = start.getLinkNext();
	            start.setLinkPrev(null);
	            size--; 
	            return ;
	        }
	        if (pos == size)
	        {
	            end = end.getLinkPrev();
	            end.setLinkNext(null);
	            size-- ;
	        }
	        Node ptr = start.getLinkNext();
	        for (int i = 2; i <= size; i++)
	        {
	            if (i == pos)
	            {
	                Node p = ptr.getLinkPrev();
	                Node n = ptr.getLinkNext();
	 
	                p.setLinkNext(n);
	                n.setLinkPrev(p);
	                size-- ;
	                return;
	            }
	            ptr = ptr.getLinkNext();
	        }        
	    }    
	    /* Function to display status of list */
	    public void display()
	    {
	        System.out.print("\nDoubly Linked List = ");
	        if (size == 0) 
	        {
	            System.out.print("empty\n");
	            return;
	        }
	        if (start.getLinkNext() == null) 
	        {
	            System.out.println(start.getData() );
	            return;
	        }
	        Node ptr = start;
	        System.out.print(start.getData()+ " <-> ");
	        ptr = start.getLinkNext();
	        while (ptr.getLinkNext() != null)
	        {
	            System.out.print(ptr.getData()+ " <-> ");
	            ptr = ptr.getLinkNext();
	        }
	        System.out.print(ptr.getData()+ "\n");
	    }
	}

}
