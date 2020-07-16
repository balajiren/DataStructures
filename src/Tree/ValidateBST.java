package Tree;

public class ValidateBST {

	public ValidateBST() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	public boolean isValisBST(TreeNode root)
	{
		return IsValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean IsValidBST(TreeNode<Integer> root, double min, double max)
	{
		if(root == null)
		{
			return true;
		}
		if(root.val <= min || root.val >= max)
		{
			return false;
			
		}
		return IsValidBST(root.left,  min,  root.val) && IsValidBST(root.right, root.val, max); 
	}



}
