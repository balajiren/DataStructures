package Tree;
import java.util.*;
public class ConstructFromPreAndInOrder {

//Let's do it. The first element in the preorder list is a root. 
//This root splits inorder list into left and right subtrees. Now one have to pop up the root from preorder list since it's already used as a tree node and then repeat the step above for the left and right subtrees.
	
  public TreeNode buildTree(int[] preorder, int[] inorder) {
	    Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
	    
	    for(int i = 0; i < inorder.length; i++) {
	        inMap.put(inorder[i], i);
	    }

	    TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
	    return root;
	}


	
  public TreeNode<Integer> buildTree(int[] preorder,int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
		
		if(preStart > preEnd || inStart > inEnd) return null;
		   
		TreeNode root = new TreeNode(preorder[preStart]);
		int inRoot = inMap.get(root.val);
	    int numsLeft = inRoot - inStart;
	    root.left = buildTree(preorder, preStart+1, preStart+numsLeft, inorder,inStart,inRoot-1,inMap);
	    root.right = buildTree(preorder, preStart+numsLeft+1, preEnd, inorder,inRoot+1,inEnd,inMap);
		
		return root;
	}
	

}