package Tree;

public class DiameterOfTree {

	int ans;
	public class HeightOfTree
	{
		
		int h;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		DiameterOfTree tree = new DiameterOfTree();
		System.out.println("The diameter of given binary tree is : "
                + tree.diameterOfBinaryTree(root));


	}

	public int diameterOfBinaryTree(TreeNode root) {
		ans=1;
		depth(root);
		return ans-1;

	}
	public int depth(TreeNode node) {

		if(node == null) {
			return 0;
		}
		int L = depth(node.left);
		int R = depth(node.right);
		ans = Math.max(ans, L+R+1);
		return Math.max(L,R) +1;

	}
	
	
	public  int DiameterOfTree(TreeNode root, HeightOfTree height)
	{
		if(height == null)
		{
			height = new HeightOfTree();
		}
		HeightOfTree leftHeight = new HeightOfTree();
		HeightOfTree  rightHeight = new HeightOfTree();
		if(root == null)
		{
			height.h = 0;
			return 0;
			
			
		}
		
		leftHeight.h++;
		rightHeight.h++;
		
		int leftDiameter = DiameterOfTree(root.left, leftHeight);
		int rightDiameter = DiameterOfTree(root.right, rightHeight);

		height.h=  Math.max(leftHeight.h, rightHeight.h)+1;
		return Math.max(leftHeight.h + rightHeight.h+1, Math.max(leftDiameter, rightDiameter));
		
		
		
	}

}
