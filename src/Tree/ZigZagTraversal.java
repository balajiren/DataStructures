package Tree;

import java.util.LinkedList;
import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversal {

	static TreeNode node = null;
	public ZigZagTraversal() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBTree();
		PrintBinaryTree();
	}
	
	public static TreeNode ConstructBTree()
	{
		node = new TreeNode<Integer>(1);
		node.left = new TreeNode<Integer>(2);
		node.right = new TreeNode<Integer>(3);
		node.right.right = new TreeNode<Integer>(4);
		node.left.right = new TreeNode<Integer>(5);
		node.left.left = new TreeNode<Integer>(6);
		return node;
	}
	
	
	protected void DFS(TreeNode node, int level, List<List<Integer>> results) {
	    if (level >= results.size()) {
	      LinkedList<Integer> newLevel = new LinkedList<Integer>();
	      newLevel.add((Integer) node.val);
	      results.add(newLevel);
	    } else {
	      if (level % 2 == 0)
	        results.get(level).add((Integer) node.val);
	      else
	        results.get(level).add(0, (Integer) node.val);
	    }

	    if (node.left != null) DFS(node.left, level + 1, results);
	    if (node.right != null) DFS(node.right, level + 1, results);
	  }

	  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	    if (root == null) {
	      return new ArrayList<List<Integer>>();
	    }
	    List<List<Integer>> results = new ArrayList<List<Integer>>();
	    DFS(root, 0, results);
	    return results;
	  }
	
	public static void PrintBinaryTree()
	{
		StringBuffer buffer = new StringBuffer();
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.add(node);
		int level = 0;
		while(!s1.isEmpty() || !s2.isEmpty()){
			
			while(!s1.isEmpty())
			{
				TreeNode temp = s1.peek();
				s1.pop();
				buffer.append(temp.val+"-->");
				if(temp.right!=null)
				{
					s2.push(temp.right);
				}
				if(temp.left!=null)
				{
					s2.push(temp.left);
				}
			
			}

			while(!s2.isEmpty()){
				TreeNode temp = s2.peek();
				s2.pop();
				buffer.append(temp.val+"-->");
				
				if(temp.left!=null)
				{
					s1.push(temp.left);
				}
				
				if(temp.right!=null)
				{
					s1.push(temp.right);
				}
		
			 }
	
		 }
		
			

		System.out.print(buffer.toString());
		
	}

}
