package Tree;
import java.util.*;

public class SerializeAndDeseializeTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		String value = serialize(root);
		System.out.print(value);
		deserialize(value);

	}
	
	
	
	public static String rserialize(TreeNode root, String str) {
	    // Recursive serialization.
	    if (root == null) {
	      str += "null,";
	    } else {
	      str += str.valueOf(root.val) + ",";
	      str = rserialize(root.left, str);
	      str = rserialize(root.right, str);
	    }
	    return str;
	  }

	  // Encodes a tree to a single string.
	  public static String serialize(TreeNode root) {
	    return rserialize(root, "");
	  }
	
	  
	  public static TreeNode rdeserialize(List<String> l) {
		    // Recursive deserialization.
		    if (l.get(0).equals("null")) {
		      l.remove(0);
		      return null;
		    }

		    TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
		    l.remove(0);
		    root.left = rdeserialize(l);
		    root.right = rdeserialize(l);

		    return root;
		  }

		  // Decodes your encoded data to tree.
		  public static TreeNode deserialize(String data) {
		    String[] data_array = data.split(",");
		    List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
		    return rdeserialize(data_list);
		  }
	  
	  
	  
	//END
	  
	  
	  
	public static String serialize1(TreeNode root) {
	    if(root==null)
	        return null;
	 
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root);
	    StringBuilder sb = new StringBuilder();
	 
	    while(!stack.isEmpty()){
	        TreeNode h = stack.pop();   
	        if(h!=null){
	            sb.append(h.val+",");
	            stack.push(h.right);
	            stack.push(h.left);  
	        }else{
	            sb.append("#,");
	        }
	    }
	 
	    return sb.toString().substring(0, sb.length()-1);
	}
	
	// Decodes your encoded data to tree.
	public static TreeNode deserialize1(String data) {
	    if(data == null)
	        return null;
	 
	    int[] t = {0};
	    String[] arr = data.split(",");
	    TreeNode node = helper(arr, t);
	    Print_PreOrderTraversal(node);
	    return node;
	    
	}
	

	public static void Print_PreOrderTraversal(TreeNode root)
	{
		Stack<TreeNode> st= new Stack<TreeNode>();
	    StringBuilder sb = new  StringBuilder();

         st.push(root);
         sb.append("Deserialized preorder is:\n");
         
         while(!st.isEmpty())
         {
           TreeNode current = st.pop();
           sb.append(current.val + "->");
  
           if(current.right!=null)
           {
              st.push(current.right);
           }
           
           if(current.left!=null)
           {
              st.push(current.left);
           }
 
          }
		
		 System.out.print(sb.toString());
	}
	 
	public static TreeNode helper(String[] arr, int[] t){
	    if(arr[t[0]].equals("#")){
	        return null;
	    }
	 
	    TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));
	 
	    t[0]=t[0]+1;
	    root.left = helper(arr, t);
	    t[0]=t[0]+1;
	    root.right = helper(arr, t);
	 
	    return root;
	}

}
