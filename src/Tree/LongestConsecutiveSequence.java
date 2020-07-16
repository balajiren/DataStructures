package Tree;

public class LongestConsecutiveSequence {

	public int longestConsecutive(TreeNode root) {
		return dfs(root, null, 0);
	}

	private int dfs(TreeNode p, TreeNode parent, int length) {
		if (p == null) return length;
		length = (parent != null && (Integer)p.val == (Integer) parent.val + 1) ? length + 1 : 1;
		return Math.max(length, Math.max(dfs(p.left, p, length),
				dfs(p.right, p, length)));
	}
	
	public int FindLongestConsecutiveSequence(TreeNode<Integer> root, int max)
	{
		if(root == null)
		{
			
			return 0;
			
		}
		
		int l = FindLongestConsecutiveSequence(root.left,0);
		int r  = FindLongestConsecutiveSequence(root.right,0);
		
		int fromLeft = 0;
        int fromRight= 0;
        
		if(root.left!=null && (Integer)root.left.val+ 1  == root.val)
		{
			fromLeft = l + 1;
			
		}else
		{
			fromLeft = 1;
		}
		
		if(root.right!=null && (Integer)root.right.val-1  == root.val)
		{
			fromRight = r + 1;
			
		}else
		{
			fromRight = 1;
		}
		max = Math.max(fromLeft, fromRight);
		return max;
		
		
	}
}
