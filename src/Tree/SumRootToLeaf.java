package Tree;

public class SumRootToLeaf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	public static TreeNode ConstructBTree()
	{
		TreeNode node = new TreeNode<Integer>(1);
		node.left = new TreeNode<Integer>(2);
		node.right = new TreeNode<Integer>(3);
		node.right.right = new TreeNode<Integer>(4);
		node.left.right = new TreeNode<Integer>(5);
		node.left.left = new TreeNode<Integer>(6);
		return node;
	}
	
	public int SumNumbers(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		
		return DFS(root, 0,0);
		
	}
	
	public int DFS(TreeNode root, int num, int sum)
	{
		if(root == null)
		{
			return sum;
		}
		num = num * 10 +  (Integer) root.val;
		if(root.left == null && root.right == null)
		{
			sum+=num;
			return sum;
			
		}
		sum = DFS(root.left, num, sum) + DFS(root.right, num, sum);
		return sum;
		
		
	}
	
	

}
