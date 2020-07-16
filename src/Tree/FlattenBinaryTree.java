package Tree;

import java.util.Stack;

public class FlattenBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	public void Flatten(TreeNode root)
	{
		
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode p = root;
		
		while(p!=null || !st.isEmpty())
		{
			
			if(p.right!=null)
			{
				st.push(p.right);
			}
			if(p.left!=null)
			{
				p.right = p.left;
				p.left=null;
				
			}
			else
			{
				TreeNode r =st.pop();
				p.right = r;
			}
			p = p.right;
		}
		
		
	}

}
