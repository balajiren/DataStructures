package Tree;

public class CreateMBtreeFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean checkMirror(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
                if(root1.val !=root2.val){
                        return false;
                }

		if ((root1 == null && root2 != null)
				|| (root1 != null && root2 == null)) { // if any node doesn't
			// have corresponding node in the another tree, return false
			return false;
		}
		// check if left node in one tree is the right node in another tree, and
		// vice versa
		return checkMirror(root1.left, root2.right)
				&& checkMirror(root1.right, root2.left);

	}
	
	public TreeNode CreateMinimalTree(int[] data, int start, int end)
	{
		if(end < start)
		{
			return null;
		}
		int mid = start + end /2 ;
		TreeNode node  = new TreeNode(data[mid]);
		
		node.left = CreateMinimalTree(data,  start, mid-1);
		node.right = CreateMinimalTree(data,  mid+1, end);
		return node;
		
		
	}

}
