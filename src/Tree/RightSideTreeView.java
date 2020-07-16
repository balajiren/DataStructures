package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Common.Utils;

public class RightSideTreeView {

	static int maxLevelSoFar =0;
	public RightSideTreeView() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static TreeNode ConstructBTree()
	{
		TreeNode<Integer> node = new TreeNode<Integer>(1);
		node.left = new TreeNode<Integer>(2);
		node.right = new TreeNode<Integer>(3);
		node.right.right = new TreeNode<Integer>(4);
		node.left.right = new TreeNode<Integer>(5);
		node.left.left = new TreeNode<Integer>(6);
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = ConstructBTree();
		rightSideView(node);
	}
	
	public static String rightSideView(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    StringBuffer buffer = new StringBuffer();
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	 
	    queue.add(root);
	  
	    while(!queue.isEmpty())
	    {
	    	int size = queue.size();
	    	for(int i=0;i<size;i++)
	    	{
	    		TreeNode node = queue.remove();
	    		if(i==0)
	    		{
	    			buffer.append(node.val);
	    			
	    		}
	    		if(node.right!=null)
	    		  queue.add(node.right);
	    		if(node.left!=null)
	    		queue.add(node.left);
	    	}
	    }
	    
	    Utils.PrintMessage(buffer.toString());
	    return buffer.toString();
	 
	  
	}

}
