package Tree;
import java.util.*;

public class ClosestLeafInBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//DFS and change to graph and then BFS search to find closest leaf
	 public int findClosestLeaf(TreeNode root, int k) {
	        Map<TreeNode, List<TreeNode>> graph = new HashMap();
	        dfs(graph, root, null);

	        Queue<TreeNode> queue = new LinkedList();
	        Set<TreeNode> seen = new HashSet();

	        for (TreeNode<Integer> node: graph.keySet()) {
            if (node != null && node.val == k) {
	                queue.add(node);
	                seen.add(node);
	            }
	        }

	        while (!queue.isEmpty()) {
	            TreeNode node = queue.poll();
	            if (node != null) {
	                if (graph.get(node).size() <= 1)
	                    return (Integer)node.val;
	                for (TreeNode nei: graph.get(node)) {
	                    if (!seen.contains(nei)) {
	                        seen.add(nei);
	                        queue.add(nei);
	                    }
	                }
	            }
	        }
	        throw null;
	    }
        //Get the parent node for each node and then use it find distance
	    public void dfs(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent) {
	        if (node != null) {
	            if (!graph.containsKey(node)) graph.put(node, new LinkedList<TreeNode>());
	            if (!graph.containsKey(parent)) graph.put(parent, new LinkedList<TreeNode>());
	            graph.get(node).add(parent);
	            graph.get(parent).add(node);
	            dfs(graph, node.left, node);
	            dfs(graph, node.right, node);
	        }
	    }

}
