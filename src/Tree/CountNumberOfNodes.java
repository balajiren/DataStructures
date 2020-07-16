package Tree;

public class CountNumberOfNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int CountNumberOfNodes(TreeNode<Integer> root)
	{
		int n = 0;
		int l = GetLeftHeight(root);
		int r = GetRightHeight(root);
		if(l == r)
		{
			return 2 << (l-1) -1 ;
		}
		else
		{
			return CountNumberOfNodes(root.left) + CountNumberOfNodes(root.right)+1;
		}
		
		
	}
	
	
	public int GetLeftHeight(TreeNode<Integer> root)
	{
		int height =0;
		while(root.left!=null)
		{
			height+=root.val;
			root = root.left;
		}
		return height;
		
	}
	
	public int GetRightHeight(TreeNode<Integer> root)
	{
		int height =0;
		while(root.right!=null)
		{
			height+=root.val;
			root = root.right;
		}
		return height;
		
	}

}
