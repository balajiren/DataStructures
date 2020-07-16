package Tree;

public class GetGraphHeight {

	public GetGraphHeight() {
		// TODO Auto-generated constructor stub
	}
	
	public int GetHeightOfTree(TreeNode node)
	{
		return Math.max(1+GetHeightOfTree(node.left),1+GetHeightOfTree(node.right));
	}

}
