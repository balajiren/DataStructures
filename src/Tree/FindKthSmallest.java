package Tree;

import java.util.Stack;

public class FindKthSmallest {

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(15);
		root.left = new TreeNode<Integer>(10);
		root.right = new TreeNode<Integer>(20);
		TreeNode<Integer> n1 = new TreeNode<Integer>(5);
		root.left.left = n1;
		root.left.right = new TreeNode<Integer>(13);
		TreeNode<Integer> n2 = new TreeNode<Integer>(14);
		root.left.right.right = n2;
		root.left.right.left = new TreeNode<Integer>(12);
		System.out.println("Kth smallest"+FindKthSmallest(root, 3));

	}
	
	
	//Inorder traversal
	public static int FindKthSmallest(TreeNode<Integer> root, int k)
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();
		 while(root!=null){
		        stack.push(root);
		        root=root.left;
		    }
		int i = 0;
		while(!stack.isEmpty())
		{
			TreeNode node = stack.pop();
			i++;
			if(i == k)
			{
				return (int) node.val;
			}
			TreeNode r = node.right;
			while(r!=null)
			{
				stack.push(r);
				r = r.left;
			}
		}
		
		
		return -1;
		
	}

}
