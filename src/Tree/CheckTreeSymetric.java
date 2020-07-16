package Tree;

public class CheckTreeSymetric {

	
	
public static void main(String args[])
{
	
	
	
	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2);
	root.right = new TreeNode(3);
	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(5);
	
	
	
}

public static boolean IsSymmetric(TreeNode lnode, TreeNode rnode)
{
	if(lnode == null && rnode == null)
	{
		return true;
	} else 
		if(lnode == null || rnode == null)
		{
			return false;
		}
	if(lnode.left.val != rnode.right.val)
	{
		return false;
	}
	
	return IsSymmetric(lnode.left,rnode.right) || IsSymmetric(lnode.right,rnode.left);
}




public static boolean checkSymmetry(TreeNode root1, TreeNode root2)
{
    if (root1 == null && root2 == null)
    {
        return true;
    }
    else if (root1 == null || root2 == null)
    {
        return false;
    }
    else if (root1.val == root2.val)
    {
        int i = 0, j = root2.children.size() - 1;
        while ((i < root1.children.size()) && (j >= 0))
        {
            if (!checkSymmetry((TreeNode)root1.children.get(i), (TreeNode)root2.children.get(j)))
            {
                break;
            }
            i++; j--;
        }
        
        if ((i < root1.children.size()) || (j >= 0))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    return false;
}

	
	
}
