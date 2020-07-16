package Tree;
import java.util.*;

public class BTreeIterator {

	Stack<TreeNode> stack;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	BTreeIterator(TreeNode root)
	{
		stack = new Stack<TreeNode>();
		stack.push(root);
	    while(root!=null)
	    {
	    	stack.push(root);
	    	root = root.left;
	    }
		
	}
	
	public boolean hasNext()
	{
		
		return stack.size() > 0;
	}
	
	public int next()
	{

			TreeNode n = stack.pop();
			int val = (Integer) n.val;
			if(n.right !=null)
			{
				TreeNode rn = n.right;
				while(n!=null)
				{
					stack.push(n);
					n = n.left;
				}
			}

		return val;
	}


}
