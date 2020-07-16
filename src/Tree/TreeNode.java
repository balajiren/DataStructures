package Tree;

import java.util.ArrayList;

public class TreeNode<T> {

	T val;
	public TreeNode left;
	public TreeNode root;
	public TreeNode right;
	public TreeNode next;
	ArrayList<TreeNode> children;
	public boolean isVisited;
	public TreeNode(T x)
	{
		val = x;
		children = new ArrayList<TreeNode>();
		isVisited = false;
		
	}
}
