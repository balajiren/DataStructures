package Tree;

import java.util.ArrayList;

public class PrintAllPathsWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		TreeNode<Integer> node = ConstructBTree();
		ArrayList<ArrayList<Integer>> result = pathSum(node,9);
		for(ArrayList al : result)
		{
			System.out.print(al);
		}
	}
	
	
	public static TreeNode ConstructBTree()
	{
		TreeNode node = new TreeNode<Integer>(1);
		node.left = new TreeNode<Integer>(2);
		node.right = new TreeNode<Integer>(3);
		node.right.right = new TreeNode<Integer>(4);
		node.left.right = new TreeNode<Integer>(5);
		node.left.left = new TreeNode<Integer>(6);
		return node;
	}
	
		
	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode<Integer> root, int sum) {
	    // Start typing your Java solution below
	    // DO NOT write main() function
	    ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
	    int curSum = 0;
	    ArrayList<Integer> curPath = new ArrayList<Integer>();
	    check(root, sum, curSum, curPath, paths);
	    return paths;
	  }

	  private static void check(TreeNode<Integer> node, int sum, int curSum,
	      ArrayList<Integer> curPath, ArrayList<ArrayList<Integer>> paths) {
	    if (node == null) {
	      return;
	    }
	    if (node.left == null && node.right == null) { // leaf
	      if (node.val + curSum == sum) { // equal to sum
	        ArrayList<Integer> extPath = new ArrayList<Integer>(curPath);
	        extPath.add(node.val);
	        paths.add(extPath);
	      }
	    } else {
	      int newSum = node.val + curSum;
	      ArrayList<Integer> extPath = new ArrayList<Integer>(curPath);
	      extPath.add(node.val);
	      if (node.left != null) {
	        check(node.left, sum, newSum, extPath, paths);
	      }
	      if (node.right != null) {
	        check(node.right, sum, newSum, extPath, paths);
	      }
	    }
	  }

}
