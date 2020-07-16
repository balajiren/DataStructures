package Tree;

import LinkedList.Node;

public class SortedArrayToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}
   
//	//Convert linked list to array
//	private LinkedListNode findMiddleElement(LinkedListNode head) {
//
//	    // The pointer used to disconnect the left half from the mid node.
//		LinkedListNode prevPtr = null;
//		LinkedListNode slowPtr = head;
//		LinkedListNode fastPtr = head;
//
//	    // Iterate until fastPr doesn't reach the end of the linked list.
//	    while (fastPtr != null && fastPtr.next != null) {
//	      prevPtr = slowPtr;
//	      slowPtr = slowPtr.next;
//	      fastPtr = fastPtr.next.next;
//	    }
//
//	    // Handling the case when slowPtr was equal to head.
//	    if (prevPtr != null) {
//	      prevPtr.next = null;
//	    }
//
//	    return slowPtr;
//	  }
//
//	  public TreeNode sortedListToBST(LinkedListNode head) {
//
//	    // If the head doesn't exist, then the linked list is empty
//	    if (head == null) {
//	      return null;
//	    }
//
//	    // Find the middle element for the list.
//	    ListNode mid = this.findMiddleElement(head);
//
//	    // The mid becomes the root of the BST.
//	    TreeNode node = new TreeNode(mid.val);
//
//	    // Base case when there is just one element in the linked list
//	    if (head == mid) {
//	      return node;
//	    }
//
//	    // Recursively form balanced BSTs using the left and right halves of the original list.
//	    node.left = this.sortedListToBST(head);
//	    node.right = this.sortedListToBST(mid.next);
//	    return node;
//	  }
//	}
	
	// O(N) time and space complexity
	public TreeNode<Integer> ArrayTOBST(int[] input,int startIndex, int endIndex,TreeNode<Integer> root)
	{
		if(startIndex > endIndex)
		{
			return null;
		}
		if(root == null)
		{
			return root;
		}
		int midIndex = (startIndex + endIndex)/2;
		
		root = new TreeNode(input[midIndex]);
		
		root.left = ArrayTOBST(input,startIndex,midIndex-1,root);
		root.right = ArrayTOBST(input,midIndex+1,endIndex,root);
		
		return root;
		 
	}
	


}
