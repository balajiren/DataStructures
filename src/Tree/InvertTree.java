package Tree;

public class InvertTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public TreeNode invertTree(TreeNode root) {
	       
	      if(root==null) {
	          return null;
	      }  
	    
	      TreeNode right = invertTree(root.right);
	      TreeNode left = invertTree(root.left);
	      
	       root.left = right;
	       root.right = left;
	       return root;

	    }
	
	public void helper(TreeNode node)
	{
		
		if(null!=node)
		{
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			
		}
		
		if(node.left!=null)
		{
			helper(node.left);
		}
		
		if(node.right!=null)
		{
			helper(node.right);
		}
		
		
	}

}
