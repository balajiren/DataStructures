package Tree;
import java.util.*;

public class RemoveNodeFromTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	List<TreeNode> result = new ArrayList<>();
    Deque<TreeNode> deque = new LinkedList<>();
    Set<Integer> deleteSet = new HashSet<>();
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null) return result;
        for(int i=0; i<to_delete.length; i++) {
            deleteSet.add(to_delete[i]);
        }
        deque.offer(root);
        while(!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if(!removeNode(node)) {
                result.add(node);
            }
        }
        return result;
    }
    
    public boolean removeNode(TreeNode node) {
        if(deleteSet.contains(node.val)) {
            if(node.left != null) deque.add(node.left);
            if(node.right != null) deque.add(node.right);
            return true;
        } else {
            if(node.left != null && removeNode(node.left)) {
                node.left = null;
            }
            if(node.right != null && removeNode(node.right)) {
                node.right = null;
            }
            return false;
        }
    }

}
