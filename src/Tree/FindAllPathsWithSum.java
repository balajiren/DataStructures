package Tree;

import java.util.LinkedList;

public class FindAllPathsWithSum {

	public FindAllPathsWithSum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean hasPathSumRecursive(TreeNode<Integer> root, int sum) {
		if (root == null)
			return false;
		if (root.val == sum && (root.left == null && root.right == null))
			return true;
	 
		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);
	}
	
	
	
	
	
	 public boolean hasPathSum(TreeNode<Integer> root, int sum) {
	        if(root == null) return false;
	 
	        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
	        LinkedList<Integer> values = new LinkedList<Integer>();
	 
	        nodes.add(root);
	        values.add(root.val);
	 
	        while(!nodes.isEmpty()){
	            TreeNode curr = nodes.poll();
	            int sumValue = values.poll();
	 
	            if(curr.left == null && curr.right == null && sumValue==sum){
	                return true;
	            }
	 
	            if(curr.left != null){
	                nodes.add(curr.left);
	                values.add(sumValue+(int)curr.left.val);
	            }
	 
	            if(curr.right != null){
	                nodes.add(curr.right);
	                values.add(sumValue+(int)curr.right.val);
	            }
	        }
	 
	        return false;
	    }
	 
	

}
