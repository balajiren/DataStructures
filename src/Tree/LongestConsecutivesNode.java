package Tree;

import java.util.LinkedList;

public class LongestConsecutivesNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int GetLongestConsecutive(TreeNode root)
	{
		int size = 0;
		int max = 0;
		if(root == null)
		{
			return 0;
		}
		LinkedList<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(root);
		
		while(que.size() >0)
		{
			TreeNode<Integer> head = que.poll();
			if(head.left!=null && head.val ==  (Integer)head.left.val +1)
			{
				size ++;
				max = Math.max(size, max);
				que.offer(head.left);
				
			} else
			{
				size =1;
			}
			
			if(head.right!=null && head.val ==  (Integer)head.right.val -1)
			{
				size ++;
				max = Math.max(size, max);
				
			} else
			{
				size = 1;
			}
			
		}
		//LinkedList<E>
		
		return max;
		
		
	}

}
