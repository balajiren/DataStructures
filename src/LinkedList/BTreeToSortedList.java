package LinkedList;

class LinkedList_Node
{
    public int val;
    public LinkedList_Node left;
    public LinkedList_Node right;

    public LinkedList_Node() {}

    public LinkedList_Node(int _val) {
        val = _val;
    }

    public LinkedList_Node(int _val,LinkedList_Node _left,LinkedList_Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class BTreeToSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	    LinkedList_Node first = null;
	    LinkedList_Node last = null;
	    public LinkedList_Node treeToDoublyList(LinkedList_Node root) {
	        if(root == null) {
	            return null;
	        }
	        helper(root);
	        last.right = first;
	        first.left = last;
	        return first;
	        
	    }
	    
	    public void helper(LinkedList_Node root) {
	        
	        if (root !=null) {
	            helper(root.left);
	            if(last!=null) {
	                last.right = root;
	                root.left = last;
	            }  else {
	                first = root;
	            }
	            last = root;
	            helper(root.right);
	        }
	        
	    }
	
	

}
