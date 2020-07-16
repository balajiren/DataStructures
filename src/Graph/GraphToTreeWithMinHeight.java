package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GraphToTreeWithMinHeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	        List<Integer> result = new ArrayList<>();
	        if (n <= 0) {
	            return result;
	        }
	         
	        // Corner case: there is a single node and no edge at all
	        if (n == 1 && edges.length == 0) {
	            result.add(0);
	            return result;
	        }
	         
	        // Step 1: construct the graph
	        List<Set<Integer>> adjList = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            adjList.add(new HashSet<>());
	        }
	         
	        for (int[] edge : edges) {
	            int from = edge[0];
	            int to = edge[1];
	            adjList.get(from).add(to);
	            adjList.get(to).add(from);
	        }
	         
	        // Remove leaf nodes
	        List<Integer> leaves = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            if (adjList.get(i).size() == 1) {
	                leaves.add(i);
	            }
	        }
	         
	        while (n > 2) {
	            // identify and remove all leaf nodes
	            n -= leaves.size();
	            List<Integer> newLeaves = new ArrayList<>();
	            for (int leaf : leaves) {
	                int neighbor = adjList.get(leaf).iterator().next();
	                adjList.get(neighbor).remove(leaf);
	                 
	                if (adjList.get(neighbor).size() == 1) {
	                    newLeaves.add(neighbor);
	                }
	            }
	             
	            leaves = newLeaves;
	        }
	         
	        return leaves;
	    }
	 
	 public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
	        if (n == 1) return Collections.singletonList(0);
	        List<Integer> leaves = new ArrayList<>();
	        List<Set<Integer>> adj = new ArrayList<>(n);
	        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
	        for (int[] edge : edges) {
	            adj.get(edge[0]).add(edge[1]);
	            adj.get(edge[1]).add(edge[0]);
	        }
	        for (int i = 0; i < n; ++i) {
	            if (adj.get(i).size() == 1) leaves.add(i);
	        }
	        while (n > 2) {
	            n -= leaves.size();
	            List<Integer> newLeaves = new ArrayList<>();
	            for (int i : leaves) {
	                int t = adj.get(i).iterator().next();
	                adj.get(t).remove(i);
	                if (adj.get(t).size() == 1) newLeaves.add(t);
	            }
	            leaves = newLeaves;
	        }
	        return leaves;
	    }

}
