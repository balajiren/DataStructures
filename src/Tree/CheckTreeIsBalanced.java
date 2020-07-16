package Tree;

public class CheckTreeIsBalanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		CheckTreeIsBalanced(root);

	}
	
	//Runs in O(N) and O(H) Space
	public static int CheckTreeIsBalanced(TreeNode node)
	{
		if(node == null)
		{
			return 0;
		}
		int leftHeight = CheckTreeIsBalanced(node.left);
		//GET HEIGHT OF LEFT TREE
		if(leftHeight == -1)
		{
			return -1;
		}
		
		int rightHeight = CheckTreeIsBalanced(node.right);
		if(rightHeight == -1)
		{
			return -1;
		}
		
		if(node!=null)
		{
			int diff = leftHeight - rightHeight;
			if(diff > 1)
			{
				return -1;
			}
			else
			{
				return Math.max(leftHeight, rightHeight)+1;
			}
		}
		
		return -1;
	}

}
