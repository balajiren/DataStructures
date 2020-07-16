package Tree;
//
//Input: "4(2(3)(1))(6(5))"
//Output: return the tree root node representing the following tree:
//
//       4
//     /   \
//    2     6
//   / \   / 
//  3   1 5   
public class ConstructBinaryTreeFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private int index;
	
	public int getValue(String s) {
		int sign= 1;
		if(s.charAt(index) == '-') {
			sign=-1;
			index++;
		}
		int num = 0;
		while(s.charAt(index)!=')' && s.charAt(index)!='(' && index < s.length()) {
			num = num * 10 + s.charAt(index) - '0';
			index++;
		}
	
		return num * sign;
	}
	
	public TreeNode<Integer> dfs(String s) {
		
		TreeNode<Integer> root = new TreeNode<Integer>(null);
		TreeNode<Integer> node = null;
		if(s.charAt(index) == '(') {
			index++;
			node = new TreeNode(getValue(s));
			if(s.charAt(index) != ')') {
				node.left = dfs(s);
				node.right = dfs(s);
			}
			index++;
		}
		
		return root;
	}
	
	public TreeNode<Integer> StringToTree(String s) {
	 
		if(s.length() == 0) {
			return null;
		}

		TreeNode root = new TreeNode<Integer>(getValue(s));
		root.left = dfs(s);
		root.right = dfs(s);

		return root;
		
	}
	

}
