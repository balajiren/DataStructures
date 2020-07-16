package Tree;

import java.util.Stack;


// class that stores the value of count
 class count {
    int c = 0;
}

public class KthLargestNodeInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode<Integer> root = new TreeNode<Integer>(40);
		root.left = new TreeNode<Integer>(20);
		root.right =  new TreeNode<Integer>(60);
		root.left.left = new TreeNode<Integer>(10);
		root.left.right = new TreeNode<Integer>(30);
		root.right.left = new TreeNode<Integer>(50);
		root.right.right = new TreeNode<Integer>(70);
		
		//TreeNode<Integer> n = GetKLargestNode(root,1,0);
		//System.out.println(n.val);
		count C = new count(); 
		secondLargestUtil(root,C,4);

	}
	
	// Function to find 2nd largest element
   static void secondLargestUtil(TreeNode<Integer> node, count C, int k)
    {   
        // Base cases, the second condition is important to
        // avoid unnecessary recursive calls
        if (node == null || C.c >= k)
            return;
             
        // Follow reverse inorder traversal so that the
        // largest element is visited first
        secondLargestUtil(node.right, C,k); 
         
         // Increment count of visited nodes
        C.c++;
         
        // If c becomes k now, then this is the 2nd largest
        if (C.c == k) {
            System.out.print("Kth largest element is "+
                                              node.val);
            return;
        } else
        {
         
         // Recur for left subtree
        	secondLargestUtil(node.left,C,k); 
        }
    }
	
	public static TreeNode<Integer> GetKLargestNode(TreeNode<Integer> root, int k, int counter)
	{
		if(root == null)
		{
			return null;
		}
		TreeNode<Integer> node = GetKLargestNode(root.right,k, counter);
		if(counter!=k)
		{
			counter++;
			node = root;
			
		}
		if(counter == k)
		{
			return node;
		} else
		{
			return GetKLargestNode(root.left,k,counter);
		}
	     
	}

}
