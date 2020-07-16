package Tree;

public class LCA {

	
	public static void main(String[] args) 
	{
		
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		TreeNode n1 = new TreeNode(5);
		root.left.left = n1;
		root.left.right = new TreeNode(13);
		TreeNode n2 = new TreeNode(14);
		root.left.right.right = n2;
		root.left.right.left = new TreeNode(12);

		System.out.println("Lowest Common Ancestor"+FindLowestCommonAncestor(root, n1,root.left.right).val);
		
		
	}
	
	//Binary search tree
	public TreeNode lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer>  p, TreeNode<Integer>  q) {
	    TreeNode<Integer>  m = root;
	    if(m.val > p.val && m.val < q.val){
	        return m;  
	    }else if(m.val>p.val && m.val > q.val){
	        return lowestCommonAncestor(root.left, p, q);
	    }else if(m.val<p.val && m.val < q.val){
	        return lowestCommonAncestor(root.right, p, q);
	    }
	 
	    return root;
	}
	
//	The approach is pretty intuitive. Traverse the tree in a depth first manner. The moment you encounter either of the nodes p or q, return some boolean flag. The flag helps to determine if we found the required nodes in any of the paths. The least common ancestor would then be the node for which both the subtree recursions return a True flag. It can also be the node which itself is one of p or q and for which one of the subtree recursions returns a True flag.
	
	
	//Binary tree
	public static TreeNode FindLowestCommonAncestor(TreeNode root, TreeNode left, TreeNode right)
	{
		if(root == null)
		{
			return null;
		}
		else
		{
			System.out.print("\n"+root.val.toString());
			System.out.print("\n"+left.val.toString());
			System.out.print("\n"+right.val.toString());
			if(root == left || root == right)
			{
				return root;
			}
			TreeNode l1 = FindLowestCommonAncestor(root.left,  left,  right);
			TreeNode r1 = FindLowestCommonAncestor(root.right,  left,  right);
			if(l1!=null && r1!=null)
			{
				return root;
			}
			if(l1!=null)
			{
				return l1;
			}
			else if(r1!=null)
			{
				return r1;
			}
		     return null;
		}
	
		
		
	}
	
	public TreeNode FindLCA_BT(TreeNode root, TreeNode n1, TreeNode n2)
	{
		
		if(root==null)
		{
			return null;
			
			
		}
		
		else
		{
			TreeNode l1 = FindLCA_BT(root.left,n1,n2);
			TreeNode r1 = FindLCA_BT(root.right,n1,n2);
			
			if(l1 != null && r1 != null)
			{
				return root;
			}
			if(n1!=null)
			{
				return n1;
			}
			if(n2!=null)
			{
				return n2;
			}
		}
		
		return null;
	}
	

}
