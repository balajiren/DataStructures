package Tree;
import java.util.*;

public class BFSDFSTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode<Integer> root = new TreeNode<Integer>(5);
		root.left = new TreeNode<Integer>(10);
		root.right =  new TreeNode<Integer>(20);
		root.left.left = new TreeNode<Integer>(100);
		root.left.right = new TreeNode<Integer>(101);
		root.right.left = new TreeNode<Integer>(200);
		root.right.right = new TreeNode<Integer>(201);
		PerformDepthFirstSearch(root);
		
	}
	
	public static void PerformLevelOrderTraversal(TreeNode root)
	{
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root == null)
		{
			
		}
		else
		{
			if(root !=null)
			{
				queue.add(root);
			}
			while(queue.size() > 0)
			{
				TreeNode node  = queue.poll();
				System.out.print(node.val+"-->");
				if(node.left!=null)
				{
					queue.add(node.left);
				
				}
				if(node.right!=null)
				{
					queue.add(node.right);
				}
			}
			
		}
		
		
	}
	
	public enum State
	{
		
		visited, visiting, Univisited
	}
	public static void PerformBreadthFirstTraversal(TreeNode root)
	{
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		root.isVisited = true;
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			TreeNode node = queue.remove();
			ArrayList<TreeNode> lst = node.children;
			
			for(TreeNode tnode : lst)
			{
				
				if(!tnode.isVisited)
				{
					tnode.isVisited = true;
					queue.add(tnode);
				}
				
			}
			
			
		}
		
		
		
		
		
		
	}
	
	
	
	
	public static void PerformDepthFirstSearch(TreeNode root)
	{
	
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null)
		{
			
		}
		else
		{
			if(root !=null)
			{
				stack.push(root);
			}
			while(stack.size() > 0)
			{
				TreeNode node  = stack.pop();
				System.out.print(node.val+"-->");
				if(node.right!=null)
				{
					stack.push(node.right);
				
				}
				if(node.left!=null)
				{
					stack.push(node.left);
				}
			}
			
		}
	}
	

}
