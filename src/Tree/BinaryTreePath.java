package Tree;
import java.util.*;

import java.util.ArrayList;

public class BinaryTreePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void PrintPaths()
	{
		ArrayList<String> res = new ArrayList<String>();
		TreeNode root = new TreeNode(1);
		GetPathHelper(root, res, "");
	}
	
	//DEPTH FIRST SOLUTION
	
	public static void GetPathHelper(TreeNode root, ArrayList<String> result, String s )
	{
		
		if(root == null)
		{
			return;
			
		}
		s = s + "->" + root.val;
		if(root.left == null && root.right==null)
		{
		   result.add(s.substring(2));
		   return;
		}

		if(root.left!=null)
		{
			GetPathHelper(root.left, result, s);
		
		}
		
		if(root.right!=null)
		{
			GetPathHelper(root.right, result, s);
		
		}
	
	
		
		
		
		
		
	}

}
