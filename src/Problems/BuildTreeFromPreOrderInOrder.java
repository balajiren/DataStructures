package Problems;

import Tree.TreeNode;
import java.util.*;

public class BuildTreeFromPreOrderInOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] inorder = new int[]{9,7,4,8,3};
		int[] preorder = new int[]{8,7,9,4,3};
		TreeNode root = buildBST(inorder, preorder);
		System.out.println(root);

	}
	
	
	
	public static TreeNode buildBST(int inOrder[], int preOrder[]){
		return buildBST(inOrder, preOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
	}
	
	private static TreeNode buildBST(int inOrder[], int preOrder[], int preStart, int preEnd, int inStart, int inEnd){
		if(inStart > inEnd){ //leaf
			return null;
		} else {
			int rootVal = preOrder[preStart];
			int rootIndex =  Arrays.binarySearch(inOrder, rootVal);
			int len = rootIndex - inStart;
			TreeNode root = new TreeNode(rootVal);
			root.left = buildBST(inOrder, preOrder, preStart+1, preStart+len, inStart, rootIndex - 1);
			root.right = buildBST(inOrder, preOrder, preStart+len+1, preEnd, rootIndex + 1, inEnd);  
			return root;
		}
	}

}
