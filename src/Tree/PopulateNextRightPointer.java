package Tree;
import java.util.*;

public class PopulateNextRightPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode Connect(TreeNode root) {
		if(root == null) {
			return null;
		}
		Queue<TreeNode> que = new LinkedList<TreeNode>(); 
		
		que.add(root);
		
		while(!que.isEmpty()) {
			
			int size = que.size();
			
			for(int i=0;i<size;i++) {
				
				TreeNode node = que.poll();
				
				if(i < size -1){
					node.next = que.peek();
				}
				
				if(node.left!=null) {
					que.add(node.left);
				}
				
				if(node.right!=null) {
					que.add(node.right);
				}
				
				
			}

			
		}
		
		return root;
	}

}
