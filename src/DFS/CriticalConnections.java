package DFS;

import java.util.*;

public class CriticalConnections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//  Detect cycles in undirected graph. Simply use dfs algorithm and mark all visited nodes.
//	If current dfs reaches a visited node, we find a cycle.
//	Assign a consecutive id to each node when running dfs, then we know order of any two nodes.
//	If a neighbour of current node have never seen a node whoes id is smaller than current node,
//	we know there is a critical path. Otherwise there must be at least one cycle.
//	We give smallest id to all nodes who are in the same cycle.
private int time;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new LinkedList<>();
        if (n <= 0) return ans;
        // build graph
        Node[] graph = new Node[n];
        for (int i = 0; i < n; i++) graph[i] = new Node();
        for (List<Integer> list : connections) {
            int node1 = list.get(0), node2 = list.get(1);
            graph[node1].neighbours.add(node2);
            graph[node2].neighbours.add(node1);
        }
        dfs(ans, 0, 0, graph);
        return ans;
    }
    

    private int dfs(List<List<Integer>> ans, int curr, int from, Node[] graph) {
        graph[curr].id = time++;
        int lowestId = graph[curr].id;
        for (int next : graph[curr].neighbours) {
            if (next == from) continue;
            // unvisited node
            if (graph[next].id == -1) {
                int temp = dfs(ans, next, curr, graph);
                lowestId = Math.min(temp, lowestId);
                if (temp > graph[curr].id) {
                    List<Integer> list = new LinkedList<>();
                    list.add(curr); 
                    list.add(next);
                    ans.add(list);
                }
            }
            // visited node
            else {
                lowestId = Math.min(graph[next].id, lowestId);
            }
        }
        graph[curr].id = lowestId;
        // System.out.println(curr + " " + graph[curr].id);
        return lowestId;
    }
    
    private class Node {
		// Set<Integer> neighbours = new HashSet<>();
        List<Integer> neighbours = new LinkedList<>();
        int id = -1;
    }

}
