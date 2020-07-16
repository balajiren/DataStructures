package Tree;

import java.util.*;

public class MinTreeDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int minDepth(TreeNode<Integer> root) {
		
		LinkedList<TreeNode> nodeQue = new LinkedList<TreeNode>();
		Queue<Integer> counts = new LinkedList<Integer>();
		
		if(root ==null) {
			return 0;
			
		}
		nodeQue.add(root);
		while(!nodeQue.isEmpty()) {
			
			TreeNode node = nodeQue.poll();
			Integer removedCountNode = counts.remove();
		    
			if(node.left == null && node.right == null) {
				return removedCountNode;
			} else
			if(node.left != null) {
				nodeQue.add(node.left);
				counts.add(removedCountNode+1);
			}
			if(node.right != null) {
				nodeQue.add(node.right);
				counts.add(removedCountNode+1);
			}
			
		}
		return 0;
		
	}
	
	public int FindMinDepth(TreeNode<Integer> node)
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> counts = new LinkedList<Integer>();
	    q.offer(node);
	    counts.offer(1);
	    while(q.size() > 0)
	    {
	    	TreeNode<TreeNode> removedNode = q.remove();
	    	Integer removedCountNode = counts.remove();
	    	if(node.left == null && node.right == null)
	    	{
	    		return removedCountNode;
	    	}
	    	if(node.left!=null)
	    	{
	    		q.add(node.left);
	    		counts.add(removedCountNode+1);
	    	}
	    	if(node.right!=null)
	    	{
	    		q.add(node.right);
	    		counts.add(removedCountNode+1);
	    	}
	    	
	    	
	    }
		
		return 0;
	}
	
	 public int minDepth_RECURSIVE(TreeNode root) {
		    if (root == null) {
		      return 0;
		    }

		    if ((root.left == null) && (root.right == null)) {
		      return 1;
		    }

		    int min_depth = Integer.MAX_VALUE;
		    if (root.left != null) {
		      min_depth = Math.min(minDepth(root.left), min_depth);
		    }
		    if (root.right != null) {
		      min_depth = Math.min(minDepth(root.right), min_depth);
		    }

		    return min_depth + 1;
		  }


}
