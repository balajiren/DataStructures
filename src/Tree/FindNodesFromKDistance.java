package Tree;
import java.util.*;

public class FindNodesFromKDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Map<TreeNode, TreeNode> parentMap;
	
	//Perform DFS and add create map in the form : key = node value =parent
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    	
    	 parentMap = new HashMap();
         dfs(root, null);
    	 Queue<TreeNode> queue = new LinkedList();
         queue.add(null);
         queue.add(target);

         Set<TreeNode> seen = new HashSet();
         seen.add(target);
         seen.add(null);

         int dist = 0;
         while (!queue.isEmpty()) {
             TreeNode node = queue.poll();
             if (node == null) {
                 if (dist == K) {
                     List<Integer> ans = new ArrayList();
                     for (TreeNode n: queue)
                         ans.add((Integer) n.val);
                     return ans;
                 }
                 queue.offer(null);
                 dist++;
             } else {
                 if (!seen.contains(node.left)) {
                     seen.add(node.left);
                     queue.offer(node.left);
                 }
                 if (!seen.contains(node.right)) {
                     seen.add(node.right);
                     queue.offer(node.right);
                 }
                 TreeNode par = parentMap.get(node);
                 if (!seen.contains(par)) {
                     seen.add(par);
                     queue.offer(par);
                 }
             }
             
         }

         return new ArrayList<Integer>();
    	
    	
    	
    }

    //Find the parent in order to calculate distance from parent
    public void dfs(TreeNode node, TreeNode parent) {
    	
    	if(node!=null) {
    	
    		parentMap.put(node,parent);
    		dfs(node.left, node);
    		dfs(node.right, node);
        	
    		
    	}
    	
   
    }

}
