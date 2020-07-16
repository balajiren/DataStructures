package Tree;

import java.lang.reflect.Array;
import java.util.Arrays;


//A Binary Tree node
class Node {

 String dataString;
 Node left;
 Node right;

 Node(String dataString) {
     this.dataString = dataString;
     //Be default left and right child are null. 
 }

 public String getDataString() {
     return dataString;
 }
}

public class PossibleInterpretationsOfDigits {
	
	
	  private static final String[] alphabet = {"", "a", "b", "c", "d", "e",
	        "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
	        "s", "t", "u", "v", "w", "x", "v", "z"};
	public static void main(String args[])
	{
		
		  int[] arr = {1, 1, 3, 4};
		  PrintAllInterpretations(arr);
		
	}
	
	public static void PrintAllInterpretations(int[] arr)
	{
		
	  Node root = CreateTree(0,"",arr);
		  // Step 2: Print Leaf nodes
        printleaf(root);
 
        System.out.println();  // Print new line
		
	}
	
	public static Node CreateTree(int data, String parentStr, int[] arr)
	{
		if(data > 26)
		{
			return null;
		}
		String strData = parentStr + alphabet[data];
		Node root = new Node(strData);
		
		if(arr.length !=0)
		{
			data= arr[0];
			
			int[] newarr = Arrays.copyOfRange(arr, 1, arr.length);
			
			root.left = CreateTree(data, strData, newarr);
			
		}
		
		 // right child will be null if size of array is 0 or 1
        if (arr.length > 1) {

            data = arr[0] * 10 + arr[1];

            // new array will be from index 2 to end as we 
            // are consuming first two index with this node
            int[] newArr = Arrays.copyOfRange(arr, 2, arr.length);

            root.right = CreateTree(data, strData, newArr);
        }
        return root;
	}
	
	 // To print out leaf nodes
    public static void printleaf(Node root) {
        if (root == null) 
            return;
 
        if (root.left == null && root.right == null) 
            System.out.print(root.getDataString() + "  ");
         
        printleaf(root.left);
        printleaf(root.right);
    }

}
