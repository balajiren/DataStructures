	package Tree;

public class FindTreeDepth {

	static int deepestTreeNode = 0;  
	public static void main(String args[])
	{

	        TreeNode<Integer> root = new TreeNode<Integer>(1);
			root.left = new TreeNode<Integer>(2);
			root.right = new TreeNode<Integer>(3);
			root.left.left = new TreeNode<Integer>(4);
			root.left.right = new TreeNode<Integer>(5);
			root.right.left = new TreeNode<Integer>(6);
			root.right.right = new TreeNode<Integer>(7);
			root.right.right.right = new TreeNode<Integer>(8);

	        HeightOfTree(root,0);
	        System.out.print(deepestTreeNode);

	 
	    
	}
	
	public static int FindMaxDepth(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		

		int left = FindMaxDepth(root.left);
				
		int right = FindMaxDepth(root.right);

		return 1 + Math.max(left, right);
		
	}
	
	
	public static void HeightOfTree(TreeNode<Integer> input, int level)
	{
		
		if(input!=null)
		{
			HeightOfTree(input.left,level++);
		}
		if(level > deepestTreeNode)
		{
			deepestTreeNode = level;
		}
		if(input!=null)
		{
			HeightOfTree(input.right,level++);
		}
	}


	
	    

}
