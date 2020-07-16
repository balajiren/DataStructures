package Tree;
import java.util.*;

public class BinaryTreeSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> node = new TreeNode<Integer>(2);
		node.left = new TreeNode<Integer>(1);
		node.right = new TreeNode<Integer>(3);
		Print(node);
		//System.out.println(Arrays.toString(result.toArray()));

	}
	
	public static void Print(TreeNode<Integer>  node)
	{
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmpres1 = new ArrayList<Integer>();
		tmpres1 = InOrderTraversal_Recursive(node,tmpres1);
		System.out.println(Arrays.toString(tmpres1.toArray()));
		
	}
	
	public static List<Integer> InOrderTraversal_Recursive(TreeNode<Integer> root, List<Integer> tmpres1)
	{
		
		if(root == null)
		{
			return tmpres1;
		}

		
		if (root!=null)
		{
			
			InOrderTraversal_Recursive(root.left,tmpres1);
			tmpres1.add(root.val);
			
			InOrderTraversal_Recursive(root.right,tmpres1);
		
		}
		
		return tmpres1;
		
	}
	
	public static void PreOrderTraversal_Recursive(TreeNode root)
	{
		
		if(root == null)
		{
			return;
		}
	
		
		if (root!=null)
		{
			
		PreOrderTraversal_Recursive(root.left);
		System.out.print(root.val);
		PreOrderTraversal_Recursive(root.right);
		
		}
		
		
		
	}
	

	
	public static List<Integer> GetSequence(TreeNode<Integer> p)
	{
		List<Integer>  result = new ArrayList<Integer>();
		Stack<TreeNode<Integer>> st = new Stack<TreeNode<Integer>>();
	    TreeNode root = p;
		while(root!=null)
		{
			st.push(root);
			root = root.left;
			
		}
		while(st.size() > 0)
		{
			TreeNode<Integer> node = st.pop();
			result.add(node.val);
			if(node.right!=null)
			{
				node = node.right;
				while(node!=null) {
					st.push(node);
					node = node.left;
				}
			}
			
		}
		return result;
		
	}
	
	

}
