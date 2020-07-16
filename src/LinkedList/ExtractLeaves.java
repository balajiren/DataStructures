package LinkedList;

 /*public class ExtractLeaves {


	class Node 
	{
	    int data;
	    Node left, right;
	  
	    Node(int item) 
	    {
	        data = item;
	        right = left = null;
	    }
	}
	
	Node root;
    Node head; // will point to head of DLL  
    Node prev; // temporary pointer 
  

    public Node extractLeafList(Node root) 
    {
        if (root == null)
            return null;
        if (root.left == null && root.right == null) 
        {
            if (head == null) 
            {
                head = root;
                prev = root;
            } 
            else
            {
                prev.right = root;
                root.left = prev;
                prev = root;
            }
            return null;
        }
        root.left = extractLeafList(root.left);
        root.right = extractLeafList(root.right);
        return root;
    }
    
    public void printDLL(Node head) 
    {
        Node last = null;
        while (head != null) 
        {
            System.out.print(head.data + " ");
            last = head;
            head = head.right;
        }
    }
    
    void inorder(Node node) 
    {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
  
} */
