package Tree;

public class UnivalTree {

	static int treecount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		TreeNode<Integer> root = new TreeNode<Integer>(5);
		root.left = new TreeNode<Integer>(4);
		root.right =  new TreeNode<Integer>(5);
		root.left.left = new TreeNode<Integer>(4);
		root.left.right = new TreeNode<Integer>(4);
		root.right.right = new TreeNode<Integer>(5);
		boolean result = CountUniValTreeOptimized(root,treecount);
		System.out.println(treecount);


	}
	
	public static boolean IsUnival(TreeNode<Integer> node)
	{
		
		if(node.val != node.left.val || node.val !=node.right.val)
		{
			return false;
		}
		return true;
		
	}
	
	public static int CountUniValTreeBruteForce(TreeNode<Integer> root)
	{
		if(root == null) {
			return 0;
		}
		int left = CountUniValTreeBruteForce(root.left);
		int right = CountUniValTreeBruteForce(root.right);
		if(IsUnival(root))
		{
		return 1+left+right;
		}
		return left + right;
		
		
		
		
	}
	
	public static boolean CountUniValTreeOptimized(TreeNode<Integer> root, int count)
	{
		if(root == null) {
			return true;
		}
		boolean left = CountUniValTreeOptimized(root.left, count);
		boolean right = CountUniValTreeOptimized(root.right,count);
		if(left == false && right == false) 
		{
			return false;
		}
		if(root.left!=null && root.val !=root.left.val)
		{
			return false;
		}
		if(root.right!=null && root.val !=root.right.val)
		{
			return false;
		}
		
		count++;
		treecount += count;
		return true;
		
		
	}
	
	

}
