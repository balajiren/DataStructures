package Tree;
import java.util.*;

public class Traversal<T> {

	 static ArrayList<Integer> list = new ArrayList<Integer>();
	
	
	public static TreeNode ConstructBTree()
	{
		TreeNode<Integer> node = new TreeNode<Integer>(1);
		node.left = new TreeNode<Integer>(2);
		node.right = new TreeNode<Integer>(3);
		node.right.right = new TreeNode<Integer>(4);
		node.left.right = new TreeNode<Integer>(5);
		node.left.left = new TreeNode<Integer>(6);
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = ConstructBTree();
		ArrayList<Integer> mylist = InOrderTraversal(node);
		
		//PreOrderTraversal(node);
		
		// ArrayList<Integer> myslist = PostOrderTraversal(node);
         
	        System.out.println("Post order traversal of binary tree is :");
	        System.out.println(mylist);
	}
	
	
	public ArrayList<ArrayList<T>> levelOrder(TreeNode root)
	{
		ArrayList<ArrayList<T>> result = new ArrayList<ArrayList<T>>();
		ArrayList<T> nodeValues = new ArrayList<T>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		if(root == null)
		{
			return result;
		}
		current.add(root);
		
		while(!current.isEmpty())
		{   
			TreeNode node = current.remove();
			if(node.left!=null)
			{
				next.add(node.left);
			}
			if(node.right!=null)
			{
				next.add(node.right);
			}

			if(current.isEmpty())
			{
				current = next;
				next = new LinkedList<TreeNode>();
				result.add(nodeValues);
				nodeValues = new ArrayList<T>(); 
			}
			
		}
		
		return result;
	}
	
	
	
	public List<Integer> postorderTraversal_Simple(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();
	 
	    if(root==null) {
	        return res;
	    }
	 
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root);
	 
	    while(!stack.isEmpty()) {
	        TreeNode temp = stack.peek();
	        if(temp.left==null && temp.right==null) {
	            TreeNode pop = stack.pop();
	            res.add((Integer) pop.val);
	        }
	        else {
	            if(temp.right!=null) {
	                stack.push(temp.right);
	                temp.right = null;
	            }
	 
	            if(temp.left!=null) {
	                stack.push(temp.left);
	                temp.left = null;
	            }
	        }
	    }
	 
	    return res;
	}
	
	
	

	public static void PreOrderTraversal(TreeNode root)
	{
		Stack<TreeNode> st= new Stack<TreeNode>();

         st.push(root);
         
         while(!st.isEmpty())
         {
           TreeNode current = st.pop();
           System.out.println(current.val);
  
           if(current.right!=null)
           {
              st.push(current.right);
           }
           
           if(current.left!=null)
           {
              st.push(current.left);
           }
 
          }
		
		
	}

	
	public static void InOrderTraversal_Recursive(TreeNode root)
	{
		
		if(root == null)
		{
			return;
		}
		
		if (root!=null)
		{
			
		InOrderTraversal_Recursive(root.left);
		System.out.print(root.val);
		InOrderTraversal_Recursive(root.right);
		
		}
		
		
		
	}
	
	
	
	public static ArrayList<Integer> InOrderTraversal(TreeNode root)
	{
		ArrayList<Integer> lst = new ArrayList<Integer>();
	   Stack<TreeNode> st= new Stack<TreeNode>();
	   if(root == null) 
	   {
		   return lst;
	   }
	   TreeNode p = root;
	   while(p!=null)
	   {
			  st.push(p);
			  p = p.left;
	  }
	   
	  while(!st.empty()) {
		  
		  TreeNode<Integer> node = st.pop();
		  if(node.right!=null) {
			  node = node.right;
			  while(node !=null) {
				  st.push(node);
				  node = node.left;
			  }
		  }
	  }

	  while(!st.isEmpty()) 
	  {
		  TreeNode<Integer> node = st.pop();
		  lst.add(node.val);
		  if(node.right!=null)
		  {
			  node = node.right;
			  while(node!=null)
			   {
				    st.push(node);
					 node = node.left;
			  }
		  
	  }
		  
				   
 	   
	}
	  
	  return lst;
	}
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
